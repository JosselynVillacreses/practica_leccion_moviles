package com.example.josselyn.practica_leccion_moviles;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;
    Integer correctas = 0;
    Integer incorrectas = 0;

    public Integer preguntas = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);


        Intent intent = getIntent();
       String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.username);
        textView.setText(message);


                btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Correct(Color.RED, R.string.fail, false, "2");
                    incorrectas += 1;

                }
            });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correct(Color.GREEN, R.string.correct, true, "");
                        correctas += 1;

                    }
                });

                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correct(Color.RED, R.string.fail, false, "2");
                        incorrectas += 1;

                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correct(Color.RED, R.string.fail, false, "2");
                        incorrectas += 1;

                    }
                });
                btn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Correct(Color.RED, R.string.fail, false, "2");
                        incorrectas += 1;

                    }
                });





    }

    public void Correct (int color, int str, boolean good, final String correct_answer){
        final Dialog correcto = new Dialog(GameActivity.this);
        correcto.setTitle(R.string.correct);
        correcto.setContentView(R.layout.feedback_dialog);
        TextView feedback = (TextView) correcto.findViewById(R.id.feedback);
      //  feedback.setText(R.string.correct);
      //  feedback.setTextColor(Color.GREEN);
        feedback.setText(str);
        feedback.setTextColor(color);

        if (good == false){
            TextView correct_ans = (TextView) correcto.findViewById(R.id.correct_ans);
            String ca = getString(R.string.ca);
            correct_ans.setText(ca + " "+correct_answer);
        }

        correcto.show();


        Button close = correcto.findViewById(R.id.btn_close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntas += 1;

                Intent intent = new Intent(v.getContext(), GameActivity2.class);
                TextView username = (TextView) findViewById(R.id.username);
                String corr = Integer.toString(correctas);
                String inco = Integer.toString(incorrectas);
                String user = username.getText().toString();

                System.out.println("---------------------------------------------------------"+user+"sadasdasdasdadasd");
                String[] valores = new String[]{
                       corr,
                        inco,
                        user
                };


               intent.putExtra("strings", valores);
                startActivity(intent);
                correcto.dismiss();

            }
        });

    }

    public void CambiarPregunta2 (){
        TextView pregunta = findViewById(R.id.pregunta);
        pregunta.setText(R.string.question2);
    }


}
