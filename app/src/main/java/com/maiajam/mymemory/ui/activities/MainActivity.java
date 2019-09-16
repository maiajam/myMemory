package com.maiajam.mymemory.ui.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.ui.fragments.AllMemoriesFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_memories);
        HelperMethodes.beginTransaction(getSupportFragmentManager().beginTransaction(),
                new AllMemoriesFragment(),R.id.allmemories_fame);
    }


}
