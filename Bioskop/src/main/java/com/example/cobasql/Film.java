package com.example.cobasql;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Film {
    private String IdFilm;
    private String NamaFilm;
    private String BatasUsia;
    private String Sinopsis;

    public String getIdFilm() {
        return IdFilm;
    }

    public void setIdFilm(String idFilm) {
        IdFilm = idFilm;
    }

    public String getNamaFilm() {
        return NamaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        NamaFilm = namaFilm;
    }

    public String getBatasUsia() {
        return BatasUsia;
    }

    public void setBatasUsia(String batasUsia) {
        BatasUsia = batasUsia;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public Film(String idFilm, String namaFilm, String batasUsia, String sinopsis) {
        IdFilm = idFilm;
        NamaFilm = namaFilm;
        BatasUsia = batasUsia;
        Sinopsis = sinopsis;
    }
}
