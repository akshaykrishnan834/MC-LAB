package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText t2;
    TextView t1;
    DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2 = (EditText) findViewById(R.id.t2);
        t1 = (TextView) findViewById(R.id.t1);
        dbHelper = new DatabaseHelper(this);


    }

    public void addme(View view) {
        String name = t2.getText().toString();
        if(dbHelper.addName(name)){
            Toast.makeText(this,"Name added",Toast.LENGTH_SHORT).show();
            t2.setText("");
        }
        else{
            Toast.makeText(this,"Failed to add name",Toast.LENGTH_SHORT).show();
        }
    }

    public void show(View view) {
        String names = dbHelper.getAllNames();
        t1.setText(names);
    }
}