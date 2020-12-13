package com.demo.apptributaria;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

public class Spinner extends AppCompatActivity{

    LuckyWheelView luckyWheelView; //Contenedor principal
    ArrayList<LuckyItem> luckyItemArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        luckyWheelView=(LuckyWheelView)findViewById(R.id.luckyWheel);

        luckyItemArrayList=new ArrayList<>();

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.secondaryText = "SAT";
        luckyItem1.secondaryTextOrientation = 1;
        luckyItem1.color= Color.parseColor("#FF0080");
        luckyItemArrayList.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.secondaryText = "IVA";
        luckyItem2.secondaryTextOrientation = 1;
        luckyItem2.color= Color.parseColor("#109DFA");
        luckyItemArrayList.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.secondaryText = "ISR";
        luckyItem3.secondaryTextOrientation = 1;
        luckyItem3.color= Color.parseColor("#E36B2C");
        luckyItemArrayList.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.topText = "INTERESES";
        luckyItem4.color= Color.parseColor("#6DC36D");
        luckyItemArrayList.add(luckyItem4);

        luckyWheelView.setData(luckyItemArrayList);
        luckyWheelView.setRound(getRandomRound());

        //ItemSelectedListener
        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                if (index==0){
                    Intent in = new Intent(Spinner.this, Quiz.class);
                    in.putExtra("category", "SAT");
                    startActivity(in);
                    finish();
                }
                if (index==1){
                    Intent inte = new Intent(Spinner.this, Quiz.class);
                    inte.putExtra("category", "IVA");
                    startActivity(inte);
                    finish();
                }
                if (index==2){
                    Intent inten = new Intent(Spinner.this, Quiz.class);
                    inten.putExtra("category", "ISR");
                    startActivity(inten);
                    finish();
                }
                if (index==3){
                    Intent intent = new Intent(Spinner.this, Quiz.class);
                    intent.putExtra("category", "Intereses");
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("usuario", "StackOverflow!");
        startActivity(i);
        finish();
    }

    private int getRandomRound(){
        Random random = new Random();
        return random.nextInt(20)+1;
    }

    private int getRandomIndex(){
        int[] ind = new int[]{1,2,3,4};
        int random = new Random().nextInt(ind.length);
        return ind[random];
    }
}
