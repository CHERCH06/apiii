package com.demo.apptributaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    TextView textView,lblquestion,lblfin,lblmsjfin;
    Button btntrue,btnfalse,btnrev;
    int correct;
    ImageView ivq;
    int np = 4;
    int currentQuestionIndex = -1;
    CountDownTimer countDownTimer = null;
    int[] images = {R.drawable.rfc,R.drawable.rfc,R.drawable.ivas,R.drawable.inter};
    String[] preguntas = {"¿El RFC solo se puede sacar cuando trabajas?","Si tramitaste tu RFC cuando no trabajabas, al momento de empezar a laborar, ¿Se activará para que pagues impuestos?","Las siglas IVA,¿Significan Impuesto al valor americano?","¿La taza de interes siempre es anual?"};
    boolean[] respuestas = {false,true,false,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String valor = getIntent().getExtras().getString("category");

        textView = (TextView)findViewById(R.id.lbltimer);
        btnrev = (Button)findViewById(R.id.btnrev);
        lblfin = (TextView)findViewById(R.id.lblfin);
        lblmsjfin = (TextView)findViewById(R.id.lblmsjfinal);
        lblquestion = (TextView)findViewById(R.id.lblquestion);
        ivq = (ImageView)findViewById(R.id.ivq);
        btntrue = (Button)findViewById(R.id.btntrue);
        btnfalse = (Button)findViewById(R.id.btnfalse);
        lblfin.setVisibility(View.GONE);
        btnrev.setVisibility(View.GONE);
        lblmsjfin.setVisibility(View.GONE);
        tiempo();
        preguntas();
        btntrue.setOnClickListener(this);
        btnfalse.setOnClickListener(this);

        Toast.makeText(Quiz.this,valor,Toast.LENGTH_LONG).show();
    }

    public void tiempo(){
            countDownTimer = new CountDownTimer(20000, 1000) {
                public void onTick(long millisUntilFinished) {
                    double rest = millisUntilFinished / 1000L;
                    if(rest>15){
                        textView.setTextColor(Color.parseColor("#2CF000"));
                    }else{
                        if(rest>10){
                            textView.setTextColor(Color.parseColor("#FF5733"));
                        }else{
                            textView.setTextColor(Color.parseColor("#FE0008"));
                        }
                    }
                    textView.setText(String.format(Locale.getDefault(), "%d segundos.", millisUntilFinished / 1000L));
                }

                public void onFinish() {
                    textView.setText("Se acabo el tiempo");
                    tiempo();
                    preguntas();
                }
            }.start();
    }

    private void preguntas() {
        currentQuestionIndex++;
        int medio = np/2;
        if(currentQuestionIndex<np){
            lblquestion.setText(preguntas[currentQuestionIndex]);
            ivq.setImageResource(images[currentQuestionIndex]);
        }else{
            countDownTimer.cancel();
            btnfalse.setVisibility(View.GONE);
            btntrue.setVisibility(View.GONE);
            lblquestion.setVisibility(View.GONE);
            textView.setVisibility(View.INVISIBLE);
            textView.setText("FIN DEL JUEGO");
            if(correct>medio){
                ivq.setImageResource(R.drawable.good);
                lblfin.setVisibility(View.VISIBLE);
                lblmsjfin.setVisibility(View.VISIBLE);
                lblmsjfin.setText("Tuviste un total de "+correct+ "/"+np+" aciertos, Muy bien!");
            }else{
                ivq.setImageResource(R.drawable.wrong);
                lblfin.setVisibility(View.VISIBLE);
                lblmsjfin.setVisibility(View.VISIBLE);
                lblmsjfin.setText("Tuviste un total de "+correct+ "/"+np+" aciertos, Intenta repasar");
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Spinner.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnfalse:
                if(respuestas[currentQuestionIndex]==false){
                   correct++;
                }
                countDownTimer.cancel();
                tiempo();
                preguntas();
                break;
            case R.id.btntrue:
                if(respuestas[currentQuestionIndex]==true) {
                    correct++;
                }
                countDownTimer.cancel();
                tiempo();
                preguntas();
                break;
        }
    }
}

