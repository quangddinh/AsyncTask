package com.example.synctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Xulydatientrinh().execute();

    }
// Params: gtri truyen vao cho doInBackground
// Progress: gtri truyen vao onProgressUpdate, public Progress
// Result: gtri tra ve sau khi thuc thi doInBackground, gtri truyen vao onPostExcute
    class Xulydatientrinh extends AsyncTask<String,String,String>{


    @Override
    protected String doInBackground(String... strings) {
        Log.d("BBB","doInBackground");
        return null;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.d("BBB","onProgressUpdate");
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("BBB","onPreExecute");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("BBB","onPostExecute");
    }
}
}
