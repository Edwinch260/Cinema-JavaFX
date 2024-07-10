package com.example.cobasql;

import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Data implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TextField title;

    @FXML
    private TextField studio;

    @FXML
    private TextField time;

    @FXML
    private TextField accountName;

    @FXML
    private TextArea info;

    @FXML
    TableColumn<Table, String> namaFilmColumn;

    @FXML
    TableColumn<Table, String> batasUsiaColumn;

    @FXML
    TableColumn<Table, String> sinopsisColumn;

    @FXML
    TableColumn<Table, String> namaRuanganColumn;

    @FXML
    TableColumn<Table, Integer> lantaiColumn;

    @FXML
    TableColumn<Table, String> tanggalColumn;

    @FXML
    TableColumn<Table, String> tanggalTransaksiColumn;

    @FXML
    TableColumn<Table, String> idAkunColumn;

    @FXML
    TableColumn<Table, String> namaAkunColumn;

    @FXML
    TableColumn<Table, String> emailColumn;

    @FXML
    TableColumn<Table, String> virtualAccountColumn;

    @FXML
    TableColumn<Table, String> jamColumn;

    @FXML
    TableColumn<Table, Integer> jumlahTiketColumn;

    @FXML
    TableColumn<Table, Integer> jumlahTotalColumn;

    @FXML
    TableView<Table> tableView;


    public void switchToSceneTerbanyak()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene sceneProdukSering = app.getSceneProdukScene();
        primaryStage.setScene(sceneProdukSering);
        primaryStage.setTitle("Most Bought page");
    }

    public void switchToSceneUpdate()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene sceneUpdate = app.getSceneUpdateFilm();
        primaryStage.setScene(sceneUpdate);
        primaryStage.setTitle("Update page");
    }

    public void switchToSceneAdd()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene sceneAdd = app.getSceneAdd();
        primaryStage.setScene(sceneAdd);
        primaryStage.setTitle("Add page");
    }

    public void switchToScenePembeliSering()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scenePembeliSering = app.getPembeliSeringScene();
        primaryStage.setScene(scenePembeliSering);
        primaryStage.setTitle("Loyal Customer page");
    }

    public void switchToSceneDelete()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene sceneDelete = app.getSceneDelete();
        primaryStage.setScene(sceneDelete);
        primaryStage.setTitle("Delete page");
    }

    public void switchToSceneLaporan()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene3 = app.getScene3();
        primaryStage.setScene(scene3);
        primaryStage.setTitle("Total sales page");

    }

    public void switchToSceneLaporan2()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene4 = app.getScene4();
        primaryStage.setScene(scene4);
        primaryStage.setTitle("Monthly sales page");
    }

    @FXML
    public void onAddAdminButton() {
        try {
            Connection con = App.createDataBaseConnector();
            String query = "INSERT INTO admin" + "(IdAdmin, Username, Email, Password) " + "VALUES (NULL, '" + this.username.getCharacters() + "','" + this.email.getCharacters() + "','" + this.password.getCharacters() + "')";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            this.info.setText("Admin added");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }

    @FXML
    public void onLogout()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene1 = app.getScene1();
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Login page");
    }

    @FXML
    public void onViewAllButton()
    {
        try {
            info.setText("Recently Viewed All");
            ObservableList<Table> table = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();


            String query = "SELECT a.NamaAkun, a.Email, a.VirtualAccount, f.NamaFilm, s.NamaRuangan, f.Tanggal, f.Jam, t.JumlahTiket, t.TanggalTransaksi, t.JumlahTotal, a.idAkun, f.BatasUsia, f.Sinopsis, s.lantai\n" +
            "FROM Transaksi t\n" +
            "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +
            "INNER JOIN Film f ON (t.IdFilm = f.IdFilm)\n" +
//            "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
//            "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
            "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n";

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryNamaAkun = queryOutput.getString("NamaAkun");
                String queryEmail = queryOutput.getString("Email");
                String queryVirtualAccount = queryOutput.getString("VirtualAccount");
                String queryNamaFilm = queryOutput.getString("NamaFilm");
                String queryNamaRuangan = queryOutput.getString("NamaRuangan");
                String queryTanggal = queryOutput.getString("Tanggal");
                String queryJam = queryOutput.getString("Jam");
                String queryTanggalTransaksi = queryOutput.getString("TanggalTransaksi");
                int queryJumlahTiket = queryOutput.getInt("JumlahTiket");
                int queryJumlahTotal = queryOutput.getInt("JumlahTotal");
                int queryIdAkun = queryOutput.getInt("IdAkun");
                int queryLantai = queryOutput.getInt("lantai");
                String queryBatasUsia = queryOutput.getString("BatasUsia");
                String querySinopsis = queryOutput.getString("Sinopsis");

                table.add(new Table(queryNamaFilm, queryNamaRuangan, queryTanggal, queryNamaAkun, queryEmail, queryVirtualAccount, queryJam, queryJumlahTiket, queryTanggalTransaksi, queryJumlahTotal, queryIdAkun, queryBatasUsia, querySinopsis, queryLantai));
            }

            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("NamaAkun"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            virtualAccountColumn.setCellValueFactory(new PropertyValueFactory<>("VirtualAccount"));
            namaFilmColumn.setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
            namaRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("NamaRuangan"));
            tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
            jamColumn.setCellValueFactory(new PropertyValueFactory<>("Jam"));
            jumlahTiketColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTiket"));
            tanggalTransaksiColumn.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
            jumlahTotalColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTotal"));
            idAkunColumn.setCellValueFactory(new PropertyValueFactory<>("IdAkun"));
            batasUsiaColumn.setCellValueFactory(new PropertyValueFactory<>("BatasUsia"));
            sinopsisColumn.setCellValueFactory(new PropertyValueFactory<>("Sinopsis"));
            lantaiColumn.setCellValueFactory(new PropertyValueFactory<>("lantai"));

            tableView.setItems(table);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }

    @FXML
    public void onViewButton()
    {
        try {
            info.setText("Recently Viewed");
            ObservableList<Table> table = FXCollections.observableArrayList();
            Connection con = App.createDataBaseConnector();

            String search = "";
            if (title.getText() != "")
            {
                if (search.isEmpty())
                    search = search + "f.NamaFilm = '" + title.getText() + "'";
                else
                    search = search + " AND f.NamaFilm = '" + title.getText() + "'";
            }
            if (studio.getText() != "")
            {
                if (search.isEmpty())
                    search = search + "s.NamaRuangan = '" + studio.getText() + "'";
                else
                    search = search + " AND s.NamaRuangan = '" + studio.getText() + "'";
            }
            if (fromDate.getValue() != null && fromDate.getValue().toString() != "")
            {
                if (search.isEmpty())
                    search = search + "f.Tanggal >= '" + fromDate.getValue().toString() + "'";
                else
                    search = search + " AND f.Tanggal >= '" + fromDate.getValue().toString()  + "'";
            }
            if (toDate.getValue() != null && toDate.getValue().toString() != "")
            {
                if (search.isEmpty())
                    search = search + "f.Tanggal <= '" + toDate.getValue().toString() + "'";
                else
                    search = search + " AND f.Tanggal <= '" + toDate.getValue().toString()  + "'";
            }
            if (time.getText() != "")
            {
                if (search.isEmpty())
                    search = search + "f.Jam = '" + time.getText() + "'";
                else
                    search = search + " AND f.Jam = '" + time.getText() + "'";
            }
            if (accountName.getText() != "")
            {
                if (search.isEmpty())
                    search = search + "a.NamaAkun = '" + accountName.getText() + "'";
                else
                    search = search + " AND a.NamaAkun = '" + accountName.getText() + "'";
            }

            if (!search.isEmpty())
                search = "WHERE " + search;

            String query = "SELECT a.NamaAkun, a.Email, a.VirtualAccount, f.NamaFilm, s.NamaRuangan, f.Tanggal, f.Jam, t.JumlahTiket, t.TanggalTransaksi, t.JumlahTotal, a.idAkun, f.BatasUsia, f.Sinopsis, s.lantai\n" +
                    "FROM Transaksi t\n" +
                    "INNER JOIN Akun a ON (t.IdAkun = a.IdAkun)\n" +
                    "INNER JOIN Film f ON (t.IdFilm = f.IdFilm)\n" +
//                    "INNER JOIN JamTayang jt ON (t.IdJam = jt.IdJam)\n" +
//                    "INNER JOIN TanggalTayang tt ON (f.IdTanggal = tt.IdTanggal)\n" +
                    "INNER JOIN Studio s ON (f.IdRuangan = s.IdRuangan)\n"
                    + search;

            Statement st = con.createStatement();
            ResultSet queryOutput = st.executeQuery(query);

            while(queryOutput.next())
            {
                String queryNamaAkun = queryOutput.getString("NamaAkun");
                String queryEmail = queryOutput.getString("Email");
                String queryVirtualAccount = queryOutput.getString("VirtualAccount");
                String queryNamaFilm = queryOutput.getString("NamaFilm");
                String queryNamaRuangan = queryOutput.getString("NamaRuangan");
                String queryTanggal = queryOutput.getString("Tanggal");
                String queryJam = queryOutput.getString("Jam");
                int queryJumlahTiket = queryOutput.getInt("JumlahTiket");
                String queryTanggalTransaksi = queryOutput.getString("TanggalTransaksi");
                int queryJumlahTotal = queryOutput.getInt("JumlahTotal");
                int queryIdAkun = queryOutput.getInt("IdAkun");
                String queryBatasUsia = queryOutput.getString("BatasUsia");
                String querySinopsis = queryOutput.getString("Sinopsis");
                int queryLantai = queryOutput.getInt("Lantai");

                table.add(new Table(queryNamaFilm, queryNamaRuangan, queryTanggal, queryNamaAkun, queryEmail, queryVirtualAccount, queryJam, queryJumlahTiket, queryTanggalTransaksi, queryJumlahTotal, queryIdAkun, queryBatasUsia, querySinopsis, queryLantai));
            }

            namaAkunColumn.setCellValueFactory(new PropertyValueFactory<>("NamaAkun"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            virtualAccountColumn.setCellValueFactory(new PropertyValueFactory<>("VirtualAccount"));
            namaFilmColumn.setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
            namaRuanganColumn.setCellValueFactory(new PropertyValueFactory<>("NamaRuangan"));
            tanggalColumn.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
            jamColumn.setCellValueFactory(new PropertyValueFactory<>("Jam"));
            jumlahTiketColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTiket"));
            tanggalTransaksiColumn.setCellValueFactory(new PropertyValueFactory<>("TanggalTransaksi"));
            jumlahTotalColumn.setCellValueFactory(new PropertyValueFactory<>("JumlahTotal"));
            idAkunColumn.setCellValueFactory(new PropertyValueFactory<>("IdAkun"));
            batasUsiaColumn.setCellValueFactory(new PropertyValueFactory<>("BatasUsia"));
            sinopsisColumn.setCellValueFactory(new PropertyValueFactory<>("Sinopsis"));
            lantaiColumn.setCellValueFactory(new PropertyValueFactory<>("Lantai"));

            tableView.setItems(table);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }
    }

    @FXML
    public void onTotalIncomeButton()
    {
        info.setText("Recent Activity on Total Income");
        switchToSceneLaporan();
    }

    @FXML
    public void onMonthlyIncomeButton()
    {
        info.setText("Recent Activity on Monthly Income");
        switchToSceneLaporan2();
    }

    @FXML
    public void onDeleteButton()
    {
        info.setText("Recent Activity on Delete Section");
        switchToSceneDelete();
    }

    @FXML
    public void onLoyalCustomerButton()
    {
        info.setText("Recent Activity on Loyal Customer");
        switchToScenePembeliSering();
    }

    @FXML
    public void onAddButton()
    {
        info.setText("Recent Activity on Add Section");
        switchToSceneAdd();
    }

    @FXML
    public void onUpdateButton()
    {
        info.setText("Recent Activity on Update Section");
        switchToSceneUpdate();
    }

    @FXML
    public void onMostBoughtButton()
    {
        info.setText("Recent Activity on Most Bought");
        switchToSceneTerbanyak();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.setEditable(false);
    }
}
