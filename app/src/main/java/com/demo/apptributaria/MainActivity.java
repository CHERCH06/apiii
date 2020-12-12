package com.demo.apptributaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView lvtmain;
ListViewAdapter adapter;

String[] titulos = {"SAT","IVA","ISR","Intereses","Quiz rápido"};
String[] subtitulos = {"¿Que quieren decir las siglas SAT?...","¿Que quieren decir las siglas IVA?...","¿Que quieren decir las siglas ISR?...","¿Que son los intereses?...","Evalúa lo aprendido"};
int[] images = {R.drawable.sat,R.drawable.ivas,R.drawable.isr,R.drawable.porce,R.drawable.quiz_1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvtmain = (ListView)findViewById(R.id.ltvmain);

        adapter =  new ListViewAdapter(this,images,titulos,subtitulos);
        lvtmain.setAdapter(adapter);

        lvtmain.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_creditos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.creditositm:
                Intent intent = new Intent(this,creitos.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Intent i =  new Intent(this, SAT.class);
                startActivity(i);
                finish();
                break;
            case 1:
                Intent in =  new Intent(this, IVA.class);
                startActivity(in);
                finish();
                break;
            case 2:
                Intent inte =  new Intent(this, ISR.class);
                startActivity(inte);
                finish();
                break;
            case 3:
                Intent intent =  new Intent(this, Interes.class);
                startActivity(intent);
                finish();
                break;
            case 4:
                Intent inteto = new Intent(this,Quiz.class);
                startActivity(inteto);
                finish();
                break;
        }

    }
}