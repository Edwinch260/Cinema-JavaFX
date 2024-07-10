package com.example.cobasql;

public class TableAddAkun {

    int id;
    String attribute;

    public TableAddAkun(int id, String attribute)
    {
        this.id = id;
        this.attribute = attribute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
