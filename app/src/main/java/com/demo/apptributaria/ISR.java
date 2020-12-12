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

public class ISR extends AppCompatActivity {
Button btnisr1,btnisr2,btnayudaisr;
TextView lblisr1,lblisr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_s_r);

        btnisr1 = (Button)findViewById(R.id.btnisr1);
        btnisr2 = (Button)findViewById(R.id.btnisr2);
        btnayudaisr = (Button)findViewById(R.id.btnayudaisr);

        lblisr1 = (TextView)findViewById(R.id.lblisr1);
        lblisr2 = (TextView)findViewById(R.id.lblisr2);

        lblisr1.setVisibility(View.GONE);
        lblisr2.setVisibility(View.GONE);

        btnayudaisr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(ISR.this);
                View view = getLayoutInflater().inflate(R.layout.videoayuda,null);
                VideoView vv = view.findViewById(R.id.vvinf);
                b.setView(view);
                String fileName = "android.resource://"+ getPackageName()+"/raw/ellie";

                Uri src = Uri.parse(fileName);
                vv.setVideoURI(src);
                vv.setMediaController(new MediaController(ISR.this));
                vv.start();

                b.create().show();
            }
        });

        btnisr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblisr1.getVisibility()==View.VISIBLE){
                    lblisr1.setVisibility(View.GONE);
                }else{
                    lblisr1.setVisibility(View.VISIBLE);
                }
            }
        });

        btnisr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lblisr2.getVisibility()==View.VISIBLE){
                    lblisr2.setVisibility(View.GONE);
                }else{
                    lblisr2.setVisibility(View.VISIBLE);
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