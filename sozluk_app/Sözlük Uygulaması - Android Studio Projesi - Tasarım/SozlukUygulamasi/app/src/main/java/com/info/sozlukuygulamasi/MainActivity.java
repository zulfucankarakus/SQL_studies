package com.info.sozlukuygulamasi;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerListe;
    private KelimelerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        kelimelerListe = new ArrayList<>();

        Kelimeler k1 = new Kelimeler(1,"Dog","Köpek");
        Kelimeler k2 = new Kelimeler(2,"Fish","Balık");
        Kelimeler k3 = new Kelimeler(3,"Table","Masa");

        kelimelerListe.add(k1);
        kelimelerListe.add(k2);
        kelimelerListe.add(k3);

        adapter = new KelimelerAdapter(this,kelimelerListe);

        rv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen Arama",query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf girdikçe",newText);
        return false;
    }
}
