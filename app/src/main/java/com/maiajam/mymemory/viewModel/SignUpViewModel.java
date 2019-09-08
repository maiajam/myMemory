package com.maiajam.mymemory.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maiajam.mymemory.Helper.Constant;
import com.maiajam.mymemory.Repo.SignUpRepo;

public class SignUpViewModel extends ViewModel {

    private Boolean signUpResult;

    public int checkValidate(String email, String pass) {
        if (email.isEmpty())
            return Constant.InvalideEmail;

        if (pass.isEmpty())
            return Constant.InvalidePass;

        return Constant.Valide;
    }

    public Boolean SignUp(String email, String pass) {
        signUpResult = SignUpRepo.geInstance().SignUp(email, pass);
        return signUpResult;
    }
}
