package com.example.storage2_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private  EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        name = findViewById(R.id.name);
        phone =findViewById(R.id.phone);
        address = findViewById(R.id.address);


        Intent intent = getIntent();
        if(intent.hasExtra("employeeId")){
            setTitle("Edit Employee");
            name.setText(intent.getStringExtra("employeeName"));
            phone.setText(intent.getStringExtra("employeePhone"));
            address.setText(intent.getStringExtra("employeeAddress"));
        }
        else {
            setTitle("Add Employee");
        }
    }

    //saving employee detail to the room
    public void saveEmployee(){
        String employeename = name.getText().toString();
        String employeephone = phone.getText().toString();
        String employeeaddress = address.getText().toString();

        if(employeename.trim().isEmpty() || employeephone.trim().isEmpty() || employeeaddress.trim().isEmpty()){
            Toast.makeText(this, getString(R.string.item_error_message), Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent();
        intent.putExtra("employeeName",employeename);
        intent.putExtra("employeePhone",employeephone);
        intent.putExtra("employeeAddress",employeeaddress);

        int employeeId = getIntent().getIntExtra("employeeId", -1);
        if(employeeId != -1) {
            intent.putExtra("employeeId", employeeId);
        }
        setResult(RESULT_OK,intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_employee) {
            saveEmployee();
            return true;
        }
        else if(item.getItemId() == R.id.cancel) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
