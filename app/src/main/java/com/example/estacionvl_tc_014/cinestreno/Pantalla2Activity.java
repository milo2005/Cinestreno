package com.example.estacionvl_tc_014.cinestreno;

import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estacionvl_tc_014.cinestreno.models.Pelicula;
import com.example.estacionvl_tc_014.cinestreno.util.C;
import com.squareup.picasso.Picasso;

public class Pantalla2Activity extends AppCompatActivity {

    CollapsingToolbarLayout collapsing;
    Toolbar toolbar;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        int pos = getIntent().getIntExtra("pelicula",0);
        Pelicula p = C.data.get(pos);

        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        img = (ImageView) findViewById(R.id.img);

        setSupportActionBar(toolbar);
        collapsing.setTitle(p.getNombre());

        Uri uri = Uri.parse(p.getUrlImg());
        Picasso.with(this).load(uri).into(img);


    }
}
