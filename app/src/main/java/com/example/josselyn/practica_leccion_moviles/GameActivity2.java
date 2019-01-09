package com.example.josselyn.practica_leccion_moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity2 extends AppCompatActivity {

    Integer correctas = 0;
    Integer incorrectas = 0;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);



        final Intent intent = getIntent();
        String[] message = intent.getStringArrayExtra("strings");

        // Capture the layout's TextView and set the string as its text
        TextView username = findViewById(R.id.username);

        username.setText(""+message[2]);
         correctas = Integer.parseInt(message[0]);
         incorrectas = Integer.parseInt(message[1]);
         System.out.println("**************************************************"+correctas);
         System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+incorrectas);


         btn1 = findViewById(R.id.btn1);

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 correctas += 1;
                 btn1.setText("Correctas: "+correctas+"\nIncorrectas: "+incorrectas);
             }
         });


    }
}
