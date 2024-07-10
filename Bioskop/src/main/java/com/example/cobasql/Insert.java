package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Insert{
    @FXML
    private TextField nmFilm;
    @FXML
    private TextField batas;
    @FXML
    private TextField sinop;
    @FXML
    private TextField studio;
    @FXML
    private TextField jam;
    @FXML
    private TableView<Studio> table;
    @FXML
    DatePicker dp;
    ObservableList<Studio> data = FXCollections.observableArrayList();

    @FXML
    protected void onButtonClick() {
        System.out.println(dp.getValue().toString());
        try {
            Connection con = App.createDataBaseConnector();
//            String query = "INSERT INTO Film (NamaFilm, batasUsia, sinopsis, IdRuangan, Tanggal, Jam) VALUES (?,?,?,?,?,?)";
//            PreparedStatement st = con.prepareStatement(query);
//            st.setString(1,nmFilm.getText());
//            st.setString(2,batas.getText());
//            st.setString(3,sinop.getText());
//            st.setInt(4,Integer.parseInt(studio.getText()));
//            st.setString(5,dp.getValue().toString());
//            st.setString(6,jam.getText());
//            st.executeUpdate();

            String query = "INSERT INTO Film (NamaFilm, BatasUsia, Sinopsis, IdRuangan, Tanggal, Jam)\n" +
                    "VALUES ('" + nmFilm.getText() + "','" + batas.getText() + "','" + sinop.getText() + "'," + studio.getText() + ",'" + dp.getValue().toString() + "','" + jam.getText() + "')";

            nmFilm.setText("");
            batas.setText("");
            sinop.setText("");
            studio.setText("");
            jam.setText("");

            Statement st = con.createStatement();
            st.executeUpdate(query);


        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void initialize() {
        try {
            int i=1;
            Connection con = App.createDataBaseConnector();
            String query = "select * from studio";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int column_count = rs.getMetaData().getColumnCount();
            if (column_count > 0) // ada data
            {
                while (rs.next()) {
                    int no=i;
                    String nama = rs.getString(2);
                    String lantai = rs.getString(3);
                    data.add(new Studio(no,nama, lantai));
                    i++;
                }
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }

        table.setItems(data);
        TableColumn<Studio, Integer> column1 = new TableColumn<>("No");
        column1.setCellValueFactory(new PropertyValueFactory("no"));
        table.getColumns().add(column1);

        TableColumn<Studio, String> column2 = new TableColumn<>("Nama Studio");
        column2.setCellValueFactory(new PropertyValueFactory("nama"));
        table.getColumns().add(column2);

        TableColumn<Studio, String> column3 = new TableColumn<>("Lantai");
        column3.setCellValueFactory(new PropertyValueFactory("lantai"));
        table.getColumns().add(column3);
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

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            int i=1;
//            Connection con = App.createDataBaseConnector();
//            String query = "select * from studio";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            int column_count = rs.getMetaData().getColumnCount();
//            if (column_count > 0) // ada data
//            {
//                while (rs.next()) {
//                    int no=i;
//                    String nama = rs.getString(2);
//                    String lantai = rs.getString(3);
//                    data.add(new Studio(no,nama, lantai));
//                    i++;
//                }
//            }
//            con.close();
//        } catch (ClassNotFoundException e) {
//            System.out.println(e);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//        table.setItems(data);
//        TableColumn<Studio, Integer> column1 = new TableColumn<>("No");
//        column1.setCellValueFactory(new PropertyValueFactory("no"));
//        table.getColumns().add(column1);
//
//        TableColumn<Studio, String> column2 = new TableColumn<>("Nama Studio");
//        column2.setCellValueFactory(new PropertyValueFactory("nama"));
//        table.getColumns().add(column2);
//
//        TableColumn<Studio, String> column3 = new TableColumn<>("Lantai");
//        column3.setCellValueFactory(new PropertyValueFactory("lantai"));
//        table.getColumns().add(column3);
//
//    }
}
