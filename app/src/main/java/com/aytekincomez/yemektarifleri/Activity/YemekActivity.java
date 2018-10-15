package com.aytekincomez.yemektarifleri.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aytekincomez.yemektarifleri.Adapter.YemekAdapter;
import com.aytekincomez.yemektarifleri.Database.DatabaseHelper;
import com.aytekincomez.yemektarifleri.Model.Yemek;
import com.aytekincomez.yemektarifleri.R;

import java.io.IOException;
import java.util.ArrayList;

public class YemekActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Yemek> yemekler;
    YemekAdapter yemekAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek);
        listView = (ListView)findViewById(R.id.listViewTarifler);

        int gelenVeri = getIntent().getIntExtra("tur",1);


        SQLiteDatabase db;
        Cursor c ;

        yemekler = new ArrayList<>();

        try{
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.createDatabase();
            db = databaseHelper.getReadableDatabase();
            c = db.rawQuery("select * from Yemekler where tur_id="+gelenVeri+" order by yemek_id desc", null);
            while(c.moveToNext()){

                int yemekId = c.getInt(0);
                String yemekAdi = c.getString(1);
                int yemekTurId = c.getInt(2);
                int hazirlamaSuresi = c.getInt(3);
                int pisirmeSuresi = c.getInt(4);
                int kisiSayisi = c.getInt(5);
                String yapilis = c.getString(7);
                String resim = c.getString(8);


                String malzeme = c.getString(6);
                String[] malzemeler = malzeme.split(",");

                String alerjen = c.getString(9);
                String[] alerjenler = alerjen.split(",");


                yemekler.add(
                        new Yemek(
                                yemekId,
                                yemekAdi,
                                yemekTurId,
                                hazirlamaSuresi,
                                pisirmeSuresi,
                                kisiSayisi,
                                malzemeler,
                                yapilis,
                                resim,
                                alerjenler
                        )
                );
            }
        }catch (IOException e){

        }

        //yemekler = new ArrayList<>();
        yemekAdapter = new YemekAdapter(this, yemekler);
        /*
        int yemek_id, String yemek_adi, int yemek_tur_id, int yemek_hazirlanis_suresi, int yemek_pisirme_suresi,
        int yemek_kisi_sayisi, String[] malzemeler, String yapilisi, String resim, String[] alerjenler
         */
        listView = (ListView)findViewById(R.id.listViewTarifler);
        listView.setAdapter(yemekAdapter);
    }
}
