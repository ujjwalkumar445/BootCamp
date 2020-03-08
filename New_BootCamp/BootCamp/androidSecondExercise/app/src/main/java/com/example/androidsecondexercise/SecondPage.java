package com.example.androidsecondexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class SecondPage extends AppCompatActivity {

    TextView Info;
    EditText link;

    private static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        String username = getIntent().getExtras().getString("Username");
        String email = getIntent().getExtras().getString("Email Id");
        String phone = getIntent().getExtras().getString("Phone number");
        String password = getIntent().getExtras().getString("Password");
        Info = findViewById(R.id.info);
        Info.setText("User Name:" + username+ "\n" +"Email: " + email + "\n" +
                "Phone number: " + phone + "\n" +
                "Password: " + password );

        link = findViewById(R.id.link);
        findViewById(R.id.web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(link.getText().length() == 0){
                    View view = findViewById(R.id.secondPage);
                    Snackbar.make(view, getString(R.string.msg_8), Snackbar.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+link.getText()));
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(ContextCompat.checkSelfPermission(SecondPage.this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                      requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CODE);
                  }
              }
              else {
                  Toast.makeText(getApplicationContext(), "camera permission granted", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "camera Permission granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
