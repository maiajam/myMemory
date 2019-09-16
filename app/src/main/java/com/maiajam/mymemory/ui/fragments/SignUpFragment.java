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
import com.maiajam.mymemory.ui.activities.MainActivity;
import com.maiajam.mymemory.listners.OnClickListener;
import com.maiajam.mymemory.ui.viewModel.SignUpViewModel;


public class SignUpFragment extends Fragment implements View.OnClickListener {


    private EditText signinEmailEdt, signinPassEdt;
    private Button siginBt;
    private SignUpViewModel signUpViewModel;
    private String email, pass;
    private OnClickListener clickObject;
    private Boolean SignUpResult;
    private TextView goToLogin;
    private View view;

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
        initialView(inflater, container);
        return view;
    }

    private void initialView(LayoutInflater inflater, ViewGroup container) {

        view = inflater.inflate(R.layout.fragment_signup, container, false);
        signinEmailEdt = (EditText) view.findViewById(R.id.SiginUpEmail);
        signinPassEdt = (EditText) view.findViewById(R.id.SiginUp_paswd);
        goToLogin = (TextView) view.findViewById(R.id.Sigin_TV_LoginIn);
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        siginBt = (Button) view.findViewById(R.id.btnSignIn);
        siginBt.setOnClickListener(this);

        goToLogin.setOnClickListener(this);
    }


    private void signUp() {
        email = signinEmailEdt.getText().toString();
        pass = signinPassEdt.getText().toString();
        if (signUpViewModel.checkValidate(email, pass) == Constant.Valide) {
            SignUpResult = signUpViewModel.SignUp(email, pass);
            if (SignUpResult)
                startActivity(new Intent(getActivity(), MainActivity.class));
            else
                Toast.makeText(getActivity(), GlobalValueSaver.getInstance().getFailerMessage(), Toast.LENGTH_LONG).show();
        } else if (signUpViewModel.checkValidate(email, pass) == Constant.InvalidePass) {
            Toast.makeText(getActivity(), getString(R.string.ForgetPass_TOast), Toast.LENGTH_LONG).show();
            return;
        } else if (signUpViewModel.checkValidate(email, pass) == Constant.InvalideEmail) {
            Toast.makeText(getActivity(), getString(R.string.ForgetPass_TOast), Toast.LENGTH_LONG).show();
            return;
        }
    }


    @Override
    public void onClick(View v) {
        if (v == siginBt)
            signUp();
        else if (v ==goToLogin)
            HelperMethodes.beginTransaction(getFragmentManager().beginTransaction(),
                    new LoginFragment(),R.id.contianer);

    }
}
