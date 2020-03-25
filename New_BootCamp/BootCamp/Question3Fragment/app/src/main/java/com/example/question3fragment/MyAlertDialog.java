package com.example.question3fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyAlertDialog extends DialogFragment {

    public static MyAlertDialog newInstance(String title, String message) {
        MyAlertDialog frag = new MyAlertDialog();
        Bundle args = new Bundle();
        args.putString("title",title);
        args.putString("message",message);
        frag.setArguments(args);
        return frag;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        String message = getArguments().getString("message");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();
                    }
                });
        alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(dialog != null){
                Toast.makeText(getContext(), "CANCEL", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
            }
        });
        return  alertDialogBuilder.create();
    }
}
