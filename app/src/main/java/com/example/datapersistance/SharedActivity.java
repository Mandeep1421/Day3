package com.example.datapersistance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SharedActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        Bundle mbundle = getIntent().getExtras();
        if(mbundle != null)
        {
            if(mbundle.containsKey("name"))
            {
                String name = mbundle.getString("name");
                Toast.makeText(this,name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
