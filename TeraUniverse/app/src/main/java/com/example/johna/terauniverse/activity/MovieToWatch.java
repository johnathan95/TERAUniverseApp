package com.example.johna.terauniverse.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.johna.terauniverse.R;
import com.example.johna.terauniverse.db.DatabaseHelper;

public class MovieToWatch extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_to_watch);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    myDB.addData(newEntry);
                    Toast.makeText(MovieToWatch.this, getString(R.string.data_inserted), Toast.LENGTH_LONG).show();
                    editText.setText("");
                }else{
                    Toast.makeText(MovieToWatch.this, getString(R.string.empty_field), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieToWatch.this, MovieListActivity.class);
                startActivity(intent);
            }
        });


    }
}
