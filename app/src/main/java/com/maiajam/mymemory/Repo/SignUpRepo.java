package com.maiajam.mymemory.Repo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.maiajam.mymemory.AppExecutors;
import com.maiajam.mymemory.GlobalValueSaver;

public class SignUpRepo {

    private static SignUpRepo instance ;
    private  static FirebaseAuth firebaseAuth;
    private boolean successful;

    public SignUpRepo() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static SignUpRepo geInstance() {
     if(instance == null)
     {
         instance = new SignUpRepo();
     }
     return instance;
    }

    public Boolean SignUp(final String email, final String pass){

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            successful = true ;
                        }else {
                            successful = false ;
                            GlobalValueSaver.getInstance().setCreatUserFailerMessage(task.getException().toString());
                        }
                    }
                });
            }
        });

        return successful;
    }

}
