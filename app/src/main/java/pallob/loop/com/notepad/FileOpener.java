package pallob.loop.com.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pallob on 5/17/18.
 */

public class FileOpener extends Activity {
    int count = 0;
    Intent intent=new Intent();
    @BindView(R.id.filedirlist)
    ListView filedirlist;
    @BindView(R.id.filehome)
    Button filehome;
    @BindView(R.id.filecancel)
    Button filecancel;
    @BindView(R.id.fileback)
    Button fileback;

    String path, folder, mypath, FileName;
    ArrayList<File> fileobject;
    ArrayList<Integer> imgIcon;
    File test, file, ob;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fileopener);
        ButterKnife.bind(this);
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

    @OnClick({R.id.filehome, R.id.filecancel, R.id.fileback})
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
            case R.id.filecancel:
                intent.putExtra("empty","");
                setResult(2,intent);
                finish();
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

                    intent.putExtra("Directory",Directorypath.get(position));
                    setResult(1,intent);
                    finish();

                } else {
                    try{
                        File f = new File(Directorypath.get(position));
                        fileback.setEnabled(true);
                        count++;
                        fileobject.add(count, f);
                        ListViewer(f);

                    }catch (Exception e){

                    }


                }


            }
        });


    }



}
