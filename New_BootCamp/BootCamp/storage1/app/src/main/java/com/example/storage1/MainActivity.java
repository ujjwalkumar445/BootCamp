package com.example.storage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button submit,retreive,write,read;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.edt1);
        submit = findViewById(R.id.sub_btn);
        retreive = findViewById(R.id.ret_btn);
        read = findViewById(R.id.readbtn);
        write = findViewById(R.id.writebtn);
        sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.equals("")){
                    editText.setError("please enter text");
                } else {
                    editor.putString("text",text).commit();
                    Toast.makeText(MainActivity.this, "text=="+text, Toast.LENGTH_SHORT).show();

                }
            }
        });

        retreive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = sharedPreferences.getString("text","");
                Toast.makeText(MainActivity.this, "text=="+text, Toast.LENGTH_SHORT).show();
                textView.setText(text);
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.equals("")){
                    editText.setError("enter the text");
                } else {
                    writetofile(text);
                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readtofile();
            }
        });
    }

    private void writetofile(String text) {
        try {
            FileOutputStream fOut = openFileOutput("file.txt", Context.MODE_PRIVATE);
            fOut.write(text.getBytes());
            Toast.makeText(MainActivity.this, "text writtten sucessfully in file", Toast.LENGTH_SHORT).show();

            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readtofile(){
        FileInputStream fin = null;
        int c;
        String temp="";
        try {
            fin = openFileInput("file.txt");
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        editText.setText("");
        Toast.makeText(MainActivity.this,"text=="+temp,Toast.LENGTH_SHORT).show();


    }
}
