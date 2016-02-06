package com.example.estacionvl_tc_014.cinestreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;
    String peliculas[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        peliculas = getResources().getStringArray(R.array.Peliculas);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String p = peliculas[position];
        Toast.makeText(this, "Seleccionaste la pelicula "+p,Toast.LENGTH_SHORT)
                .show();
    }
}
