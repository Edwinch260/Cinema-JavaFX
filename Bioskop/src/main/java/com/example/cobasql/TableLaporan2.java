package com.example.cobasql;

public class TableLaporan2 {

    String month;
    int salesPerMonth;

    public TableLaporan2(String month, int salesPerMonth)
    {
        this.month = month;
        this.salesPerMonth = salesPerMonth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getSalesPerMonth() {
        return salesPerMonth;
    }

    public void setSalesPerMonth(int salesPerMonth) {
        this.salesPerMonth = salesPerMonth;
    }
}
