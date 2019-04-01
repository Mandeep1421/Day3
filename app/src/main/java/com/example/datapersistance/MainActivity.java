package com.example.datapersistance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private final String TAG = MainActivity.class.getCanonicalName();
     private EditText editName;
     private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);

        String name = sharedPreferences.getString("name", null);

        if(name != null)
        {
            Log.d(TAG,name);

            editName.setText(name);


        }
    }

    public void btnSaveClick(View view )
    {


       if(editName.getText().length() !=0)
       {
           String name = editName.getText().toString();
           SharedPreferences.Editor mEditor  = sharedPreferences.edit();

           //to store the value
           mEditor.putString("name", name);

           mEditor.apply();
           //mEditor.commit();

           Intent mIntent = new Intent(MainActivity.this,SharedActivity.class );
           mIntent.putExtra("stud", name);
           startActivity(mIntent);
       }

    }
}
