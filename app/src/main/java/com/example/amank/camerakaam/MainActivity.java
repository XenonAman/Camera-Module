package com.example.amank.camerakaam;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CAPTURE= 1;
    ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but =(Button)findViewById(R.id.daba);
        img1 = (ImageView)findViewById(R.id.imgdikha);

        if(!hasCamers()){
            but.setEnabled(false);
        }


    }

    public boolean hasCamers()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


    public void dabaya(View view) {
        Toast.makeText(this, "Camera chalu hone wala hai", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUEST_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CAPTURE ){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap)extras.get("data");
            img1.setImageBitmap(photo);
        }
        else{
            Toast.makeText(getApplicationContext(),"i will be always executed",Toast.LENGTH_LONG).show();
        }
    }
}
