package com.aytekincomez.yemektarifleri.Model;

public class Tur {
    private int tur_id;
    private String tur_adi;
    private String tur_resim;

    public Tur(){

    }

    public Tur(int tur_id, String tur_adi, String tur_resim) {
        this.tur_id = tur_id;
        this.tur_adi = tur_adi;
        this.tur_resim = tur_resim;
    }

    public int getTur_id() {
        return tur_id;
    }

    public void setTur_id(int tur_id) {
        this.tur_id = tur_id;
    }

    public String getTur_adi() {
        return tur_adi;
    }

    public void setTur_adi(String tur_adi) {
        this.tur_adi = tur_adi;
    }
    public String getTur_resim(){
        return tur_resim;
    }

    public void setTur_resim(String tur_resim){
        this.tur_resim = tur_resim;
    }
}
