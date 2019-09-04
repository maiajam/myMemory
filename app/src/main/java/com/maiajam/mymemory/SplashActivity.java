package com.maiajam.mymemory;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.maiajam.mymemory.fragments.SignUpFragment;


import static com.maiajam.mymemory.HelperMethodes.beginTransaction;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);


        beginTransaction(getSupportFragmentManager().beginTransaction(),new SignUpFragment(),R.id.contianer);
    }


}
