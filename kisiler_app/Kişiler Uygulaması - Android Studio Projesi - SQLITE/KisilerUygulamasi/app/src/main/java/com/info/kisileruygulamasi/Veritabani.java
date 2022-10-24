package com.info.kisileruygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(Context context) {
        super(context, "rehber.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE kisiler (kisi_id INTEGER PRIMARY KEY AUTOINCREMENT,kisi_ad TEXT,kisi_tel TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kisiler");
        onCreate(sqLiteDatabase);
    }
}
