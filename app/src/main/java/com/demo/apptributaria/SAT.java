package com.demo.apptributaria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class SAT extends AppCompatActivity {
    TextView lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
    Button btn1,btn2,btnayuda,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elemento1);

        lbl1 = (TextView)findViewById(R.id.lbl1);
        lbl2 = (TextView)findViewById(R.id.lbl2);
        lbl3= (TextView)findViewById(R.id.lbl3);
        lbl4 = (TextView)findViewById(R.id.lbl4);
        lbl5 = (TextView)findViewById(R.id.lbl5);
        lbl6 = (TextView)findViewById(R.id.lbl6);

        btnayuda = (Button)findViewById(R.id.btnayudasat);
        btn1 = (Button)findViewById(R.id.btnsat);
        btn2 = (Button)findViewById(R.id.btnsat2);
        btn3 = (Button)findViewById(R.id.btnsat3);
        btn4 = (Button)findViewById(R.id.btnsat4);
        btn5 = (Button)findViewById(R.id.btnsat5);
        btn6 = (Button)findViewById(R.id.btnsat6);

        lbl1.setVisibility(View.GONE);
        lbl2.setVisibility(View.GONE);
        lbl3.setVisibility(View.GONE);
        lbl4.setVisibility(View.GONE);
        lbl5.setVisibility(View.GONE);
        lbl6.setVisibility(View.GONE);

        btnayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(SAT.this);
                View view = getLayoutInflater().inflate(R.layout.videoayuda,null);
                VideoView vv = view.findViewById(R.id.vvinf);
                b.setView(view);
                String fileName = "android.resource://"+ getPackageName()+"/raw/ellie";

                Uri src = Uri.parse(fileName);
                vv.setVideoURI(src);
                vv.setMediaController(new MediaController(SAT.this));
                vv.start();

                b.create().show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl1.getVisibility()==View.VISIBLE){
                    lbl1.setVisibility(View.GONE);
                }else{
                    lbl1.setVisibility(View.VISIBLE);
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl2.getVisibility()==View.VISIBLE){
                    lbl2.setVisibility(View.GONE);
                }else{
                    lbl2.setVisibility(View.VISIBLE);
                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl3.getVisibility()==View.VISIBLE){
                    lbl3.setVisibility(View.GONE);
                }else{
                    lbl3.setVisibility(View.VISIBLE);
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl4.getVisibility()==View.VISIBLE){
                    lbl4.setVisibility(View.GONE);
                }else{
                    lbl4.setVisibility(View.VISIBLE);
                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl5.getVisibility()==View.VISIBLE){
                    lbl5.setVisibility(View.GONE);
                }else{
                    lbl5.setVisibility(View.VISIBLE);
                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbl6.getVisibility()==View.VISIBLE){
                    lbl6.setVisibility(View.GONE);
                }else{
                    lbl6.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}