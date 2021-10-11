package com.example.clickgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    Button shortclick, longclick;

    int shortpoint;
    int longpoint;
    Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longpoint = 0;
        shortpoint = 0;


        shortclick = (Button) findViewById(R.id.button2);
        longclick = (Button) findViewById(R.id.button);
        shortclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortpoint = shortpoint + 1;
            }
        });
        longclick.setOnLongClickListener(this);
    }

    public void results(View view) {
        gi = new Intent(this, res_activity.class);
        gi.putExtra("shortpointfinal", shortpoint);
        gi.putExtra("longpointfinal", longpoint);
        startActivityForResult(gi, 1);
        shortpoint = 0;

    }

    @Override
    public boolean onLongClick(View v) {

        longpoint = longpoint + 2;
        return true;
    }

    @Override
    protected void onActivityResult(int source, int resultCode, @Nullable Intent data) {
        super.onActivityResult(source, resultCode, data);
        if (resultCode == RESULT_OK) {
            shortpoint = data.getIntExtra("epus", 0);
            longpoint = data.getIntExtra("epus", 0);
        }
    }
}