package com.example.cobasql;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Terbanyak {
    public Terbanyak() {
    }

    public Terbanyak(String nama, int jumlah) {
        this.setJumlah(jumlah);
        this.setNama(nama);
    }

    private IntegerProperty jumlah;
    public void setJumlah(int value) { JumlahProperty().set(value); }
    public int getJumlah() { return JumlahProperty().get(); }
    public IntegerProperty JumlahProperty() {
        if (jumlah == null) jumlah = new SimpleIntegerProperty(this, "terjual");
        return jumlah;
    }

    private StringProperty nama;
    public void setNama(String value) { namaProperty().set(value); }
    public String getNama() { return namaProperty().get(); }
    public StringProperty namaProperty() {
        if (nama == null) nama = new SimpleStringProperty(this, "nama");
        return nama;
    }
}
