package com.aytekincomez.yemektarifleri.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aytekincomez.yemektarifleri.Database.DatabaseHelper;
import com.aytekincomez.yemektarifleri.Model.Yemek;
import com.aytekincomez.yemektarifleri.R;

import java.io.IOException;

public class YemekDetayActivity extends AppCompatActivity {

    LinearLayout llMalzemeler;
    LinearLayout llAlerjenler;
    ImageView tarifResim;
    TextView tarifBaslik, tvKategoriAdi, tvPisirmeSuresi, tvHazirlamaSuresi, tvKisiSayisi, tvTarif;

    CheckBox chk;

    SQLiteDatabase db ;
    DatabaseHelper databaseHelper;


    private void malzemelerDoldur(String[] dizi){
        llMalzemeler = (LinearLayout)findViewById(R.id.llDetayMalzemeler);
        llMalzemeler.setOrientation(LinearLayout.VERTICAL);

        for(int i=0; i<dizi.length; i++){
            chk = new CheckBox(this);
            chk.setId(i);
            chk.setText(dizi[i]);
            llMalzemeler.addView(chk);
        }
    }
    public void alerjenleriDoldur(String[] dizi){

        llAlerjenler = (LinearLayout)findViewById(R.id.llDetayAlerjenler);
        llAlerjenler.setOrientation(LinearLayout.VERTICAL);


        for(int i=0; i<dizi.length; i++){
            chk = new CheckBox(this);
            chk.setId(i);
            chk.setText(dizi[i]);
            llAlerjenler.addView(chk);
        }
    }

    public String getKategoriAdi(int id){
        String sorgu = "Select * from Turler where id="+id;
        Cursor c = db.rawQuery(sorgu,null);
        c.moveToFirst();

        String baslik = "";
        do {
            baslik = c.getString(1);
        }while (c.moveToNext());
        c.close();
        return baslik;
    }

    public Yemek yemekDetaylar(int id){
        Yemek yemek = new Yemek(id);
        String sorgu = "Select * from Yemekler where yemek_id="+id;
        Cursor c = db.rawQuery(sorgu,null);
        c.moveToFirst();

        do{
            yemek.setYapilisi(c.getString(7));
            yemek.setYemek_adi(c.getString(1));
            yemek.setYemek_id(c.getInt(0));
            yemek.setResim(c.getString(8));
            yemek.setYemek_hazirlanis_suresi(c.getInt(c.getColumnIndex("yemek_hazirlama_suresi")));
            yemek.setYemek_pisirme_suresi(c.getInt(c.getColumnIndex("yemek_pisirme_suresi")));
            yemek.setYemek_kisi_sayisi(c.getInt(c.getColumnIndex("yemek_kisi_sayisi")));
            yemek.setYemek_tur_id(c.getInt(c.getColumnIndex("tur_id")));

            String[] malzemeler = c.getString(c.getColumnIndex("yemek_malzemeleri")).split(",");
            String[] alerjenler = c.getString(c.getColumnIndex("yemek_alerjenleri")).split(",");

            yemek.setMalzemeler(malzemeler);
            yemek.setAlerjenler(alerjenler);

            alerjenleriDoldur(alerjenler);
            malzemelerDoldur(malzemeler);

        }while (c.moveToNext());
        c.close();
        return yemek;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_detay);

        int yemekid = getIntent().getIntExtra("yemekid",1);

        try{
            databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
        }catch (IOException e){

        }

        Yemek yemek = yemekDetaylar(yemekid);

        llMalzemeler = (LinearLayout)findViewById(R.id.llDetayMalzemeler);
        llMalzemeler = (LinearLayout)findViewById(R.id.llDetayAlerjenler);

        tarifResim = (ImageView)findViewById(R.id.ivDetayResim);
        tarifBaslik = (TextView)findViewById(R.id.tvDetayYemekBaslik);
        tvKategoriAdi = (TextView)findViewById(R.id.tvDetayYemekTurAdi);
        tvPisirmeSuresi = (TextView)findViewById(R.id.tvPisirmeSuresi);
        tvHazirlamaSuresi = (TextView)findViewById(R.id.tvHazirlamaSuresi);
        tvKisiSayisi = (TextView)findViewById(R.id.tvKisiSayisi);
        tvTarif = (TextView)findViewById(R.id.tvDetayTarif);


        tarifBaslik.setText(yemek.getYemek_adi());
        tvTarif.setText(yemek.getYapilisi());
        //tvKisiSayisi.setText(yemek.getYemek_kisi_sayisi());
        //tvHazirlamaSuresi.setText(""+yemek.getYemek_hazirlanis_suresi());
        //tvPisirmeSuresi.setText(""+yemek.getYemek_pisirme_suresi());
        tvKategoriAdi.setText(getKategoriAdi(yemek.getYemek_tur_id()));

        int id = getResources().getIdentifier(yemek.getResim(),"drawable", this.getPackageName());
        tarifResim.setImageResource(id);


    }
}
