package com.example.johna.terauniverse.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.johna.terauniverse.R;

public class NotesActivity extends AppCompatActivity {

    EditText ed;
    Button b;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Note = "noteText";

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ed = (EditText)findViewById(R.id.et_notes);
        b = (Button) findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String notes = sharedPreferences.getString(Note, "");

        ed.setText(notes, TextView.BufferType.EDITABLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Note, n);
                editor.commit();
                Toast.makeText(NotesActivity.this,getString(R.string.saved),Toast.LENGTH_LONG).show();
            }
        });
    }
}
