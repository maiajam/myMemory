package com.maiajam.mymemory.activities;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.fragments.AllMemoriesFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_memories);
        HelperMethodes.beginTransaction(getSupportFragmentManager().beginTransaction(),
                new AllMemoriesFragment(),R.id.allmemories_fame);
    }


}
