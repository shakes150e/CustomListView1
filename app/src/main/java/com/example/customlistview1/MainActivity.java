package com.example.customlistview1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolBar;
    ListView mListView;

    String[] countryNames = {
            "kenya",
            "somalia",
            "uganda",
            "uruguay",
            "venezuela",
            "vietnam",
            "yemen",
            "zambia",
            "lesotho"

    };

    int[] countryFlags = {
            R.drawable.kenya,
            R.drawable.somalia,
            R.drawable.uganda,
            R.drawable.uruguay,
            R.drawable.venezuela,
            R.drawable.vietnam,
            R.drawable.yemen,
            R.drawable.zambia,
            R.drawable.lesotho

    };


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mToolBar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView)findViewById(R.id.listview);
        myAdapter myAdapter = new myAdapter(MainActivity.this, countryNames, countryFlags);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity2.class);
                mIntent.putExtra("countryName",countryNames[position]);
                mIntent.putExtra("countryFlag",countryFlags[position]);
                startActivity(mIntent);
            }
        });

    }
}