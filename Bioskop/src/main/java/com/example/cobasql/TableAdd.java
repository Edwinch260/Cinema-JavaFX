package com.example.cobasql;

public class TableAdd {

    int idFilm, idRuangan, lantai;
    String namaFilm, namaRuangan, tanggal, jam;

    public TableAdd(int idFilm, int idRuangan, String namaFilm, String namaRuangan, String tanggal, String jam, int lantai)
    {
        this.idFilm = idFilm;
        this.idRuangan = idRuangan;
        this.namaFilm = namaFilm;
        this.namaRuangan= namaRuangan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.lantai = lantai;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(int idRuangan) {
        this.idRuangan = idRuangan;
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

    public int getLantai() {
        return lantai;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }
}
