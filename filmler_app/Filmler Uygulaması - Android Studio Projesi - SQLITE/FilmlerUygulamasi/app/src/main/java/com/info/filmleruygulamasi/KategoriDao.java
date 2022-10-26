package com.info.filmleruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

/**
 * Created by kasimadalan on 4.05.2018.
 */

public class KategoriDao {

    public ArrayList<Kategoriler> tumKategoriler(Veritabani vt){
        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();


        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM kategoriler",null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id"))
                    ,c.getString(c.getColumnIndex("kategori_ad")));

            kategorilerArrayList.add(k);


        }

        return kategorilerArrayList;
    }
}
