package com.syedwaqarul786.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;



public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    TextView time, stop, start, reset;
    long mseconds = 0;
    //    long seconds = 0;
    boolean isRunning;//Default value is false
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startbtn);
        stop = findViewById(R.id.stopbtn);
        reset = findViewById(R.id.resetbtn);

        time = findViewById(R.id.timetv); // Initialize the time TextView
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.green));



        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                setSupportActionBar(toolbar);

        handler = new Handler();


    }

    public void startbt(View view) {
        isRunning = true;
        if (stop.getVisibility() == View.INVISIBLE) {
            startTimer(); // Uncomment this line if needed
        }
        stop.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);


    }

    public void stopbt(View view) {



            isRunning=false;


        // Replace the text in TextView with an image


        // Your stop button logic here
    }

    public void resetbt(View view) {
        isRunning = false;
        mseconds = 0;
//      seconds=0;
        time.setText("00:00:00:00");
        reset.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
    }


    public void startTimer() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    long ms = mseconds % 100;
                    long s = (mseconds / 60) % 60; // updating seconds
                    long m = (mseconds / 60) / 60; // updating minutes
                    long h = m/60; // updating hours
                    mseconds++;

                    String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d:%02d", h, m, s, ms);
                    time.setText(formatString);
                    handler.postDelayed(this, 10); // Adjust the delay as needed (10 milliseconds in this example)
                }

            }

        };
        handler.post(runnable);
    }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.opt_exit)
        {
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.baseline_warning_24)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to exit this app ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                      System.exit(1);
//                        finish();
                            finishAffinity();

                        }
                    }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Press YES to exit this app", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }
        return super.onOptionsItemSelected(item);
    }

    // Other methods remain the same...
}


//    public void startTimer() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                if (isRunning) {
//                    long ms = mseconds % 100;
//                    long s = (mseconds / 1000) % 60; // updating seconds
//                    long m = (mseconds / 60000) % 60; // updating minutes
//                    long h = (mseconds / 3600000) % 24; // updating hours
//
//                    String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d:%02d", h, m, s, ms);
//                    time.setText(formatString);
//
//                    mseconds += 10; // Increase by 10 milliseconds
//
//                    handler.postDelayed(this, 10); // Adjust the delay as needed (10 milliseconds in this example)
//                }
//            }
//        };
//        handler.postDelayed(runnable, 10); // Start the runnable after a delay
//    }
//}
//public class MainActivity extends AppCompatActivity {
//    Toolbar toolbar;
//
//    TextView time,stop,start,reset;
//    long seconds=0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        start=findViewById(R.id.startbtn);
//        stop=findViewById(R.id.stopbtn);
//        reset=findViewById(R.id.resetbtn);
//        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.green));
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//                setSupportActionBar(toolbar);
//
//    }
//
//    public void startbt(View view)
//    {
////        startTimer();
//        stop.setVisibility(View.VISIBLE);
//        reset.setVisibility(View.VISIBLE);
//
//    }
//
//    public void stopbt(View view)
//    {
//
//    }
//
//    public void resetbt(View view)
//    {
//        time.setText("00:00:00");
//       reset.setVisibility(View.INVISIBLE);
//       stop.setVisibility(View.INVISIBLE);
//    }
//    public void startTimer()
//    {
//        time=(TextView) findViewById(R.id.timetv);
//        Handler handler=new Handler();
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//          long s=seconds%60;//updating seconds
//          long m=seconds/60;//updating minutes
//          long h=m/60;//updating hours
//seconds++;
//                String formatString=String.format(Locale.getDefault(),"%02ld:%02ld:%02ld",h,m,s);
//              time.setText(formatString);
//              handler.postDelayed(this,1000);
//
//            }
//        };
//handler.post(runnable);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        new MenuInflater(this).inflate(R.menu.optionmenu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId=item.getItemId();
//  if(itemId==R.id.opt_exit)
//        {
//            new AlertDialog.Builder(MainActivity.this)
//                    .setIcon(R.drawable.baseline_warning_24)
//                    .setTitle("Exit")
//                    .setMessage("Are you sure you want to exit this app ?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
////                      System.exit(1);
////                        finish();
//                            finishAffinity();
//
//                        }
//                    }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(MainActivity.this, "Press YES to exit this app", Toast.LENGTH_SHORT).show();
//                        }
//                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    }).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
////    To repeat anything in regular intervals of time, as in Java we use Thread
////    And in Android , we use Handler and Runnable because of its convenience.
//
//}
////8 20
