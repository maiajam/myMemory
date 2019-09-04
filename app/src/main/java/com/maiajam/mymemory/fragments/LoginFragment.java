package com.maiajam.mymemory.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;

import static com.maiajam.mymemory.HelperMethodes.checkValidate;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private EditText loginEmail_ed,loginPass_ed;
    private Button login_b;
    private String email;
    private String pass;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return initialView(inflater,container);
    }

    private View initialView(LayoutInflater inflater, ViewGroup container) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        loginEmail_ed =(EditText)view.findViewById(R.id.loginEmail);
        loginPass_ed =(EditText)view.findViewById(R.id.loginpaswd);

        login_b =(Button)view.findViewById(R.id.btnLogIn);

        login_b.setOnClickListener(this);
       return view;
    }

    @Override
    public void onClick(View v) {
        email = loginEmail_ed.getText().toString();
        pass = loginPass_ed.getText().toString();
        checkValidate(email,pass);
    }
}
