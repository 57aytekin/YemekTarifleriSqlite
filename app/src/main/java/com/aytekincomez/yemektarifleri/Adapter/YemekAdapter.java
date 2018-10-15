package com.aytekincomez.yemektarifleri.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aytekincomez.yemektarifleri.Activity.YemekDetayActivity;
import com.aytekincomez.yemektarifleri.Model.Yemek;
import com.aytekincomez.yemektarifleri.R;

import java.util.ArrayList;

public class YemekAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Yemek> yemekler;

    public YemekAdapter(Activity activity, ArrayList<Yemek> yemekler){

        this.context = activity;
        this.yemekler = yemekler;
        this.layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return yemekler.size();
    }

    @Override
    public Object getItem(int i) {
        return yemekler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View layout = layoutInflater.inflate(R.layout.listview_yemek_tarifi, null);

        ImageView ivYemekResim = (ImageView)layout.findViewById(R.id.ivYemekResim);
        TextView tvYemekIsim = (TextView)layout.findViewById(R.id.tvYemekIsim);
        TextView tvKisiSayisi = (TextView)layout.findViewById(R.id.tvKisiSayisi);
        TextView tvPisirmeSuresi = (TextView)layout.findViewById(R.id.tvPisirmeSuresi);
        TextView tvHazirlamaSuresi = (TextView)layout.findViewById(R.id.tvHazirlamaSuresi);

        int id = layout.getResources().getIdentifier(yemekler.get(i).getResim(),"drawable", context.getPackageName());

        ivYemekResim.setImageResource(id);

        tvYemekIsim.setText(yemekler.get(i).getYemek_adi());
        tvKisiSayisi.setText(""+yemekler.get(i).getYemek_kisi_sayisi());
        tvPisirmeSuresi.setText(""+yemekler.get(i).getYemek_pisirme_suresi());
        tvHazirlamaSuresi.setText(""+yemekler.get(i).getYemek_hazirlanis_suresi());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YemekDetayActivity.class);
                intent.putExtra("yemekid",yemekler.get(i).getYemek_id());
                context.startActivity(intent);
            }
        });

        return layout;
    }
}
