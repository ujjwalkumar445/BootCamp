package com.example.question3fragment;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;

public class MySetting extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.setting_screen,rootKey);

    }
}
