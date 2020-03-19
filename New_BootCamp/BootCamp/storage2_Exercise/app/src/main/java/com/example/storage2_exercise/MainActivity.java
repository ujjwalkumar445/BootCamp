package com.example.storage2_exercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListItemClickListener{
    private EmViewModel viewModel;

    private static final int ADD_REQUEST_CODE = 1;
    private static final int UPDATE_ACTIVITY_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();

        FloatingActionButton floatingActionButton = findViewById(R.id.add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });
    }

    /**
     * Setting up recycler view
     */
    private void initRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final myAdapter adapter = new myAdapter(this);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(EmViewModel.class);
        viewModel.getAllEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                adapter.setList(employees);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == ADD_REQUEST_CODE && resultCode == RESULT_OK) {
            String employeeName = intent.getStringExtra("employeeName");
            String employeePhone = intent.getStringExtra("employeePhone");
            String employeeAddress = intent.getStringExtra("employeeAddress");

            Employee employee = new Employee(employeeName, employeePhone, employeeAddress);
            viewModel.insert(employee);
            Toast.makeText(this, employeeName + getString(R.string.insert_message), Toast.LENGTH_LONG).show();


            Toast.makeText(getApplicationContext(), R.string.save, Toast.LENGTH_LONG).show();


        } else if (requestCode == UPDATE_ACTIVITY_CODE && resultCode == RESULT_OK) {
            int id = intent.getIntExtra("employeeId", -1);
            if (id == -1) {
                Toast.makeText(this, "Employee can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String employeeName = intent.getStringExtra("employeeName");
            String employeePhone = intent.getStringExtra("employeePhone");
            String employeeAddress = intent.getStringExtra("employeeAddress");
            Employee employee = new Employee(employeeName, employeePhone, employeeAddress);
            employee.setId(id);

            viewModel.update(employee);
            Toast.makeText(this, employeeName + getString(R.string.update_message), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.not_save, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDelete(Employee employee, int position) {
        viewModel.delete(employee);
        Toast.makeText(this, employee.getName() + getString(R.string.delete_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onEdit(Employee employee, int position) {
        Intent intent = new Intent(MainActivity.this, AddItem.class);
        intent.putExtra("employeeId", employee.getId());
        intent.putExtra("employeeName", employee.getName());
        intent.putExtra("employeePhone", employee.getPhone());
        intent.putExtra("employeeAddress", employee.getAddress());
        startActivityForResult(intent, UPDATE_ACTIVITY_CODE);
    }

}

