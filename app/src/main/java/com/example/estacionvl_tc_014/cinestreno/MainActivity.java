package com.example.estacionvl_tc_014.cinestreno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.estacionvl_tc_014.cinestreno.adapters.PeliculaAdapter;
import com.example.estacionvl_tc_014.cinestreno.models.Pelicula;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;

    List<Pelicula> data;
    PeliculaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        data = new ArrayList<>();
        adapter = new PeliculaAdapter(this, data);

        list.setAdapter(adapter);

        loadPeliculas();

    }

    public void loadPeliculas(){
        Pelicula p1 =  new Pelicula();
        p1.setNombre("Deadpool");
        p1.setDuracion("140 minutos");
        p1.setFechaEstreno("20 de Febrero");
        p1.setUrlImg("http://www.lashorasperdidas.com/wp-content/uploads/2015/07/deadpool-promopic-2.jpg");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Batman v Superman");
        p2.setDuracion("160 minutos");
        p2.setFechaEstreno("15 de Marzo");
        p2.setUrlImg("http://images.fandango.com/MDCsite/images/featured/201512/the-hidden-plot-of-batman-vs-superman-dawn-of-justice-593860.jpg");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Xmen Apocalipsis");
        p3.setDuracion("132 minutos");
        p3.setFechaEstreno("15 de Septiembre");
        p3.setUrlImg("http://i2.wp.com/blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/39442.jpg");

        data.add(p1);
        data.add(p2);
        data.add(p3);

        adapter.notifyDataSetChanged();


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, Pantalla2Activity.class);
        intent.putExtra("pelicula",data.get(position).getNombre());
        startActivity(intent);

    }
}
