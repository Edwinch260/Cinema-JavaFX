package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Laporan{

    @FXML
    TableColumn<TableLaporan, String> namaAkunColumn;

    @FXML
    TableColumn<TableLaporan, String> emailColumn;

    @FXML
    TableColumn<TableLaporan, String> virtualAccountColumn;

    @FXML
    TableColumn<TableLaporan, String> tanggalTransaksiColumn;

    @FXML
    TableColumn<TableLaporan, String> jumlahTotalColumn;

    @FXML
    TableColumn<TableLaporan, Integer> jumlahTiketColumn;

    @FXML
    TableView<TableLaporan> tableView;

    @FXML
    TextField total;


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
        total.setEditable(false);
        try
        {
            ObservableList<TableLaporan> tableLaporan = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT a.NamaAkun, a.Email, a.VirtualAccount, t.TanggalTransaksi, t.JumlahTiket, t.JumlahTotal\n" +
                    "FROM Akun a\n" +
                    "INNER JOIN Transaksi t ON (a.IdAkun = t.IdAkun)";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryNamaAkun = queryOutput.getString("NamaAkun");
                String queryEmail = queryOutput.getString("Email");
                String queryVirtualAccount = queryOutput.getString("VirtualAccount");
                int queryJumlahTiket = queryOutput.getInt("JumlahTiket");
                String queryTanggalTransaksi = queryOutput.getString("TanggalTransaksi");
                int queryJumlahTotal = queryOutput.getInt("JumlahTotal");

                tableLaporan.add(new TableLaporan(queryNamaAkun, queryEmail, queryVirtualAccount, queryTanggalTransaksi, queryJumlahTotal, queryJumlahTiket));
            }

            Statement st2 = con.createStatement();
            ResultSet queryOutput2 = st2.executeQuery("SELECT SUM(t.JumlahTotal) FROM Transaksi t");

            while(queryOutput2.next())
            {
                total.setText(queryOutput2.getString("SUM(t.JumlahTotal)"));
            }

            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("NamaAkun"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            virtualAccountColumn.setCellValueFactory(new PropertyValueFactory<>("VirtualAccount"));
            tanggalTransaksiColumn.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
            jumlahTiketColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTiket"));
            jumlahTotalColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTotal"));

            tableView.setItems(tableLaporan);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }
    public void initialize()
    {
        total.setEditable(false);
        try
        {
            ObservableList<TableLaporan> tableLaporan = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT a.NamaAkun, a.Email, a.VirtualAccount, t.TanggalTransaksi, t.JumlahTiket, t.JumlahTotal\n" +
                    "FROM Akun a\n" +
                    "INNER JOIN Transaksi t ON (a.IdAkun = t.IdAkun)";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryNamaAkun = queryOutput.getString("NamaAkun");
                String queryEmail = queryOutput.getString("Email");
                String queryVirtualAccount = queryOutput.getString("VirtualAccount");
                int queryJumlahTiket = queryOutput.getInt("JumlahTiket");
                String queryTanggalTransaksi = queryOutput.getString("TanggalTransaksi");
                int queryJumlahTotal = queryOutput.getInt("JumlahTotal");

                tableLaporan.add(new TableLaporan(queryNamaAkun, queryEmail, queryVirtualAccount, queryTanggalTransaksi, queryJumlahTotal, queryJumlahTiket));
            }

            Statement st2 = con.createStatement();
            ResultSet queryOutput2 = st2.executeQuery("SELECT SUM(t.JumlahTotal) FROM Transaksi t");

            while(queryOutput2.next())
            {
                total.setText(queryOutput2.getString("SUM(t.JumlahTotal)"));
            }

            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("NamaAkun"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            virtualAccountColumn.setCellValueFactory(new PropertyValueFactory<>("VirtualAccount"));
            tanggalTransaksiColumn.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
            jumlahTiketColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTiket"));
            jumlahTotalColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTotal"));

            tableView.setItems(tableLaporan);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }
}
