package com.syedwaqarul786.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreen.this,R.color.green));
        Animation rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
        findViewById(R.id.imageView).startAnimation(rotate);
        Animation scale=AnimationUtils.loadAnimation(this,R.anim.scale);
        findViewById(R.id.textView).startAnimation(scale);

        Thread thread=new Thread(){
            public void run()
            {
                try {
//                    To give delay in finally
                    sleep(3000);//2 second
                }
                catch (Exception e)
                {
                    e.printStackTrace();//Mother of all the exceptions
                }
                finally {
                    Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }

        };thread.start();
    }
}
//12 45