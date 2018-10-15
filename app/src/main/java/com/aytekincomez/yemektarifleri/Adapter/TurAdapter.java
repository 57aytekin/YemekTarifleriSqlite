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

import com.aytekincomez.yemektarifleri.Activity.YemekActivity;
import com.aytekincomez.yemektarifleri.Model.Tur;
import com.aytekincomez.yemektarifleri.R;

import java.util.ArrayList;

public class TurAdapter extends BaseAdapter {

    Context context;
    ArrayList<Tur> turler;
    LayoutInflater layoutInflater;

    public TurAdapter(Activity activity, ArrayList<Tur> turArrayList){
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = activity;
        this.turler = turArrayList;
    }

    @Override
    public int getCount() {
        return turler.size();
    }

    @Override
    public Object getItem(int i) {
        return turler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        context = viewGroup.getContext();
        View satirGorunumu = layoutInflater.inflate(R.layout.listview_tur_gorunumu, null);

        TextView tvTurBaslik = (TextView)satirGorunumu.findViewById(R.id.tvTurBaslik);
        TextView tvTarifSayisi = (TextView)satirGorunumu.findViewById(R.id.tvTarifSayisi);
        ImageView ivTurResim = (ImageView)satirGorunumu.findViewById(R.id.ivTurResim);

        int id = context
                .getApplicationContext()
                .getResources()
                .getIdentifier(
                        turler.get(i).getTur_resim(),
                        "drawable",
                        context.getPackageName()
                );

        tvTurBaslik.setText(turler.get(i).getTur_adi());
        tvTarifSayisi.setText("");
        ivTurResim.setImageResource(id);

        satirGorunumu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YemekActivity.class);
                intent.putExtra("tur",turler.get(i).getTur_id());
                context.startActivity(intent);
            }
        });

        return  satirGorunumu;
    }
}
