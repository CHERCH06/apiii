package com.demo.apptributaria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Interes extends AppCompatActivity {
Button btnint1,btnint2,btnint3,btnayudaint;
TextView lblint1,lblint2,lblint3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interes);

        btnint1 = (Button)findViewById(R.id.btnint1);
        btnint2 = (Button)findViewById(R.id.btnint2);
        btnint3 = (Button)findViewById(R.id.btnint3);
        btnayudaint = (Button)findViewById(R.id.btnayudaint);

        lblint1 = (TextView)findViewById(R.id.lblint1);
        lblint2 = (TextView)findViewById(R.id.lblint2);
        lblint3 = (TextView)findViewById(R.id.lblint3);

        lblint1.setVisibility(View.GONE);
        lblint2.setVisibility(View.GONE);
        lblint3.setVisibility(View.GONE);

        btnayudaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(Interes.this);
                View view = getLayoutInflater().inflate(R.layout.videoayuda,null);
                VideoView vv = view.findViewById(R.id.vvinf);
                b.setView(view);
                String fileName = "android.resource://"+ getPackageName()+"/raw/ellie";

                Uri src = Uri.parse(fileName);
                vv.setVideoURI(src);
                vv.setMediaController(new MediaController(Interes.this));
                vv.start();

                b.create().show();
            }
        });

        btnint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblint1.getVisibility()==View.VISIBLE){
                    lblint1.setVisibility(View.GONE);
                }else{
                    lblint1.setVisibility(View.VISIBLE);
                }
            }
        });

        btnint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblint2.getVisibility()==View.VISIBLE){
                    lblint2.setVisibility(View.GONE);
                }else{
                    lblint2.setVisibility(View.VISIBLE);
                }
            }
        });

        btnint3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblint3.getVisibility()==View.VISIBLE){
                    lblint3.setVisibility(View.GONE);
                }else{
                    lblint3.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

}