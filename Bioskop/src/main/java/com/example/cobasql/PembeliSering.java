package com.example.cobasql;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PembeliSering{

    private Stage primaryStage;
    private Scene sceneSrg;
    private PembeliSering conSrg;
//    static String driver = "com.mysql.cj.jdbc.Driver";
//    static String url = "jdbc:mysql://localhost:3307/bioskop?&serverTimezone=UTC";
//    static String user = "root";
//    static String password = "";

    protected String id;
    protected String nama;
    protected String email;

    @FXML
    TableColumn<dataPembeliSering, String> idColumn;

    @FXML
    TableColumn<dataPembeliSering, String> jmlhTransColumn;

    @FXML
    private TableView<dataPembeliSering> table;

//    ObservableList<dataPembeliSering> data = FXCollections.observableArrayList();

    @FXML
    protected Label idl;
    @FXML
    protected Label  namal;
    @FXML
    protected Label emaill;

    @FXML
    public void onBackButton()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene2 = app.getScene2();
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Home page");
    }

    @FXML
    protected void pembeliPalingSering() {
        try {
            ObservableList<dataPembeliSering> data = FXCollections.observableArrayList();
            String idPembeli = "";
//            Class.forName(driver);
            String query = "select * from transaksi";
            Connection con = App.createDataBaseConnector();
            Statement st = con.createStatement();
            String queryUpdate = "select idakun, count(*)  from transaksi group by idakun";
            PreparedStatement ps = con.prepareStatement(queryUpdate);
            ResultSet rs = st.executeQuery(queryUpdate);


//            boolean pertama = true;

            while (rs.next()) {
                String IdCust = rs.getString(1);
                String jmlhTrans = rs.getString(2);
                data.add(new dataPembeliSering(IdCust, jmlhTrans));
//                if (pertama) {
//                    idPembeli = rs.getString(1);
//                    System.out.println("hai");
//                    pertama = false;
//                }
//                else {
//
//                }

            }

            table.setItems(data);
            table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IdCust"));
            table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jumlahTransaksi"));

//            query = "select * from akun";
//            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            ps = con.prepareStatement(queryUpdate);
//            rs = st.executeQuery(query);

//            while (rs.next()) {
//                if (idPembeli.equalsIgnoreCase(rs.getString(1))) {
//
//                    idl.setText(rs.getString(1));
//                    namal.setText(rs.getString(3));
//                    emaill.setText(rs.getString(4));
//                }
//            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void onRefresh()
    {
        try {
            ObservableList<dataPembeliSering> data = FXCollections.observableArrayList();
            String idPembeli = "";
//            Class.forName(driver);
            String query = "select * from transaksi";
            Connection con = App.createDataBaseConnector();
            Statement st = con.createStatement();
            String queryUpdate = "select idakun, count(*)  from transaksi group by idakun";
            PreparedStatement ps = con.prepareStatement(queryUpdate);
            ResultSet rs = st.executeQuery(queryUpdate);


//            boolean pertama = true;

            while (rs.next()) {
                String IdCust = rs.getString("idakun");
                String jmlhTrans = rs.getString("count(*)");
                data.add(new dataPembeliSering(IdCust, jmlhTrans));
//                if (pertama) {
//                    idPembeli = rs.getString(1);
//                    System.out.println("hai");
//                    pertama = false;
//                }
//                else {
//
//                }

            }

            idColumn.setCellValueFactory(new PropertyValueFactory<>("IdCust"));
            jmlhTransColumn.setCellValueFactory(new PropertyValueFactory<>("jumlahTransaksi"));
            table.setItems(data);
//            table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IdCust"));
//            table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jumlahTransaksi"));

//            query = "select * from akun";
//            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            ps = con.prepareStatement(queryUpdate);
//            rs = st.executeQuery(query);

//            while (rs.next()) {
//                if (idPembeli.equalsIgnoreCase(rs.getString(1))) {
//
//                    idl.setText(rs.getString(1));
//                    namal.setText(rs.getString(3));
//                    emaill.setText(rs.getString(4));
//                }
//            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    public void initialize() {

        try {
            ObservableList<dataPembeliSering> data = FXCollections.observableArrayList();
            String idPembeli = "";
//            Class.forName(driver);
            String query = "select * from transaksi";
            Connection con = App.createDataBaseConnector();
            Statement st = con.createStatement();
            String queryUpdate = "select idakun, count(*)  from transaksi group by idakun";
            PreparedStatement ps = con.prepareStatement(queryUpdate);
            ResultSet rs = st.executeQuery(queryUpdate);


//            boolean pertama = true;

            while (rs.next()) {
                String IdCust = rs.getString("idakun");
                String jmlhTrans = rs.getString("count(*)");
                data.add(new dataPembeliSering(IdCust, jmlhTrans));
//                if (pertama) {
//                    idPembeli = rs.getString(1);
//                    System.out.println("hai");
//                    pertama = false;
//                }
//                else {
//
//                }

            }

            idColumn.setCellValueFactory(new PropertyValueFactory<>("IdCust"));
            jmlhTransColumn.setCellValueFactory(new PropertyValueFactory<>("jumlahTransaksi"));
            table.setItems(data);
//            table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IdCust"));
//            table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("jumlahTransaksi"));

//            query = "select * from akun";
//            con = DriverManager.getConnection(url, user, password);
//            st = con.createStatement();
//            ps = con.prepareStatement(queryUpdate);
//            rs = st.executeQuery(query);

//            while (rs.next()) {
//                if (idPembeli.equalsIgnoreCase(rs.getString(1))) {
//
//                    idl.setText(rs.getString(1));
//                    namal.setText(rs.getString(3));
//                    emaill.setText(rs.getString(4));
//                }
//            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }

//    @Override
//    public void start(Stage stage) throws Exception {
//        this.primaryStage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pembelisering.fxml"));
//        sceneSrg = new Scene(fxmlLoader.load());
//        conSrg = fxmlLoader.getController();
//        stage.setScene(sceneSrg);
//        stage.show();
//    }
}
