package com.example.cobasql;

public class Admin {


    private String namaAkun;
    private String email;
    private String password;

    public Admin(String namaAkun, String email, String password) {
        this.namaAkun = namaAkun;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
