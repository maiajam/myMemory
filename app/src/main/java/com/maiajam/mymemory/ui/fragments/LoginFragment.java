package com.maiajam.mymemory.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.maiajam.mymemory.GlobalValueSaver;
import com.maiajam.mymemory.Helper.Constant;
import com.maiajam.mymemory.HelperMethodes;
import com.maiajam.mymemory.R;
import com.maiajam.mymemory.ui.activities.AllMemoriesActivity;
import com.maiajam.mymemory.ui.viewModel.LoginViewModel;


public class LoginFragment extends Fragment implements View.OnClickListener {


    private EditText loginEmail_ed, loginPass_ed;
    private Button login_b;
    private String email;
    private String pass;
    private View view;
    private LoginViewModel loginViewModel;
    private int validateResult;
    private TextView goToSignUp;

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


    private void initialView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        loginEmail_ed = (EditText) view.findViewById(R.id.loginEmail);
        loginPass_ed = (EditText) view.findViewById(R.id.loginpaswd);

        goToSignUp = (TextView) view.findViewById(R.id.Login_TVSignIn);
        login_b = (Button) view.findViewById(R.id.btnLogIn);
        login_b.setOnClickListener(this);
        goToSignUp.setOnClickListener(this);
    }

    private void doBussines() {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }


    @Override
    public void onClick(View v) {
        if (v == login_b) {

            email = loginEmail_ed.getText().toString();
            pass = loginPass_ed.getText().toString();

            validateResult = loginViewModel.checkValidate(email, pass);

            if (validateResult == Constant.InvalideEmail) {
                Toast.makeText(getActivity(), getString(R.string.ForgetEmail_TOast), Toast.LENGTH_LONG).show();
                return;
            }
            if (validateResult == Constant.InvalidePass) {
                Toast.makeText(getActivity(), getString(R.string.ForgetPass_TOast), Toast.LENGTH_LONG).show();
                return;
            }
            if(LoginViewModel.getInstance().Login(email,pass))
            {
                Toast.makeText(getActivity(), getString(R.string.LoginSuccess_TOast), Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), AllMemoriesActivity.class));
            }else
            {
                Toast.makeText(getActivity(), GlobalValueSaver.getInstance().getFailerMessage(), Toast.LENGTH_LONG).show();
            }



        } else if (v == goToSignUp) {
            HelperMethodes.beginTransaction(getFragmentManager().beginTransaction(),
                    new SignUpFragment(), R.id.contianer);
        }

    }
}
