package com.maiajam.mymemory.Repo;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.maiajam.mymemory.AppExecutors;
import com.maiajam.mymemory.GlobalValueSaver;

public class LoginRepo {

    private static LoginRepo loginRepoInstance;
    private static FirebaseAuth firebaseAuth;
    private boolean successfulResult;
    private static boolean succeResult;

    public LoginRepo() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static LoginRepo getInstance() {
        if (loginRepoInstance == null)
            loginRepoInstance = new LoginRepo();

        return loginRepoInstance;
    }

    public  boolean Login(final String email, final String pass)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {

                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            succeResult = true;
                        }else {
                            succeResult = false ;
                        }
                    }
                });
            saveCurrentUserId();
            }
        });
        return succeResult ;
    }

    private void saveCurrentUserId() {
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        GlobalValueSaver.getInstance().setUserId(currentFirebaseUser.getUid());

    }
}
