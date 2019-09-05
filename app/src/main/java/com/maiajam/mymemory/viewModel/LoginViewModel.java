package com.maiajam.mymemory.viewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

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


    public  boolean checkValidate(String email, String paas) {
        if (email.isEmpty())
            return false;
        if (paas.isEmpty())
            return false;

        return true;
    }

    public   Boolean Login(String email,String pass)
    {
        return LoginRepo.getInstance().Login(email,pass);
    }
}
