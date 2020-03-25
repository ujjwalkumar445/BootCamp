package com.example.question3fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_menu){
            Toast.makeText(this, "Preference setting", Toast.LENGTH_LONG).show();
            Fragment mySetting = new MySetting();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.myLayout,mySetting,"setting_fragment");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(View view) {
        FragmentManager fm = getSupportFragmentManager();
        MyAlertDialog alertDialog = MyAlertDialog.newInstance("MyDialog","Hi! Are you sure you want to continue?");
        alertDialog.show(fm, "TAG");
    }
}
