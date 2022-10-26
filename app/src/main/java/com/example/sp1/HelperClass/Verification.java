package com.example.sp1.HelperClass;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.example.sp1.Authentication.RegisterActivity;
import com.example.sp1.Database.Firebase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
    private TextInputEditText regFirst, regLast, regEmail, regPassword, confirmregPassword;
    private TextInputLayout firstNameLayout, lastNameLayout, emailLayout, passwordLayout, confirmpasswordLayout;

    public Verification(TextInputEditText regFirst, TextInputEditText regLast, TextInputEditText regEmail, TextInputEditText regPassword, TextInputEditText confirmregPassword, TextInputLayout firstNameLayout, TextInputLayout lastNameLayout, TextInputLayout emailLayout, TextInputLayout passwordLayout, TextInputLayout confirmpasswordLayout) {
        this.regFirst = regFirst;
        this.regLast = regLast;
        this.regEmail = regEmail;
        this.regPassword = regPassword;
        this.confirmregPassword = confirmregPassword;
        this.firstNameLayout = firstNameLayout;
        this.lastNameLayout = lastNameLayout;
        this.emailLayout = emailLayout;
        this.passwordLayout = passwordLayout;
        this.confirmpasswordLayout = confirmpasswordLayout;
    }

    public TextInputEditText getRegFirst() {
        return regFirst;
    }

    public void setRegFirst(TextInputEditText regFirst) {
        this.regFirst = regFirst;
    }

    public TextInputEditText getRegLast() {
        return regLast;
    }

    public void setRegLast(TextInputEditText regLast) {
        this.regLast = regLast;
    }

    public TextInputEditText getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(TextInputEditText regEmail) {
        this.regEmail = regEmail;
    }

    public TextInputEditText getRegPassword() {
        return regPassword;
    }

    public void setRegPassword(TextInputEditText regPassword) {
        this.regPassword = regPassword;
    }

    public TextInputEditText getConfirmregPassword() {
        return confirmregPassword;
    }

    public void setConfirmregPassword(TextInputEditText confirmregPassword) {
        this.confirmregPassword = confirmregPassword;
    }

    public TextInputLayout getFirstNameLayout() {
        return firstNameLayout;
    }

    public void setFirstNameLayout(TextInputLayout firstNameLayout) {
        this.firstNameLayout = firstNameLayout;
    }

    public TextInputLayout getLastNameLayout() {
        return lastNameLayout;
    }

    public void setLastNameLayout(TextInputLayout lastNameLayout) {
        this.lastNameLayout = lastNameLayout;
    }

    public TextInputLayout getEmailLayout() {
        return emailLayout;
    }

    public void setEmailLayout(TextInputLayout emailLayout) {
        this.emailLayout = emailLayout;
    }

    public TextInputLayout getPasswordLayout() {
        return passwordLayout;
    }

    public void setPasswordLayout(TextInputLayout passwordLayout) {
        this.passwordLayout = passwordLayout;
    }

    public TextInputLayout getConfirmpasswordLayout() {
        return confirmpasswordLayout;
    }

    public void setConfirmpasswordLayout(TextInputLayout confirmpasswordLayout) {
        this.confirmpasswordLayout = confirmpasswordLayout;
    }
    public void monitorText(){
        //First Name
        regFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String firstName = charSequence.toString();
                if(firstName.length()>0){
                    firstNameLayout.setError("");
                } else {
                    firstNameLayout.setError("First name is required!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Last Name
        regLast.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String lastName = charSequence.toString();
                if(lastName.length()>0){
                    lastNameLayout.setError("");
                } else {
                    lastNameLayout.setError("Last name is required!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Email
        regEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String email = charSequence.toString();
                if(email.length()>0){
                    emailLayout.setError("");
                } else {
                    emailLayout.setError("Email is required!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //Password
        regPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();
                if(password.length()>=8){
                    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(password);
                    boolean pwdContainsSpecialChar = matcher.find();
                    if(pwdContainsSpecialChar){
                        passwordLayout.setHelperText("Strong password requirements met.");
                        passwordLayout.setError("");
                    } else {
                        passwordLayout.setHelperText("");
                        passwordLayout.setError("Password must contain at least one special character, e.g., @ ! $ #.");
                    }

                } else {
                    passwordLayout.setHelperText("Password must contain 8 characters or more.");
                    passwordLayout.setError("");
                }
                //Confirm password
                confirmregPassword.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }
                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        String cpassword = charSequence.toString();
                        if(!cpassword.equals(password)){
                            confirmpasswordLayout.setError("Passwords do not match!");
                        } else {
                            confirmpasswordLayout.setHelperText("Passwords match.");
                            confirmpasswordLayout.setError("");
                        }
                        if(cpassword.length()>0){
                            emailLayout.setError("");
                        } else {
                            emailLayout.setError("Password is required!");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void verificationChecker(Context context, String firstName, String lastName, String email, String password, String confirm_password){
        Firebase firebase = new Firebase();
        if(firstName.isEmpty()){
            firstNameLayout.setError("First name is required");
            firstNameLayout.requestFocus();
            return;
        }else if(lastName.isEmpty()){
            lastNameLayout.setError("Last name is required");
            lastNameLayout.requestFocus();
            return;
        }else if(email.isEmpty()){
            emailLayout.setError("Email is required");
            emailLayout.requestFocus();
            return;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailLayout.setError("Provide a valid email address");
            emailLayout.requestFocus();
            return;
        }else if(password.isEmpty()){
            passwordLayout.setError("You need to set a password");
            return;
        } else if(password.length()<8){
            passwordLayout.setError("Password must contain 8 characters or more.");
            return;
        } else if(!confirm_password.equals(password)){
            confirmpasswordLayout.setError("Passwords do not match!");
            return;
        }
        firebase.signUp(context,firstName,lastName,email,password);
    }
}
