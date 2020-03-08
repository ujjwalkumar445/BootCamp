package com.example.androidsecondexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText phone;
    EditText password;
    Button signupbtn;
    Button cancelbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        signupbtn = findViewById(R.id.signup_btn);
        cancelbtn = findViewById(R.id.cancel_btn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void validate(){
        if(username.length() == 0){
            username.setError(getString(R.string.msg_1));
        }else if (email.length() == 0){
            email.setError(getString(R.string.msg_2));
        }else if (phone.length() == 0){
            phone.setError(getString(R.string.msg_3));
        } else if (phone.length() == 10){
            phone.setError(getString(R.string.msg_7));
        } else if (password.length() == 0){
            password.setError(getString(R.string.msg_4));
        }else if(!validEmail(email.getText().toString())){
            email.setError(getString(R.string.msg_5));
        }else{
            signup();
        }
    }

    private void signup() {
        Intent intent = new Intent(MainActivity.this,SecondPage.class);
        Bundle bundle = new Bundle();
        bundle.putString("Username",username.getText().toString());
        bundle.putString("email",email.getText().toString());
        bundle.putString("phone",phone.getText().toString());
        bundle.putString("password",password.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean validEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
