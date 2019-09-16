package com.maiajam.mymemory.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.Helper.Constant;
import com.maiajam.mymemory.Repo.LoginRepo;

public class LoginViewModel extends ViewModel {

    private static LoginViewModel loginViewModelInstance;
    private static LoginRepo loginRepo ;

    public LoginViewModel() {
    }

    public static LoginViewModel getInstance() {
        if (loginViewModelInstance == null) {
            loginViewModelInstance = new LoginViewModel();
            loginRepo = new LoginRepo();
        }
        return loginViewModelInstance;
    }


    public  int checkValidate(String email, String paas) {
        if (email.isEmpty())
            return Constant.InvalideEmail;
        if (paas.isEmpty())
            return Constant.InvalidePass;

        return Constant.Valide ;
    }

    public   Boolean Login(String email,String pass)
    {
        return LoginRepo.getInstance().Login(email,pass);
    }
}
