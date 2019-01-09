package com.example.josselyn.practica_leccion_moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GameActivity.class);

        EditText txtname = (EditText) findViewById(R.id.txt_name);

        String name = txtname.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }
}
