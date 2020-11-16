package com.Lesson_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ProgressTask().execute();
            }
        });
    }

    private class ProgressTask extends AsyncTask <Void,Integer,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0; i<=100;i++){
                publishProgress(i);
                SystemClock.sleep(200);
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