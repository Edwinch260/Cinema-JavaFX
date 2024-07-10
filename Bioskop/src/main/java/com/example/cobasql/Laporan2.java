package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Laporan2{

    @FXML
    TableColumn<TableLaporan2, String> monthColumn;

    @FXML
    TableColumn<TableLaporan2, Integer> salesperMonthColumn;

    @FXML
    TableView<TableLaporan2> tableView;

    @FXML
    public void onBack()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene2 = app.getScene2();
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Home page");
    }

    @FXML
    public void onRefresh()
    {
        try
        {
            ObservableList<TableLaporan2> tableLaporan2 = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT MONTH(TanggalTransaksi) AS Month, SUM(JumlahTotal) AS SalesPerMonth FROM transaksi GROUP BY MONTH(TanggalTransaksi)";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryMonth = queryOutput.getString("Month");
                int querySalesPerMonth = queryOutput.getInt("SalesPerMonth");

                tableLaporan2.add(new TableLaporan2(queryMonth, querySalesPerMonth));
            }

            monthColumn.setCellValueFactory(new PropertyValueFactory<>("Month"));
            salesperMonthColumn.setCellValueFactory(new PropertyValueFactory<>("SalesPerMonth"));

            tableView.setItems(tableLaporan2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }

    public void initialize() {

        try
        {
            ObservableList<TableLaporan2> tableLaporan2 = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT MONTH(TanggalTransaksi) AS Month, SUM(JumlahTotal) AS SalesPerMonth FROM transaksi GROUP BY MONTH(TanggalTransaksi)";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryMonth = queryOutput.getString("Month");
                int querySalesPerMonth = queryOutput.getInt("SalesPerMonth");

                tableLaporan2.add(new TableLaporan2(queryMonth, querySalesPerMonth));
            }

            monthColumn.setCellValueFactory(new PropertyValueFactory<>("Month"));
            salesperMonthColumn.setCellValueFactory(new PropertyValueFactory<>("SalesPerMonth"));

            tableView.setItems(tableLaporan2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }

    }
}
