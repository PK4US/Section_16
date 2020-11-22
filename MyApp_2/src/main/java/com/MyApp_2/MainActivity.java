package com.MyApp_2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvHeading;
    private TextView tv;
    private TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHeading = findViewById(R.id.tvHeading);
        tv = findViewById(R.id.tv);
        tvLink = findViewById(R.id.tvLink);

        MyTimer timer = new MyTimer(11000, 1000);
        timer.start();
    }

    private class MyTimer extends CountDownTimer {

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisFinished) {
            int s = (int) millisFinished / 1000;
            tv.setText(s + " сек");
            if (s==0){
                onFinish();
            }
        }

        @Override
        public void onFinish() {
            System.out.println("Таймер закончился!");
            tv.setText("");
            tvHeading.setText("");
            tvLink.setText("google.com");
        }
    }
}
