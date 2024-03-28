package com.redapps.phonepolice.ui.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.redapps.phonepolice.R;
import com.redapps.phonepolice.databinding.ActivitySplashScreenBinding;
import com.redapps.phonepolice.ui.loginScreen.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    private int[] backgrounds = {
            R.drawable.intruder_gradient,
            R.drawable.anti_touch_gradient,
            R.drawable.batterygradient,
            R.drawable.wrong_pass_gradient,
            R.drawable.pocketalram_gradient,
            R.drawable.charger_removel_gradient,
            R.drawable.ic_anti_touch,
    };
    private int currentIndex = 0;
    private int bgdelay = 350;
    private ConstraintLayout backgroundImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        backgroundImageView = binding.splashScreenLayout;

        // Start changing backgrounds after 3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeBackground();
                // Continue changing backgrounds every 300ms
                new Handler().postDelayed(this, bgdelay);
            }
        }, bgdelay);

        // Start LoginActivity after 9 seconds (3 seconds delay + 3 seconds for each background change)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 3000);
    }

    private void changeBackground() {
        if (currentIndex < backgrounds.length - 1) {
            currentIndex++;
        } else {
            currentIndex = 0; // Reset index to loop through backgrounds
        }
        backgroundImageView.setBackgroundResource(backgrounds[currentIndex]);
    }
}


/*
package com.redapps.phonepolice.ui.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.redapps.phonepolice.databinding.ActivitySplashScreenBinding;
import com.redapps.phonepolice.ui.loginScreen.LoginActivity;


public class SplashActivity extends AppCompatActivity {


    @Override

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivitySplashScreenBinding inflate = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(inflate.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
        }, 3000);
    }


    @Override

    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

}
*/
