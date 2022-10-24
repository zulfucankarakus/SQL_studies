package com.info.notuygulamasi;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PriorityQueue;

public class NotKayitActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editTextDers,editTextNot1,editTextNot2;
    private Button buttonKaydet;
    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_kayit);

        toolbar = findViewById(R.id.toolbar);
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);

        toolbar.setTitle("Not Kayıt");
        setSupportActionBar(toolbar);

        vt = new Veritabani(this);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ders_adi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();


                if(TextUtils.isEmpty(ders_adi)){
                    Snackbar.make(view,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not1)){
                    Snackbar.make(view,"Not1 giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not2)){
                    Snackbar.make(view,"Not2 giriniz",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                new NotlarDao().notEkle(vt,ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

                startActivity(new Intent(NotKayitActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
