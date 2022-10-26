package com.info.filmleruygulamasi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView filmlerRv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar = findViewById(R.id.toolbar);
        filmlerRv = findViewById(R.id.filmlerRv);

        toolbar.setTitle("Filmler");
        setSupportActionBar(toolbar);

        filmlerRv.setHasFixedSize(true);
        filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        filmlerArrayList = new ArrayList<>();

        Filmler f1 = new Filmler(1,"Django",2008,"django",null,null);
        Filmler f2 = new Filmler(2,"Inception",2009,"inception",null,null);
        Filmler f3 = new Filmler(3,"The Pianist",2010,"thepianist",null,null);

        filmlerArrayList.add(f1);
        filmlerArrayList.add(f2);
        filmlerArrayList.add(f3);

        adapter = new FilmlerAdapter(this,filmlerArrayList);

        filmlerRv.setAdapter(adapter);
    }
}
