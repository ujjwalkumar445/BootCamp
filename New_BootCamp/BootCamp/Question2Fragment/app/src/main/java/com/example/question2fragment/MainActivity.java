package com.example.question2fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAINACTIVITY";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        fragment = new Fragment();
        fragment2 = new Fragment2();
    }

    public void ADD(View view) {
        if (!fragment.isAdded()) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment, fragment, "fragment");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void REPLACE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment2, "Fragment2");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void HIDE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(fragment);
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.hide(fragment2);
            fragmentTransaction.commit();
        }
    }

    public void SHOW(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.show(fragment2);
            fragmentTransaction.commit();
        }
    }

    public void REMOVE(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.remove(fragment2);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }
}
