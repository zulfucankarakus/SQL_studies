package com.info.notuygulamasi;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class DetayActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editTextDers,editTextNot1,editTextNot2;
    private Veritabani vt ;
    private Notlar not ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        toolbar = findViewById(R.id.toolbar);
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);

        toolbar.setTitle("Not Detay");
        setSupportActionBar(toolbar);

        not = (Notlar) getIntent().getSerializableExtra("nesne");

        vt = new Veritabani(this);

        editTextDers.setText(not.getDers_adi());
        editTextNot1.setText(String.valueOf(not.getNot1()));
        editTextNot2.setText(String.valueOf(not.getNot2()));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_sil:
                Snackbar.make(toolbar,"Silinsin mi ?",Snackbar.LENGTH_SHORT)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                new NotlarDao().notSil(vt,not.getNot_id());

                                startActivity(new Intent(DetayActivity.this,MainActivity.class));
                                finish();
                            }
                        })
                        .show();
                return true;
            case  R.id.action_duzenle:

                String ders_adi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();

                if(TextUtils.isEmpty(ders_adi)){
                    Snackbar.make(toolbar,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show();
                    return false;
                }

                if(TextUtils.isEmpty(not1)){
                    Snackbar.make(toolbar,"Not1 giriniz",Snackbar.LENGTH_SHORT).show();
                    return false;
                }

                if(TextUtils.isEmpty(not2)){
                    Snackbar.make(toolbar,"Not2 giriniz",Snackbar.LENGTH_SHORT).show();
                    return false;
                }

                new NotlarDao().notGuncelle(vt,not.getNot_id(),ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

                startActivity(new Intent(DetayActivity.this,MainActivity.class));
                finish();
                return true;
            default:
                return false;
        }
    }
}
