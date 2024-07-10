package com.example.cobasql;

public class dataPembeliSering{

    private String IdCust;
    private String jumlahTransaksi;

    public String getIdCust() {
        return IdCust;
    }

    public void setIdCust(String idCust) {
        IdCust = idCust;
    }

    public String getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(String jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public dataPembeliSering() {
    }

    public dataPembeliSering(String idCust, String jumlahTransaksi) {
        IdCust = idCust;
        this.jumlahTransaksi = jumlahTransaksi;
    }
}
