package com.example.question4fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.res.Configuration;
import android.os.Bundle;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    fragment2 fragment2;
    fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment1 = new fragment1();
        MainActivity activity = MainActivity.this;
        int value = activity.getResources().getConfiguration().orientation;
        if (value == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.add(R.id.list, fragment1);
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.replace(R.id.list,fragment1);
            fragmentTransaction.commit();

        }
    }
}