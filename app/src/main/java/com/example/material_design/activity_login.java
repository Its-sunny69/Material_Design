package com.example.material_design;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class activity_login extends AppCompatActivity {

    Button login, signup;
    ImageView image;
    TextView logoname, slogan;
    TextInputLayout username, password;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Button T=(Button)findViewById(R.id.signup);

        //Hooks
        image = findViewById(R.id.logoimage);
        logoname = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.logo_name2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup);


        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),activity_signup.class);

                Pair[] p = new Pair[7];
                p[0] = new Pair<View, String>(image, "logo_image");
                p[1] = new Pair<View, String>(logoname, "logo_text");
                p[2] = new Pair<View, String>(slogan, "logo_text2");
                p[3] = new Pair<View, String>(username, "input_username");
                p[4] = new Pair<View, String>(password, "input_password");
                p[5] = new Pair<View, String>(login, "btn_go");
                p[6] = new Pair<View, String>(signup, "btn_signup");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity_login.this,p);
                startActivity(i, options.toBundle());
            }
        });
    }

}