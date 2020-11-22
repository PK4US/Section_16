package com.MyApp_1;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        Button buttonStart = findViewById(R.id.buttonStart);
        Button buttonStop = findViewById(R.id.buttonStop);
        Button buttonPause = findViewById(R.id.buttonPause);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonPause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.buttonStart:{
                new ProgressTask().execute();
                break;
            }
            case R.id.buttonStop:{

                break;
            }
            case R.id.buttonPause:{
                break;
            }
        }
    }

    private class ProgressTask extends AsyncTask <Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0; i<=100;i++){
                publishProgress(i);
                SystemClock.sleep(100);
            }
            return null;
        }

        protected void onProgressUpdate(Integer...items){
            tv.setText("Загрузка: " +items[0] + " %");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Загрузка завершена!", Toast.LENGTH_SHORT).show();
        }
    }
}