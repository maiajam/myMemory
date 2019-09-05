package com.maiajam.mymemory.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.fragments.LoginFragment;

public class AllMemoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_memories);

        HelperMethodes.beginTransaction(getSupportFragmentManager().beginTransaction(),
                new LoginFragment(),
                R.id.allmemories_fame);
    }
}
