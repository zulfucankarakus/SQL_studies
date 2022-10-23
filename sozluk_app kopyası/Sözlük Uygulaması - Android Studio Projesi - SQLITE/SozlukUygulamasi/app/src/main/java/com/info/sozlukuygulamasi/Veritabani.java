package com.info.sozlukuygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kasimadalan on 1.05.2018.
 */

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(Context context) {
        super(context, "sozluk.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kelimeler` (\n" +
                "\t`kelime_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`ingilizce`\tTEXT,\n" +
                "\t`turkce`\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kelimeler");
        onCreate(sqLiteDatabase);
    }
}
