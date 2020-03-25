package com.example.question4fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment2 extends Fragment {
TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment2,container,false);
        text=(TextView)view1.findViewById(R.id.text);
        int arg=getArguments().getInt("key");
        switch (arg)
        {
            case 0:
                text.setText("ujjwal ");
                break;
            case 1:
                text.setText("Bharat");
                break;
            case 2:
                text.setText("Akaanksha");
                break;
            case 3:
                text.setText("Astha");
                break;
            case 4:
                text.setText("Priya");
                break;
            case 5:
                text.setText("Tanvi");
                break;
            case 6:
                text.setText("Naveen");
                break;
            default:
                text.setText("Ashutosh");
                break;

        }

        return  view1;
    }
}
