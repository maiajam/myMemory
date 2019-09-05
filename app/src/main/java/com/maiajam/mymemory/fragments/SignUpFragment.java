package com.maiajam.mymemory.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.listners.OnClickListener;
import com.maiajam.mymemory.viewModel.SignUpViewModel;

import static com.maiajam.mymemory.FiberBaseFunctions.signUpNow;
import static com.maiajam.mymemory.HelperMethodes.checkValidate;


public class SignUpFragment extends Fragment implements View.OnClickListener {


    private EditText loginEmailEdt,loginPassEdt;
    private Button loginBt;
    private SignUpViewModel signUpViewModel;
    private String email,pass;
    private OnClickListener clickObject;

    public SignUpFragment() {
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginEmailEdt= (EditText)view.findViewById(R.id.loginEmail);
        loginPassEdt= (EditText)view.findViewById(R.id.loginpaswd);

        loginBt= (Button)view.findViewById(R.id.btnLogIn);


        loginBt.setOnClickListener(this);

        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);

        return view;
    }


    private void signUp() {
        email = loginEmailEdt.getText().toString();
        pass = loginPassEdt.getText().toString();
        if( signUpViewModel.checkValidate(email,pass))
        {
            signUpViewModel.SignUp(email,pass);
        }
    }


    @Override
    public void onClick(View v) {

        signUp();
    }
}
