package com.maiajam.mymemory;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FiberBaseFunctions {

    static FirebaseAuth firebaseAuth;
    public static void signUpNow(final Context context, String email, String pass){
       firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(context,context.getString(R.string.toast_successfull_signUp),Toast.LENGTH_LONG).show();
                    }else
                    {
                        Toast.makeText(context,task.getException().getMessage().toString(),Toast.LENGTH_LONG).show();
                    }

            }
        });
    }
}
