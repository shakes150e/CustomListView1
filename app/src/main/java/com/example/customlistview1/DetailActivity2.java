package com.example.customlistview1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

public class DetailActivity2 extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mImageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        mToolbar = (Toolbar)findViewById(R.id.toolBar);
        mImageView = (ImageView)findViewById(R.id.imageView2);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mToolbar.setTitle(mBundle.getString("countryName"));
            mImageView.setImageResource(mBundle.getInt("countryFlag"));
        }
    }
}