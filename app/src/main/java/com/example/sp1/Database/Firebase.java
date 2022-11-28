package com.example.sp1.Database;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.sp1.Authentication.AuthenticationActivity;
import com.example.sp1.MainActivity;
import com.example.sp1.Models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Firebase {
//    private String firstName, lastName, email, password;
//    private Context context;
    public static DatabaseReference databaseReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth =  FirebaseAuth.getInstance();
    FirebaseUser firebaseUser = null;



    public void signIn(Context context, TextInputLayout emailLayout, TextInputLayout passLayout,
                       String email, String password){
        if(email.isEmpty()){
            emailLayout.setError("Email is required!");
            emailLayout.requestFocus();
            return;
        }else if(password.isEmpty()){
            passLayout.setError("Password is required!");
            passLayout.requestFocus();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                context.startActivity(new Intent(context, MainActivity.class));
                ((Activity)context).finish();
            }
        }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(context,
                            "Incorrect email and/or password.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void signUp(Context context, String firstName, String lastName, String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("first_name", firstName);
                user.put("last_name", lastName);
                user.put("email", email);
                user.put("password", password);

                // Add a new document with a generated ID
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(context,
                                        "Registration successful, proceed to login screen.",
                                        Toast.LENGTH_LONG).show();
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context,
                                        "Error adding user details",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

            }
        }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    firebaseUser = task.getResult().getUser();
                } else {
                    if (task.getException().getMessage().equals("The email address is already in use by another account.")) {
                        Toast.makeText(context,
                                "This email is already in use by another account",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
