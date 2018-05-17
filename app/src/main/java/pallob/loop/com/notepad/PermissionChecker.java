package pallob.loop.com.notepad;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PermissionChecker extends AppCompatActivity {

    public static final int RequestPermissionCode = 12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT < 23) {
            Intent intent1 = new Intent(PermissionChecker.this, MainActivity.class);
            startActivity(intent1);
            finish();

        } else {
            if (CheckingPermissionIsEnabledOrNot()) {
                Intent intent1 = new Intent(PermissionChecker.this, MainActivity.class);
                startActivity(intent1);
                finish();
            } else {
                RequestMultiplePermission();
            }


        }
    }
    private void RequestMultiplePermission() {

        ActivityCompat.requestPermissions(PermissionChecker.this, new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,}, RequestPermissionCode);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case RequestPermissionCode:

                if (grantResults.length > 0) {
                    boolean readexternalstorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean writeexternalstorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (readexternalstorage && writeexternalstorage) {

                        Intent intent1 = new Intent(PermissionChecker.this, MainActivity.class);

                        startActivity(intent1);
                        finish();

                    } else {

                        WarningDisplay();
                    }
                }

                break;
        }
    }

    public boolean CheckingPermissionIsEnabledOrNot() {

        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int ForthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);

        return ThirdPermissionResult == PackageManager.PERMISSION_GRANTED && ForthPermissionResult == PackageManager.PERMISSION_GRANTED ;


    }


    public void WarningDisplay(){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Without permission App Can't proceed!!!!");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(PermissionChecker.this,PermissionChecker.class));
                finish();
            }
        });

        builder.show();
    }




}