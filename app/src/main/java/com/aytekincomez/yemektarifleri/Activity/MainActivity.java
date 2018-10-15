package com.aytekincomez.yemektarifleri.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aytekincomez.yemektarifleri.Adapter.TurAdapter;
import com.aytekincomez.yemektarifleri.Database.DatabaseHelper;
import com.aytekincomez.yemektarifleri.Model.Tur;
import com.aytekincomez.yemektarifleri.Model.Yemek;
import com.aytekincomez.yemektarifleri.R;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView liste;
    ArrayList<Yemek> yemekArrayList;
    ArrayList<Tur> turArrayList;
    TurAdapter turAdapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;
        Cursor c ;
        turArrayList = new ArrayList<>();
        try{
            databaseHelper = new DatabaseHelper(getApplicationContext());
            databaseHelper.createDatabase();
            db = databaseHelper.getReadableDatabase();
            c = db.rawQuery("select * from Turler order by id desc", null);
            while(c.moveToNext()){
                turArrayList.add(new Tur(c.getInt(0), c.getString(1),c.getString(2)));
            }
        }catch (IOException e){

        }

/*
        yemekArrayList = new ArrayList<>();
        String[] malzemeler = {"malzeme1","malzeme2","malzeme3"};
        String[] alerjenler = {"alerjen1", "alerjen2"};
        yemekArrayList.add(
                new Yemek(
                        1, "Yemek adi", 1, 3,3,5,malzemeler,"yapilisi","resimler",alerjenler
                )
        );
*/


        turAdapter = new TurAdapter(this, turArrayList);

        liste = (ListView)findViewById(R.id.listView);
        liste.setAdapter(turAdapter);

    }
}
