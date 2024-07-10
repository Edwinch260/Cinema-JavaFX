package com.example.cobasql;

public class TableAddFilm {

    int idFilm;
    String namaFilm;
    String namaRuangan;
    String tanggal;
    String jam;

    public TableAddFilm()
    {

    }

    public TableAddFilm(int idFilm, String namaFilm, String namaRuangan, String tanggal, String jam)
    {
        this.idFilm = idFilm;
        this.namaFilm = namaFilm;
        this.namaRuangan = namaRuangan;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
