package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
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


public class Add{

    @FXML
    TextField idAkun;

    @FXML
    TextField idRuangan;

//    @FXML
//    TextField idStudio;

//    @FXML
//    TextField idTanggal;

    @FXML
    TextField jam;

    @FXML
    TextField jumlahTiket;

    @FXML
    TextField jumlahTotal;

    @FXML
    DatePicker tanggalTransaksi;

    @FXML
    TableView<TableAddAkun> tableAkun;

    @FXML
    TableColumn<TableAddAkun, Integer> idAkunColumn;

    @FXML
    TableColumn<TableAddAkun, Integer> lantaiColumn;

    @FXML
    TableColumn<TableAddAkun, String> namaAkunColumn;

    @FXML
    TableView<TableAdd> tableFilm;

    @FXML
    TableColumn<TableAdd, Integer> idFilmColumn;

    @FXML
    TableColumn<TableAdd, String> namaFilmColumn;

//    @FXML
//    TableView<TableAddAkun> tableJam;

//    @FXML
//    TableColumn<TableAddAkun, String> idJamColumn;

    @FXML
    TableColumn<TableAdd, String> jamColumn;

//    @FXML
//    TableView<TableAddAkun> tableTanggal;

//    @FXML
//    TableColumn<TableAddAkun, Integer> idTanggalColumn;

    @FXML
    TableColumn<TableAdd, String> tanggalColumn;

//    @FXML
//    TableView<TableAddAkun> tableRuangan;

    @FXML
    TableColumn<TableAdd, Integer> idRuanganColumn;

    @FXML
    TableColumn<TableAdd, String> namaRuanganColumn;

    private int SidFilm;

    @FXML
    public void onRefresh()
    {
        tableFilm.getItems().clear();
        try
        {
            //Akun
            ObservableList<TableAddAkun> akun = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT a.IdAkun, a.NamaAkun\n" +
                    "FROM Akun a\n";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                int queryIdAkun = queryOutput.getInt("IdAkun");
                String queryNamaAkun = queryOutput.getString("NamaAkun");

                akun.add(new TableAddAkun(queryIdAkun, queryNamaAkun));
            }

            idAkunColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("Attribute"));

            tableAkun.setItems(akun);

            //Film
            ObservableList<TableAdd> film = FXCollections.observableArrayList();
            Connection con2 = App.createDataBaseConnector();


            String query2 = "SELECT f.IdFilm, s.IdRuangan, f.NamaFilm, s.NamaRuangan, f.Tanggal, f.Jam, s.lantai\n" +
                    "FROM Film f \n" +
//                    "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +
//                    "INNER JOIN Film f ON (t.IdFilm = f.IdFilm)\n" +
//            "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
//                    "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
                    "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n" +
                    "WHERE CheckBox IS NULL";

            Statement st2 = con2.createStatement();
            ResultSet queryOutput2 = st2.executeQuery(query2);

            while(queryOutput2.next())
            {
                int queryIdFilm = queryOutput2.getInt("IdFilm");
                int queryIdRuangan = queryOutput2.getInt("IdRuangan");
                int queryLantai = queryOutput2.getInt("lantai");
                String queryNamaFilm = queryOutput2.getString("NamaFilm");
                String queryNamaRuangan = queryOutput2.getString("NamaRuangan");
                String queryTanggal = queryOutput2.getString("Tanggal");
                String queryJam = queryOutput2.getString("Jam");

                film.add(new TableAdd(queryIdFilm, queryIdRuangan, queryNamaFilm, queryNamaRuangan, queryTanggal, queryJam, queryLantai));
            }

            idFilmColumn.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
            idRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("idRuangan"));
            namaFilmColumn.setCellValueFactory(new PropertyValueFactory<>("namaFilm"));
            namaRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("namaRuangan"));
            tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            jamColumn.setCellValueFactory(new PropertyValueFactory<>("jam"));
            lantaiColumn.setCellValueFactory(new PropertyValueFactory<>("lantai"));

            tableFilm.setItems(film);

//            Connection con3 = App.createDataBaseConnector();
//
//            String query3 = "SELECT f.IdFilm\n" +

// //                    "FROM Transaksi t\n" +
// //                    "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +

//                        "FROM Film f\n" +

// //                    "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
// //                    "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
// //                    "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n" +

//                    "WHERE f.CheckBox IS NULL AND f.idRuangan = '" + idFilm.getText() + "' AND f.jam = '" + jam.getText() + "'";
//
//            Statement st3 = con3.createStatement();
//            ResultSet queryOutput3 = st3.executeQuery(query3);
//
//            while(queryOutput3.next())
//            {
//                add = queryOutput3.getInt("IdFilm");
//            }

            tanggalTransaksi.setValue(java.time.LocalDate.now());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }

    }

    public void initialize()
    {
        tableFilm.getItems().clear();
        try
        {
            //Akun
            ObservableList<TableAddAkun> akun = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT a.IdAkun, a.NamaAkun\n" +
                    "FROM Akun a\n";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                int queryIdAkun = queryOutput.getInt("IdAkun");
                String queryNamaAkun = queryOutput.getString("NamaAkun");

                akun.add(new TableAddAkun(queryIdAkun, queryNamaAkun));
            }

            idAkunColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("Attribute"));

            tableAkun.setItems(akun);

            //Film
            ObservableList<TableAdd> film = FXCollections.observableArrayList();
            Connection con2 = App.createDataBaseConnector();


            String query2 = "SELECT f.IdFilm, s.IdRuangan, f.NamaFilm, s.NamaRuangan, f.Tanggal, f.Jam, s.lantai\n" +
                    "FROM Film f \n" +
//                    "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +
//                    "INNER JOIN Film f ON (t.IdFilm = f.IdFilm)\n" +
//            "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
//                    "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
                    "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n" +
                    "WHERE CheckBox IS NULL";

            Statement st2 = con2.createStatement();
            ResultSet queryOutput2 = st2.executeQuery(query2);

            while(queryOutput2.next())
            {
                int queryIdFilm = queryOutput2.getInt("IdFilm");
                int queryIdRuangan = queryOutput2.getInt("IdRuangan");
                int queryLantai = queryOutput2.getInt("lantai");
                String queryNamaFilm = queryOutput2.getString("NamaFilm");
                String queryNamaRuangan = queryOutput2.getString("NamaRuangan");
                String queryTanggal = queryOutput2.getString("Tanggal");
                String queryJam = queryOutput2.getString("Jam");

                film.add(new TableAdd(queryIdFilm, queryIdRuangan, queryNamaFilm, queryNamaRuangan, queryTanggal, queryJam, queryLantai));
            }

            idFilmColumn.setCellValueFactory(new PropertyValueFactory<>("idFilm"));
            idRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("idRuangan"));
            namaFilmColumn.setCellValueFactory(new PropertyValueFactory<>("namaFilm"));
            namaRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("namaRuangan"));
            tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
            jamColumn.setCellValueFactory(new PropertyValueFactory<>("jam"));
            lantaiColumn.setCellValueFactory(new PropertyValueFactory<>("lantai"));

            tableFilm.setItems(film);

//            Connection con3 = App.createDataBaseConnector();
//
//            String query3 = "SELECT f.IdFilm\n" +

// //                    "FROM Transaksi t\n" +
// //                    "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +

//                        "FROM Film f\n" +

// //                    "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
// //                    "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
// //                    "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n" +

//                    "WHERE f.CheckBox IS NULL AND f.idRuangan = '" + idFilm.getText() + "' AND f.jam = '" + jam.getText() + "'";
//
//            Statement st3 = con3.createStatement();
//            ResultSet queryOutput3 = st3.executeQuery(query3);
//
//            while(queryOutput3.next())
//            {
//                add = queryOutput3.getInt("IdFilm");
//            }

            tanggalTransaksi.setValue(java.time.LocalDate.now());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }


    }

    @FXML
    public void onAddButton() throws SQLException, ClassNotFoundException
    {

        try
        {
            Connection con3 = App.createDataBaseConnector();

            String query3 = "SELECT f.IdFilm\n" +
                    "FROM Film f\n" +
                    "WHERE f.CheckBox IS NULL AND f.idRuangan = '" + idRuangan.getText() + "' AND f.jam = '" + jam.getText() + "'";

            Statement st3 = con3.createStatement();
            ResultSet queryOutput3 = st3.executeQuery(query3);

            while(queryOutput3.next())
            {
                SidFilm = queryOutput3.getInt("IdFilm");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }


        Connection con = App.createDataBaseConnector();

        String query = "INSERT INTO Transaksi (IdAkun, IdFilm, IdRuangan, TanggalTransaksi, JumlahTiket, JumlahTotal)\n" +
        "VALUES (" +  idAkun.getText() + "," + SidFilm + "," + idRuangan.getText() + "," + "'" + tanggalTransaksi.getValue().toString() + "'," + jumlahTiket.getText() + "," + jumlahTotal.getText() + ")";

//        System.out.println(query);

        try
        {
          Statement st = con.createStatement();
          st.executeUpdate(query);

          System.out.println("* Transaction Succeed *");

        } catch (SQLException a) {
//            System.out.println(a.getMessage());
            System.out.println("! Transaction Failed !");
        }

        idAkun.setText("");
        idRuangan.setText("");
        jam.setText("");
        jumlahTiket.setText("");
        jumlahTotal.setText("");


    }

    @FXML
    public void onBack()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene2 = app.getScene2();
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Home page");
    }
}
