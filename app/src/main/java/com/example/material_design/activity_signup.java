package com.example.material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_signup extends AppCompatActivity {

    //variables
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

    }

    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()){
            regName.setError("Field cannot be Empty");
            return false;
        }
        else{
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhitespace = "(?=\\s+$)";

        if (val.isEmpty()){
            regUsername.setError("Field cannot be Empty");
            return false;
        }
        else if (val.length()>=15){
            regUsername.setError("Username is too long");
            return false;
        }
        else if (!val.matches(noWhitespace)){
            regUsername.setError("White space are not allowed");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (val.isEmpty()){
            regEmail.setError("Field cannot be Empty");
            return false;
        }
        else if (!val.matches(emailPattern)){
            regEmail.setError("Invalid Email!");
            return false;
        }
        else{
            regEmail.setError(null);
            return true;
        }
    }
    private Boolean validatePhoneNo(){
        String val = regPhoneNo.getEditText().getText().toString();

        if (val.isEmpty()){
            regPhoneNo.setError("Field cannot be Empty");
            return false;
        }
        else{
            regPhoneNo.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordval = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";

        if (val.isEmpty()){
            regName.setError("Field cannot be Empty");
            return false;
        }
        else if (!val.matches(passwordval)){
            regPassword.setError("Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters");
            return false;
        }
        else{
            regPassword.setError(null);
            return true;
        }
    }

    //Save data in Firebase on button click
    public void registerUser(View View){

        if(!validateName() | !validateUsername() | !validateEmail() | !validatePhoneNo() | !validatePassword()){
            return;
        }

        //Get all the values in String
        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();
        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);
    }

    private class UserHelperClass {
        public UserHelperClass(String name, String username, String email, String phoneNo, String password) {
        }

    }

}