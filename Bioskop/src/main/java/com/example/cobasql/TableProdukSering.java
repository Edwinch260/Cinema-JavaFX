package com.example.cobasql;

public class TableProdukSering {

    String namaFilm;
    int jumlah;

    public TableProdukSering(String namaFilm, int jumlah)
    {
        this.namaFilm = namaFilm;
        this.jumlah = jumlah;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
