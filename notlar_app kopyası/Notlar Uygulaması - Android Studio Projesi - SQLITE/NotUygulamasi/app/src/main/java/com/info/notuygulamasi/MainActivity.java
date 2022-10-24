package com.info.notuygulamasi;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private NotlarAdapter adapter;
    private ArrayList<Notlar> notlarArrayList;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Not Uygulaması");
        setSupportActionBar(toolbar);

        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        vt = new Veritabani(this);

        notlarArrayList = new NotlarDao().tumNotlar(vt);

        adapter = new NotlarAdapter(this,notlarArrayList);

        rv.setAdapter(adapter);

        double toplam = 0 ;

        for (Notlar n: notlarArrayList){
            toplam = toplam + (n.getNot1()+n.getNot2())/2 ;
        }

        toolbar.setSubtitle("Ortalama : "+toplam/notlarArrayList.size());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NotKayitActivity.class));
            }
        });


    }
}
