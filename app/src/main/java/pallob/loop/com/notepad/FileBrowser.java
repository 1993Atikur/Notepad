package pallob.loop.com.notepad;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pallob on 4/19/18.
 */

public class FileBrowser extends Activity {
    String printabletext="";
    int count = 0;
    @BindView(R.id.filehome)
    Button filehome;
    @BindView(R.id.fileback)
    Button fileback;
    @BindView(R.id.filedirlist)
    ListView filedirlist;
    @BindView(R.id.filename)
    EditText filename;
    @BindView(R.id.filesave)
    Button filesave;
    @BindView(R.id.filecancel)
    Button filecancel;
    @BindView(R.id.newfolder)
    Button newfolder;
    @BindView(R.id.mainlayout)
    LinearLayout mainlayout;
    @BindView(R.id.layoutprogress)
    LinearLayout layoutprogress;

    String path, folder, mypath, FileName;
    ArrayList<File> fileobject;
    ArrayList<Integer> imgIcon;
    File test, file, ob;
    @BindView(R.id.spinner)
    Spinner spinner;

    String type=".txt";
    String []extension={".txt","ALL"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filebrowser);
        ButterKnife.bind(this);
        Intent intent=getIntent();

       printabletext= intent.getStringExtra("text");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FileBrowser.this, android.R.layout.simple_spinner_item,extension);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
               type=extension[position];

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        fileobject = new ArrayList<>();
        imgIcon = new ArrayList<>();
        imgIcon.add(0, R.drawable.folder);
        imgIcon.add(1, R.drawable.text);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        file = new File(path);
        fileobject.add(0, file);
        ListViewer(fileobject.get(0));

        fileback.setEnabled(false);
    }

    @OnClick({R.id.filehome, R.id.fileback, R.id.filesave, R.id.filecancel, R.id.newfolder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filehome:
                try {
                    count = 0;
                    File file1 = new File(path);
                    fileobject.clear();
                    fileobject.add(file1);
                    ListViewer(fileobject.get(0));
                }catch (Exception e){

                }
                break;


            case R.id.fileback:
                try {
                    count--;
                    if (count == 0) {
                        File file = new File(path);
                        ListViewer(file);
                        fileback.setEnabled(false);
                    } else {
                        ListViewer(fileobject.get(count));
                        fileobject.remove(count);
                        fileback.setEnabled(true);

                    }
                }catch (Exception e){

                }
                break;


            case R.id.filesave:

                FileName = filename.getText().toString()+type;
                if (count == 0) {
                    SaverAsync async = new SaverAsync(file, FileName);
                    async.execute();

                } else {

                    ob = fileobject.get(count);
                    test = new File(ob.getAbsolutePath(), FileName);
                    SaverAsync async = new SaverAsync(test, FileName);
                    async.execute();
                }
                Toast.makeText(this, "Save Successfully", Toast.LENGTH_SHORT).show();
                finish();


                break;
            case R.id.filecancel:
                finish();
                break;
            case R.id.newfolder:
                if (count == 0) {
                    NewFolder(file);
                } else {
                    NewFolder(fileobject.get(count));

                }

                break;
        }
    }


    public void ListViewer(File reciever) {


        final File files[] = reciever.listFiles();
        ArrayList<Integer> DirIcon = new ArrayList<>();
        final ArrayList<String> Directory = new ArrayList<>();
        final ArrayList<String> Directorypath = new ArrayList<>();
        final ArrayList<String> temdir = new ArrayList<>();
        final ArrayList<String> tempfile = new ArrayList<>();
        final ArrayList<String> temdirpath = new ArrayList<>();
        final ArrayList<String> tempfilepath = new ArrayList<>();

        final ArrayList<String> tempfiledoc = new ArrayList<>();
        final ArrayList<String> tempfiletext = new ArrayList<>();
        final ArrayList<String> tempfilepathdoc = new ArrayList<>();
        final ArrayList<String> tempfilepathtext = new ArrayList<>();





        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                temdir.add(files[i].getName());
                temdirpath.add(files[i].getAbsolutePath());


            } else {
                 if(files[i].getName().contains(".txt")){

                    tempfiletext.add(files[i].getName());
                    tempfilepathtext.add(files[i].getAbsolutePath());

                }else {
                    continue;
                }


            }

        }
        for (int i = 0; i < temdir.size(); i++) {
            Directory.add(temdir.get(i));
            DirIcon.add(imgIcon.get(0));
            Directorypath.add(temdirpath.get(i));

        }

        for (int i = 0; i < tempfiletext.size(); i++) {
            Directory.add(tempfiletext.get(i));
            DirIcon.add(imgIcon.get(1));
            Directorypath.add(tempfilepathtext.get(i));

        }

        FileAdapter adapter = new FileAdapter(this, Directory, DirIcon);
        filedirlist.setAdapter(adapter);

        filedirlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (Directory.get(position).contains(".txt")) {


                } else {
                    File f = new File(Directorypath.get(position));
                    fileback.setEnabled(true);
                    count++;
                    fileobject.add(count, f);
                    ListViewer(f);


                }


            }
        });


    }


    public void NewFolder(final File file) {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.folderoption);
        dialog.setCancelable(false);
        dialog.show();
        Button create = dialog.findViewById(R.id.foldercreate);
        Button cancel = dialog.findViewById(R.id.foldercancel);
        final EditText foldername = dialog.findViewById(R.id.foldername);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                folder = foldername.getText().toString();
                mypath = file.getAbsolutePath();
                mypath = mypath + File.separator + folder;
                final File f = new File(mypath);
                if (!f.exists()) {
                    f.mkdir();
                    ListViewer(file);
                    Toast.makeText(FileBrowser.this, "Folder Created", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(FileBrowser.this);

                    builder.setMessage("\tFollowing Folder name exist.\n\tDo you want to override??");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Override", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog1, int which) {
                            f.delete();
                            f.mkdir();
                            ListViewer(file);
                            Toast.makeText(FileBrowser.this, " Folder Created", Toast.LENGTH_SHORT).show();
                            dialog1.cancel();
                            dialog.dismiss();


                        }
                    });
                    builder.setNegativeButton("Rename", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog1, int which) {
                            dialog1.cancel();
                        }
                    });

                    builder.show();

                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    public class SaverAsync extends AsyncTask<String, String, String> {


        File fp;
        String filename;

        public SaverAsync(File f, String filename) {
            this.fp = f;
            this.filename = filename;
            mainlayout.setVisibility(View.GONE);
            layoutprogress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

                DocTxtAllFile(fp,filename);

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            layoutprogress.setVisibility(View.GONE);
            mainlayout.setVisibility(View.VISIBLE);

        }
    }


    public void DocTxtAllFile(File fe,String fileName){
        File f=null;


        if(fe.getAbsolutePath().contains(".")){

           f=new File(fe.getAbsolutePath());
        }else {
            f=new File(fe.getAbsolutePath(),fileName);
        }

        try {
            f.createNewFile();
            FileOutputStream outputStream=new FileOutputStream(f);
            OutputStreamWriter writer=new OutputStreamWriter(outputStream);
            writer.append(printabletext);
            writer.close();
            outputStream.close();

        }catch (Exception e){

        }




    }

    @Override
    public void onBackPressed() {

    }
}



