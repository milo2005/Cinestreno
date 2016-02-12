package com.example.estacionvl_tc_014.cinestreno;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.estacionvl_tc_014.cinestreno.adapters.PeliculaAdapter;
import com.example.estacionvl_tc_014.cinestreno.models.Pelicula;
import com.example.estacionvl_tc_014.cinestreno.util.C;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    ListView list;

    PeliculaAdapter adapter;

    DrawerLayout drawer;
    NavigationView nav;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(this);

        C.data = new ArrayList<>();
        adapter = new PeliculaAdapter(this, C.data);

        list.setAdapter(adapter);

        loadPeliculas();

        //CONFIGURACION DRAWERLAYOUT

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        nav = (NavigationView) findViewById(R.id.nav);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this, drawer,R.string.open_menu
                , R.string.close_menu);

        drawer.setDrawerListener(this);
        nav.setNavigationItemSelectedListener(this);


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

        C.data.add(p1);
        C.data.add(p2);
        C.data.add(p3);

        adapter.notifyDataSetChanged();


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, Pantalla2Activity.class);
        intent.putExtra("pelicula", position);
        startActivity(intent);

    }


    //region Configuracion de Toggle
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView,slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_accion:
                Toast.makeText(this, "Peliculas de Accion !", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.nav_comedia:
                Toast.makeText(this, "Peliculas de Comedia !", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.nav_terror:
                Toast.makeText(this, "Peliculas de Terror !", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.nav_fantasia:
                Toast.makeText(this, "Peliculas de Fantasia !", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.nav_datos:
                Toast.makeText(this, "Ahora son mios !", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.nav_salir:
                Toast.makeText(this, "Vuelve Pronto ! !", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        drawer.closeDrawers();
        return false;
    }
    //endregion
}
