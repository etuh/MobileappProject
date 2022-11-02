package com.example.sp1.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sp1.Authentication.AuthenticationActivity;
import com.example.sp1.MainActivity;
import com.example.sp1.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FullScreen
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //if API>30
//        getWindow().getDecorView().getWindowInsetsController().hide(
//                android.view.WindowInsets.Type.statusBars()
//        );

        setContentView(R.layout.activity_splash_screen);
        LottieAnimationView lottieAnimationView;
        TextView pawTitle;
        float temp = convertDpToPixels(this, 100);

        lottieAnimationView = findViewById(R.id.lottie_dog);
        pawTitle = findViewById(R.id.paw_title);

        pawTitle.animate().translationY(-temp).setDuration(1200).setStartDelay(0);
//        lottieAnimationView.animate().translationX(2000).setDuration(2000).setStartDelay(4730);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, AuthenticationActivity.class);
                startActivity(i);
                finish();
            }
        },5500);
    }
    float convertDpToPixels(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}