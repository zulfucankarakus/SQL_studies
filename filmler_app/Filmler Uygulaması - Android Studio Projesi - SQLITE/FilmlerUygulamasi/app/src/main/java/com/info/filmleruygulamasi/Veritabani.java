package com.info.filmleruygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class Veritabani extends SQLiteOpenHelper {


    public Veritabani(Context context) {
        super(context, "filmler.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kategoriler` (\n" +
                "\t`kategori_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`kategori_ad`\tTEXT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `yonetmenler` (\n" +
                "\t`yonetmen_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`yonetmen_ad`\tTEXT\n" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `filmler` (\n" +
                "\t`film_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`film_ad`\tTEXT,\n" +
                "\t`film_yil`\tINTEGER,\n" +
                "\t`film_resim`\tTEXT,\n" +
                "\t`kategori_id`\tINTEGER,\n" +
                "\t`yonetmen_id`\tINTEGER,\n" +
                "\tFOREIGN KEY(`kategori_id`) REFERENCES `kategoriler`(`kategori_id`),\n" +
                "\tFOREIGN KEY(`yonetmen_id`) REFERENCES `yonetmenler`(`yonetmen_id`)\n" +
                ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS kategoriler");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS yonetmenler");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS filmler");
        onCreate(sqLiteDatabase);

    }
}
