package com.info.filmleruygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView filmlerRv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar = findViewById(R.id.toolbar);
        filmlerRv = findViewById(R.id.filmlerRv);

        vt =  new Veritabani(this);

        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbar.setTitle(kategori.getKategori_ad());
        setSupportActionBar(toolbar);

        filmlerArrayList = new FilmlerDao().tumFilmlerByKategoriId(vt,kategori.getKategori_id());

        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapter = new FilmlerAdapter(this,filmlerArrayList);

        filmlerRv.setAdapter(adapter);

    }
}
