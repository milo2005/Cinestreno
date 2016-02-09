package com.example.estacionvl_tc_014.cinestreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        String pelicula = getIntent().getStringExtra("pelicula");
        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setText(pelicula);
    }
}
