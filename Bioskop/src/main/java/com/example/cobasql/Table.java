package com.example.cobasql;

public class Table {

    private String namaFilm, batasUsia, sinopsis;
    private String namaRuangan;
    private String tanggal;
    private String namaAkun, email, virtualAccount;
    private String jam;

    private int idAkun, jumlahTiket, jumlahTotal, lantai;
    String tanggalTransaksi;

    public Table(String namaFilm, String namaRuangan, String tanggal, String namaAkun, String email, String virtualAccount, String jam, int jumlahTiket, String tanggalTransaksi, int jumlahTotal, int idAkun, String batasUsia, String sinopsis, int lantai)
    {
        this.namaFilm = namaFilm;
        this.namaRuangan = namaRuangan;
        this.tanggal = tanggal;
        this.namaAkun = namaAkun;
        this.email = email;
        this.virtualAccount = virtualAccount;
        this.jam = jam;
        this.jumlahTotal = jumlahTotal;
        this.jumlahTiket = jumlahTiket;
        this.tanggalTransaksi = tanggalTransaksi;
        this.idAkun = idAkun;
        this.batasUsia = batasUsia;
        this.sinopsis = sinopsis;
        this.lantai = lantai;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getBatasUsia() {
        return batasUsia;
    }

    public void setBatasUsia(String batasUsia) {
        this.batasUsia = batasUsia;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }



    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
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

    public int getJumlahTotal() {
        return jumlahTotal;
    }

    public void setJumlahTotal(int jumlahTotal) {
        this.jumlahTotal = jumlahTotal;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public int getLantai() {
        return lantai;
    }

    public void setLantai(int lantai) {
        this.lantai = lantai;
    }
}
