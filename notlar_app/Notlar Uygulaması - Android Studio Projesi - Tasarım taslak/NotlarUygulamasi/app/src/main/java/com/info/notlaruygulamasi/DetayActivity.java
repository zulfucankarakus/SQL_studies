package com.info.notlaruygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class DetayActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editTextDers,editTextNot1,editTextNot2;
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
                Snackbar.make(toolbar,"Silinsin mi ?", Snackbar.LENGTH_SHORT)
                        .setAction("Evet", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(DetayActivity.this,MainActivity.class));
                                finish();
                            }
                        })
                        .show();
                return true;
            case  R.id.action_duzenle:
                startActivity(new Intent(DetayActivity.this,MainActivity.class));
                finish();
                return true;
            default:
                return false;
        }
    }
}
