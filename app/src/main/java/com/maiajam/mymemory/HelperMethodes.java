package com.maiajam.mymemory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HelperMethodes {

    public static void beginTransaction(FragmentTransaction fragmentTransaction, Fragment fragment, int frameId) {

        fragmentTransaction.replace(frameId, fragment);
        fragmentTransaction.commit();
    }

    public static boolean checkValidate(String email, String pass) {

        if(email.isEmpty())
        {
         return false;
        }
        if(pass.isEmpty())
        {
            return false;
        }

        return true;
    }
}
