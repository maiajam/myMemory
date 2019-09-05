package com.maiajam.mymemory.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.viewModel.LoginViewModel;

import static com.maiajam.mymemory.HelperMethodes.checkValidate;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private EditText loginEmail_ed, loginPass_ed;
    private Button login_b;
    private String email;
    private String pass;
    private View view;
    private LoginViewModel loginViewModel;
    private boolean validateResult;

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
        initialView(inflater, container);
        doBussines();
        return view;
    }

    private void doBussines() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        validateResult = loginViewModel.checkValidate(email, pass);

        if (validateResult) {
            if (loginViewModel.Login(email, pass)) {

                Toast.makeText(getActivity(), getString(R.string.LoginSuccess_TOast), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getActivity(), getString(R.string.LoginFaild_TOast), Toast.LENGTH_LONG).show();
            }

        }
    }

    private void initialView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        loginEmail_ed = (EditText) view.findViewById(R.id.loginEmail);
        loginPass_ed = (EditText) view.findViewById(R.id.loginpaswd);

        login_b = (Button) view.findViewById(R.id.btnLogIn);
        login_b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        email = loginEmail_ed.getText().toString();
        pass = loginPass_ed.getText().toString();

    }
}
