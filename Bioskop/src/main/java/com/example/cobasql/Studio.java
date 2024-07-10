package com.example.cobasql;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Studio {
    public Studio() {
    }

    public Studio(int no,String nama, String lantai) {
        this.setNo(no);
        this.setNama(nama);
        this.setLantai(lantai);
    }
    private IntegerProperty no;
    public void setNo(int value) { noProperty().set(value); }
    public int getNo() { return noProperty().get(); }
    public IntegerProperty noProperty() {
        if (no == null) no = new SimpleIntegerProperty(this, "no");
        return no;
    }

    private StringProperty nama;
    public void setNama(String value) { namaProperty().set(value); }
    public String getNama() { return namaProperty().get(); }
    public StringProperty namaProperty() {
        if (nama == null) nama = new SimpleStringProperty(this, "nama");
        return nama;
    }

    private StringProperty lantai;
    public void setLantai(String value) { lantaiProperty().set(value); }
    public String getLantai() { return lantaiProperty().get(); }
    public StringProperty lantaiProperty() {
        if (lantai == null) lantai = new SimpleStringProperty(this, "lantai");
        return lantai;
    }
}
