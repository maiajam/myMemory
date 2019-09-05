package com.maiajam.mymemory.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.Repo.SignUpRepo;

public class SignUpViewModel extends ViewModel {

    private Boolean signUpResult;

    public Boolean checkValidate(String email, String pass) {
        if (email.isEmpty())
            return false;

        if (pass.isEmpty())
            return false;

        return true;
    }

    public Boolean SignUp(String email, String pass) {
        signUpResult = SignUpRepo.geInstance().SignUp(email, pass);
        return signUpResult;
    }
}
