package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdukSering {

    @FXML
    TableColumn<TableProdukSering, String> filmColumn;

    @FXML
    TableColumn<TableProdukSering, Integer> jumlahColumn;

    @FXML
    TableView<TableProdukSering> tableView;


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
            ObservableList<TableProdukSering> tableProdukSering = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();

            String query = "SELECT f.NamaFilm, SUM(t.JumlahTiket) AS JumlahTiket\n" +
                    "FROM transaksi t\n" +
                    "INNER JOIN Film f on (t.IdFilm = f.IdFilm)\n" +
                    "GROUP BY f.NamaFilm\n" +
                    "ORDER BY JumlahTiket DESC";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryMonth = queryOutput.getString("NamaFilm");
                int querySalesPerMonth = queryOutput.getInt("JumlahTiket");

                tableProdukSering.add(new TableProdukSering(queryMonth, querySalesPerMonth));
            }

            filmColumn.setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
            jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));

            tableView.setItems(tableProdukSering);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }

    public void initialize() {

        try
        {
            ObservableList<TableProdukSering> tableProdukSering = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();

            String query = "SELECT f.NamaFilm, SUM(t.JumlahTiket) AS JumlahTiket\n" +
                    "FROM transaksi t\n" +
                    "INNER JOIN Film f on (t.IdFilm = f.IdFilm)\n" +
                    "GROUP BY f.NamaFilm\n" +
                    "ORDER BY JumlahTiket DESC";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryMonth = queryOutput.getString("NamaFilm");
                int querySalesPerMonth = queryOutput.getInt("JumlahTiket");

                tableProdukSering.add(new TableProdukSering(queryMonth, querySalesPerMonth));
            }

            filmColumn.setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
            jumlahColumn.setCellValueFactory(new PropertyValueFactory<>("Jumlah"));

            tableView.setItems(tableProdukSering);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }

    }
}
