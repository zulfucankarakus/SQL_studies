package com.info.filmleruygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private ImageView ımageViewFilmResim;
    private TextView textViewFilmAd,textViewYil,textViewYonetmen;
    private Filmler film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        ımageViewFilmResim = findViewById(R.id.imageViewResim);
        textViewFilmAd = findViewById(R.id.textViewFilmAd);
        textViewYil = findViewById(R.id.textViewYil);
        textViewYonetmen = findViewById(R.id.textViewYonetmen);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAd.setText(film.getFilm_ad());
        textViewYil.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmen.setText(film.getYonetmen().getYonetmen_ad());

       ımageViewFilmResim.setImageResource(getResources().getIdentifier(film.getFilm_resim(),"drawable",getPackageName()));

    }
}
