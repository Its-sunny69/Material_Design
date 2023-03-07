package com.example.material_design;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Variables
    Animation topAnim, bottomAnim, bottomAnim2;
    ImageView image;
    TextView brand,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        bottomAnim2 = AnimationUtils.loadAnimation(this,R.anim.bottom_animation2);

        //Hooks
        image = findViewById(R.id.imageView1);
        brand = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        brand.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim2);

        int SPLASH_SCREEN = 3500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,activity_login.class);

//               Pair[] pairs = new Pair[2];
//               Pair[0] = new Pair<View,String>(image, "logo_image");
//               Pair[1] = new Pair<View,String>(brand, "logo_text");

                Pair[] p = new Pair[3];
                p[0] = new Pair<View, String>(image, "logo_image");
                p[1] = new Pair<View, String>(brand, "logo_text");
                p[2] = new Pair<View, String>(slogan, "logo_text2");




                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,p);
                startActivity(intent,options.toBundle());
                finish();
            }
        }, SPLASH_SCREEN);

    }
}