package com.demo.apptributaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class creitos extends AppCompatActivity {
    ListView lvtmain;
    ListViewAdapter adapter;

    String[] titulos = {"Ana Bonilla","Jocelyn Morado","Naomi Ortiz Gonzalez","Paulina Otero","Sergio Vazquez Guzman"};
    String[] subtitulos = {"Instituto Tecnologico de Celaya","Instituto Tecnologico de Celaya","Instituto Tecnologico de Celaya","Instituto Tecnologico de Celaya","Instituto Tecnologico de Celaya"};
    int[] images = {R.drawable.ana,R.drawable.joce,R.drawable.naomi,R.drawable.pau,R.drawable.sergio};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creitos);

        lvtmain = (ListView)findViewById(R.id.ltvcreditos);

        adapter =  new ListViewAdapter(this,images,titulos,subtitulos);
        lvtmain.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}