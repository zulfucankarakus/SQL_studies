package com.info.bayrakuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewSonuc,textViewYuzdeSonuc;
    private Button buttonTekrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewSonuc = findViewById(R.id.textViewSonuc);
        textViewYuzdeSonuc = findViewById(R.id.textViewYuzdeSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ResultActivity.this,QuizActivity.class));
                finish();
            }
        });
    }
}
