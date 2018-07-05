package com.example.hp.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button imagebtton,showButton;
    ImageView image;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        imagebtton = findViewById (R.id.imgbutton);
        showButton =findViewById (R.id.Tstbtn);

        image = findViewById (R.id.imageView);
         progressbar = findViewById (R.id.progrs);

        showButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText (MainActivity.this, "Iam in Toast", Toast.LENGTH_SHORT).show ();
            }
        });

        imagebtton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
//                loadImage();
                new LoadIConTask ().execute (R.drawable.rajni);
            }
        });

    }

//    private void loadImage() {
//        new  Thread (new Runnable () {
//            @Override
//            public void run() {
//                final Bitmap bitmap = BitmapFactory.decodeResource (getResources (),R.drawable.rajni);
//
//                MainActivity.this.runOnUiThread (new Runnable () {
//                    @Override
//                    public void run() {
//                        image.setImageBitmap (bitmap);
//                    }
//                });
//
//
//            }
//        }).start ();



    class LoadIConTask extends AsyncTask<Integer,Integer,Bitmap>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute ();
            progressbar.setVisibility (ProgressBar.VISIBLE);
        }
        @Override
        protected Bitmap doInBackground(Integer... integers) {
            try {
                Thread.sleep(000);
            }catch (InterruptedException e) {
                e.printStackTrace ();
            }

            Bitmap bitmap = BitmapFactory.decodeResource (getResources (),R.drawable.rajni);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            progressbar.setVisibility (ProgressBar.VISIBLE);
            super.onPostExecute (bitmap);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate (values);
            progressbar.setProgress (values[0]);
        }
    }

}
