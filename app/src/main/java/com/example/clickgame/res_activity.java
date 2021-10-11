package com.example.clickgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.TextView;


public class res_activity extends AppCompatActivity {

    int shortpoint, longpoint;
    TextView winner1, shortscore, longscore;
    Intent si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        shortscore = (TextView) findViewById(R.id.bluescore);
        longscore = (TextView) findViewById(R.id.redscore);
        winner1 = (TextView) findViewById(R.id.winner);
        si = getIntent();


        shortpoint = si.getIntExtra("shortpointfinal", 0);
        longpoint = si.getIntExtra("longpointfinal", 0);
        shortscore.setText("BLUE:\n" + shortpoint);
        longscore.setText("RED:\n" + longpoint);
        if (shortpoint > longpoint) {
            winner1.setText("BLUE WINS");
            winner1.setBackgroundColor(Color.BLUE);

        }
        if (shortpoint < longpoint) {
            winner1.setText("RED WINS");
            winner1.setBackgroundColor(Color.RED);

        }
        if (shortpoint == longpoint) {
            winner1.setText("DRAW");
            winner1.setBackgroundColor(Color.MAGENTA);
        }


    }

    public void goback(View view) {
        si.putExtra("epus", 0);
        setResult(RESULT_OK, si);
        finish();
    }


}



