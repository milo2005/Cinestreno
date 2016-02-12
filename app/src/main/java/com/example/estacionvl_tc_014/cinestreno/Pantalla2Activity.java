package com.example.estacionvl_tc_014.cinestreno;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estacionvl_tc_014.cinestreno.models.Pelicula;
import com.example.estacionvl_tc_014.cinestreno.util.C;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Pantalla2Activity extends AppCompatActivity implements Callback {

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
        Picasso.with(this).load(uri).into(img,this);


    }

    @Override
    public void onSuccess() {

        BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
        Palette palette = Palette.from(drawable.getBitmap()).generate();

        int primary = ContextCompat.getColor(this, R.color.colorPrimary);
        int color = palette.getLightVibrantColor(primary);

        collapsing.setContentScrimColor(color);

    }

    @Override
    public void onError() {

    }
}
