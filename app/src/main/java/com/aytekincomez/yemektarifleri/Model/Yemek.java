package com.aytekincomez.yemektarifleri.Model;

public class Yemek {

    private int yemek_id;
    private String yemek_adi;
    private int yemek_tur_id;
    private int yemek_hazirlanis_suresi;
    private int yemek_pisirme_suresi;
    private int yemek_kisi_sayisi;
    private String[] malzemeler;
    private String yapilisi;
    private String resim;
    private String[] alerjenler;

    public Yemek(int yemek_id) {

    }

    public Yemek(int yemek_id, String yemek_adi, int yemek_tur_id, int yemek_hazirlanis_suresi, int yemek_pisirme_suresi, int yemek_kisi_sayisi, String[] malzemeler, String yapilisi, String resim, String[] alerjenler) {
        this.yemek_id = yemek_id;
        this.yemek_adi = yemek_adi;
        this.yemek_tur_id = yemek_tur_id;
        this.yemek_hazirlanis_suresi = yemek_hazirlanis_suresi;
        this.yemek_pisirme_suresi = yemek_pisirme_suresi;
        this.yemek_kisi_sayisi = yemek_kisi_sayisi;
        this.malzemeler = malzemeler;
        this.yapilisi = yapilisi;
        this.resim = resim;
        this.alerjenler = alerjenler;
    }

    public int getYemek_id() {
        return yemek_id;
    }

    public void setYemek_id(int yemek_id) {
        this.yemek_id = yemek_id;
    }

    public String getYemek_adi() {
        return yemek_adi;
    }

    public void setYemek_adi(String yemek_adi) {
        this.yemek_adi = yemek_adi;
    }

    public int getYemek_tur_id() {
        return yemek_tur_id;
    }

    public void setYemek_tur_id(int yemek_tur_id) {
        this.yemek_tur_id = yemek_tur_id;
    }

    public int getYemek_hazirlanis_suresi() {
        return yemek_hazirlanis_suresi;
    }

    public void setYemek_hazirlanis_suresi(int yemek_hazirlanis_suresi) {
        this.yemek_hazirlanis_suresi = yemek_hazirlanis_suresi;
    }

    public int getYemek_pisirme_suresi() {
        return yemek_pisirme_suresi;
    }

    public void setYemek_pisirme_suresi(int yemek_pisirme_suresi) {
        this.yemek_pisirme_suresi = yemek_pisirme_suresi;
    }

    public int getYemek_kisi_sayisi() {
        return yemek_kisi_sayisi;
    }

    public void setYemek_kisi_sayisi(int yemek_kisi_sayisi) {
        this.yemek_kisi_sayisi = yemek_kisi_sayisi;
    }

    public String[] getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(String[] malzemeler) {
        this.malzemeler = malzemeler;
    }

    public String getYapilisi() {
        return yapilisi;
    }

    public void setYapilisi(String yapilisi) {
        this.yapilisi = yapilisi;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String[] getAlerjenler() {
        return alerjenler;
    }

    public void setAlerjenler(String[] alerjenler) {
        this.alerjenler = alerjenler;
    }
}
