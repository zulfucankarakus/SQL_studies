package com.info.sozlukuygulamasi;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerListe;
    private KelimelerAdapter adapter;
    private Veritabani vt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);
        vt = new Veritabani(this);

        veritabaniKopyala();

        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //kelimelerListe = new ArrayList<>();

        /*Kelimeler k1 = new Kelimeler(1,"Dog","Köpek");
        Kelimeler k2 = new Kelimeler(2,"Fish","Balık");
        Kelimeler k3 = new Kelimeler(3,"Table","Masa");

        kelimelerListe.add(k1);
        kelimelerListe.add(k2);
        kelimelerListe.add(k3);*/


        kelimelerListe = new KelimelerDao().tumKelimeler(vt);

        adapter = new KelimelerAdapter(this,kelimelerListe);

        rv.setAdapter(adapter);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen arama",query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf girdikçe",newText);
        aramaYap(newText);
        return false;
    }

    public void veritabaniKopyala(){
        DatabaseCopyHelper copyHelper = new DatabaseCopyHelper(this);

        try {
            copyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        copyHelper.openDataBase();
    }

    public void aramaYap(String aramaKelime){

        kelimelerListe = new KelimelerDao().kelimeAra(vt,aramaKelime);

        adapter = new KelimelerAdapter(this,kelimelerListe);

        rv.setAdapter(adapter);
    }


}
