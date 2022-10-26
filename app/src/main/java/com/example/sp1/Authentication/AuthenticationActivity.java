package com.example.sp1.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sp1.Database.Firebase;
import com.example.sp1.MainActivity;
import com.example.sp1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class AuthenticationActivity extends AppCompatActivity {
    private TextView registerLink;
    private Button loginButton;
    private TextInputEditText emailInput,passwordInput;
    private TextInputLayout emailLayout, passLayout;
    private Firebase firebase;

    @Override
    protected void onStart() {
        super.onStart();
//        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
//            startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
//            finish();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        firebase = new Firebase();

        emailLayout = findViewById(R.id.email_input_layout);
        passLayout = findViewById(R.id.password_input_layout);

        registerLink = findViewById(R.id.register_link);
        loginButton = findViewById(R.id.login_button);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(AuthenticationActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        //comments
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_text = emailInput.getText().toString().trim();
                String password_text = passwordInput.getText().toString().trim();
                firebase.signIn(AuthenticationActivity.this,
                        emailLayout, passLayout,
                        email_text,password_text);
            }
        });
    }
}