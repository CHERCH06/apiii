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

public class IVA extends AppCompatActivity {
Button btniva1,btniva2,btnayudaiva;
TextView lbliva1,lbliva2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v);

        btniva1 = (Button)findViewById(R.id.btniva1);
        btniva2 = (Button)findViewById(R.id.btniva2);
        btnayudaiva = (Button)findViewById(R.id.btnayudaiva);

        lbliva1 = (TextView)findViewById(R.id.lbliva1);
        lbliva2 = (TextView)findViewById(R.id.lbliva2);

        lbliva2.setVisibility(View.GONE);
        lbliva1.setVisibility(View.GONE);

        btnayudaiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(IVA.this);
                View view = getLayoutInflater().inflate(R.layout.videoayuda,null);
                VideoView vv = view.findViewById(R.id.vvinf);
                b.setView(view);
                String fileName = "android.resource://"+ getPackageName()+"/raw/ellie";

                Uri src = Uri.parse(fileName);
                vv.setVideoURI(src);
                vv.setMediaController(new MediaController(IVA.this));
                vv.start();

                b.create().show();
            }
        });

        btniva1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbliva1.getVisibility()==View.VISIBLE){
                    lbliva1.setVisibility(View.GONE);
                }else{
                    lbliva1.setVisibility(View.VISIBLE);
                }
            }
        });

        btniva2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lbliva2.getVisibility()==View.VISIBLE){
                    lbliva2.setVisibility(View.GONE);
                }else{
                    lbliva2.setVisibility(View.VISIBLE);
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