package pallob.loop.com.notepad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PopupWindow window = null, window1 = null, window2 = null, window3 = null;
    String FilePath;
    @BindView(R.id.B1)
    Button B1;
    @BindView(R.id.B2)
    Button B2;
    @BindView(R.id.B3)
    Button B3;
    @BindView(R.id.B4)
    Button B4;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        hideKeyboard(this);

        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenu().clear();
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.mymenu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });


    }

    @OnClick({R.id.B1, R.id.B2, R.id.B3, R.id.B4, R.id.editText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.B1:

                if (window == null) {
                    Checker();
                    MenuB1();


                }

                break;
            case R.id.B2:
                if (window1 == null) {
                    Checker();
                    MenuB2();
                }
                break;
            case R.id.B3:
                if (window2 == null) {
                    Checker();
                    MenuB3();
                }
                break;
            case R.id.B4:
                if (window3 == null) {
                    Checker();
                    MenuB4();
                }
                break;
            case R.id.editText:
                Checker();

                break;
        }
    }


    public void Checker() {

        if (window != null) {
            window.dismiss();
            window = null;

        } else if (window1 != null) {
            window1.dismiss();
            window1 = null;


        } else if (window2 != null) {
            window2.dismiss();
            window2 = null;

        } else if (window3 != null) {
            window3.dismiss();
            window3 = null;

        } else {
            window = null;
            window1 = null;
            window2 = null;
            window3 = null;
        }


    }

    public void MenuB1() {


        Button Cl, Ne, Op, Sa, Saas;
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popup = inflater.inflate(R.layout.filemenu, null);
        window = new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.showAsDropDown(B1, 3, 2);
        Cl = popup.findViewById(R.id.clear);
        Cl.setOnClickListener(MainActivity.this);
        Ne = popup.findViewById(R.id.newfile);
        Ne.setOnClickListener(MainActivity.this);
        Op = popup.findViewById(R.id.open);
        Op.setOnClickListener(MainActivity.this);
        Sa = popup.findViewById(R.id.save);
        Sa.setOnClickListener(MainActivity.this);
        Saas = popup.findViewById(R.id.save_as);
        Saas.setOnClickListener(MainActivity.this);




    }

    public void MenuB2() {

        Button undo,redo,copy,cut,paste,selectall;
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popup = inflater.inflate(R.layout.editmenu, null);
        window1 = new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window1.showAsDropDown(B2, 2, 2);
        undo=popup.findViewById(R.id.undo);
        undo.setOnClickListener(MainActivity.this);
        redo=popup.findViewById(R.id.redo);
        redo.setOnClickListener(MainActivity.this);
        copy=popup.findViewById(R.id.copy);
        copy.setOnClickListener(MainActivity.this);
        cut=popup.findViewById(R.id.cut);
        cut.setOnClickListener(MainActivity.this);
        paste=popup.findViewById(R.id.paste);
        paste.setOnClickListener(MainActivity.this);
        selectall=popup.findViewById(R.id.selectall);
        selectall.setOnClickListener(MainActivity.this);

    }

    public void MenuB3() {

        Button find,replace,gotoline;
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popup = inflater.inflate(R.layout.searchmenu, null);
        window2 = new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window2.showAsDropDown(B3, 2, 2);
        find=popup.findViewById(R.id.find);
        find.setOnClickListener(MainActivity.this);
        replace=popup.findViewById(R.id.replace);
        replace.setOnClickListener(MainActivity.this);
        gotoline=popup.findViewById(R.id.gotoline);
        gotoline.setOnClickListener(MainActivity.this);
    }

    public void MenuB4() {
        Button readmode,settings,exit;
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popup = inflater.inflate(R.layout.moremenu, null);
        window3 = new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window3.showAsDropDown(B4, 1, 2);
        readmode=popup.findViewById(R.id.readmode);
        readmode.setOnClickListener(MainActivity.this);
        settings=popup.findViewById(R.id.settings);
        settings.setOnClickListener(MainActivity.this);
        exit=popup.findViewById(R.id.exit);
        exit.setOnClickListener(MainActivity.this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
               editText.setText("");
               window.dismiss();
               window=null;
                break;
            case R.id.newfile:
               startActivity(new Intent(MainActivity.this,MainActivity.class));
                window.dismiss();
                finish();
                break;
            case R.id.open:
                startActivityForResult(new Intent(MainActivity.this,FileOpener.class),1);
                window.dismiss();
                window=null;
                break;
            case R.id.save:
                window.dismiss();
                window=null;
                break;
            case R.id.save_as:
                Intent intent1=new Intent(MainActivity.this,FileBrowser.class);
                intent1.putExtra("text",editText.getText().toString());
                startActivity(intent1);
                window.dismiss();
                window=null;
                break;
            case R.id.undo:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redo:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cut:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.paste:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.selectall:
                editText.selectAll();
                window1.dismiss();
                window1=null;
                break;
            case R.id.find:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.replace:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gotoline:
                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;
            case R.id.readmode:
               Intent intent=new Intent(MainActivity.this,ReadMode.class);
               intent.putExtra("Display",editText.getText().toString());
               startActivity(intent);
               window3.dismiss();
               window3=null;

                break;
            case R.id.settings:
                startActivity(new Intent(MainActivity.this,Settings.class));
                window3.dismiss();
                window3=null;
                break;
            case R.id.exit:
               finish();
                break;


        }

    }
    public static void hideKeyboard( Activity activity ) {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService( Context.INPUT_METHOD_SERVICE );
        View f = activity.getCurrentFocus();
        if( null != f && null != f.getWindowToken() && EditText.class.isAssignableFrom( f.getClass() ) )
            imm.hideSoftInputFromWindow( f.getWindowToken(), 0 );
        else
            activity.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FilePath=data.getStringExtra("Directory");
        if (requestCode==1){
            String aBuffer = "";
            try {
                File myFile = new File(FilePath);
                FileInputStream fIn;
                fIn = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
                String aDataRow = "";
                while ((aDataRow = myReader.readLine()) != null) {
                    aBuffer += aDataRow;
                }
                editText.setText(aBuffer);
                myReader.close();
            }catch (Exception e) {


            }
        }else {

        }

    }
}
