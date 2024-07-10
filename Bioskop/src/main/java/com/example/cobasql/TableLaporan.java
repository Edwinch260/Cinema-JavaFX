package com.example.cobasql;

public class TableLaporan {

    private String namaAkun, email, virtualAccount;
    private String tanggalTransaksi;
    private int jumlahTotal, jumlahTiket;

    public TableLaporan(String namaAkun, String email, String virtualAccount, String tanggalTransaksi, int jumlahTotal, int jumlahTiket)
    {
        this.namaAkun = namaAkun;
        this.email = email;
        this.virtualAccount = virtualAccount;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jumlahTotal = jumlahTotal;
        this.jumlahTiket = jumlahTiket;
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

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
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
}
