package com.example.sp1.Authentication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.sp1.HelperClass.Verification;
import com.example.sp1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class RegisterActivity extends AppCompatActivity {
    private TextView loginLink;
    private Button registerButton;
    private TextInputEditText regFirst, regLast, regEmail, regPassword, cregPassword;
    private TextInputLayout firstLayout, lastLayout, emailLayout, passwordLayout, cpasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Verification verification;

        firstLayout = findViewById(R.id.first_input_layout);
        lastLayout = findViewById(R.id.last_input_layout);
        emailLayout = findViewById(R.id.remail_input_layout);
        passwordLayout = findViewById(R.id.rpassword_input_layout);
        cpasswordLayout = findViewById(R.id.rpassword_confirm_input_layout);

        loginLink = findViewById(R.id.login_link);
        regFirst = findViewById(R.id.first_input);
        regLast = findViewById(R.id.last_input);
        regEmail = findViewById(R.id.remail_input);
        regPassword = findViewById(R.id.rpassword_input);
        cregPassword = findViewById(R.id.password_confirm_input);

        registerButton = findViewById(R.id.register_button);
        verification = new Verification(regFirst, regLast, regEmail, regPassword, cregPassword, firstLayout,
                lastLayout, emailLayout, passwordLayout, cpasswordLayout);

        verification.monitorText();
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this,AuthenticationActivity.class);
                startActivity(loginIntent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = regFirst.getText().toString().trim();
                String last_name = regLast.getText().toString().trim();
                String email_text = regEmail.getText().toString().trim();
                String password_text = regPassword.getText().toString().trim();
                String confirm_password_text = cregPassword.getText().toString().trim();
                verification.verificationChecker(RegisterActivity.this, first_name,last_name,email_text,password_text, confirm_password_text);
            }
        });
    }
}