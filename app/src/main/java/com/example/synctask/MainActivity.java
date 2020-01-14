package com.example.synctask;

import androidx.appcompat.app.AppCompatActivity;

import android.media.tv.TvView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button mBtnDownLoad;
    ImageView mImage;
    ProgressBar mProgess;
    TextView mTvLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDownLoad = findViewById(R.id.buttonDownload);
        mImage = findViewById(R.id.imageview);
        mTvLoad = findViewById(R.id.textviewLoading);
        mProgess = findViewById(R.id.progressbar);

        hideView(mImage);
        hideView(mProgess);
        hideView(mTvLoad);

// Click download
        mBtnDownLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Xulydatientrinh().execute();

            }
        });

    }

// 1. start download, hide cac view con` lai
// 2. show download (text + progress bar)
// 3. show result

// Params: gtri truyen vao cho doInBackground
// Progress: gtri truyen vao onProgressUpdate, public Progress
// Result: gtri tra ve sau khi thuc thi doInBackground, gtri truyen vao onPostExcute

    class Xulydatientrinh extends AsyncTask<Void,String,Integer>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Start Download",Toast.LENGTH_SHORT);
            hideView(mBtnDownLoad);
            showView(mProgess);
            showView(mTvLoad);
        }

        @Override
    protected Integer doInBackground(Void... params) {
        int count = 0;
        for ( ; count <= 100 ;){
            count+= new Random().nextInt(10) + 1;
// chạy rất nhanh vì vậy nên làm thêm mỗi giây chạy ....
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(String.valueOf(count));

        }
        return R.mipmap.ic_launcher;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        mProgess.setProgress(Integer.parseInt(values[0]));
        mTvLoad.setText("Loading: " + mProgess.getProgress() + "%");
    }


    @Override
    protected void onPostExecute(Integer s) {
        super.onPostExecute(s);
        showView(mImage);
        hideView(mTvLoad);
        hideView(mBtnDownLoad);
        hideView(mProgess);
        mImage.setImageResource(s);
    }
}


    private void hideView (View v){
        v.setVisibility(View.GONE);
    }

    private void showView (View v){
        v.setVisibility(View.VISIBLE);
    }
}
