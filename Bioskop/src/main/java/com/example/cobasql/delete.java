package com.example.cobasql;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class delete{

    private Stage primaryStage;
    private Scene sceneDel;
    private delete deleteCon;

    @FXML
    private TextField filmDihapus = new TextField();

    private String filmDihapusString = filmDihapus.getText();

    @FXML
    private TableView<Film> tableFilm;
//    ObservableList<Film> data = FXCollections.observableArrayList();


//    static String driver = "com.mysql.cj.jdbc.Driver";
//    static String url = "jdbc:mysql://localhost:3307/bioskop?&serverTimezone=UTC";
//    static String user = "root";
//    static String password = "";

    public TableView<Film> getTableFilm() {
        return tableFilm;
    }

    public void setTableFilm(TableView<Film> tableFilm) {
        this.tableFilm = tableFilm;
    }

    @FXML
    public void onBackButton()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene2 = app.getScene2();
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Home page");
    }

//    protected void initialize() {
//        try {
//            Connection con =  App.createDataBaseConnector();
//            String query = "select * from film";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            int column_count = rs.getMetaData().getColumnCount();
//            if(column_count > 0)
//            {
//                while (rs.next())
//                {
//                    String IdFilm = rs.getString(1);
//                    String NamaFilm = rs.getString(2);
//                    String BatasUsia = rs.getString(3);
//                    String Sinopsis = rs.getString(4);
//                    data.add(new Film(IdFilm,NamaFilm,BatasUsia,Sinopsis));
//                    System.out.println(NamaFilm);
//
//                }
//            }
//            tableFilm.setItems(data);
//            tableFilm.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IdFilm"));
//            tableFilm.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
//            tableFilm.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BatasUsia"));
//            tableFilm.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Sinopsis"));
//        }
//        catch(SQLException e)
//        {
//            System.out.println(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @FXML
    protected void onDeleteClick() throws SQLException, ClassNotFoundException {
        ObservableList<Film> data = FXCollections.observableArrayList();
        Film selected = tableFilm.getSelectionModel().getSelectedItem();
        if(selected != null) {
            Connection con =  App.createDataBaseConnector();
        }
            Alert alert = new Alert(Alert.AlertType.NONE, "Hapus Film dengan Nama: " + selected.getSinopsis() , ButtonType.YES, ButtonType.NO);
            alert.setTitle("Delete Selected");
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES) {
                Connection con =  App.createDataBaseConnector();
                String query = "select * from film WHERE CheckBox IS NULL";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                int column_count = rs.getMetaData().getColumnCount();
                if(column_count > 0)
                {
                    while (rs.next())
                    {
                        if (rs.getString(1).equalsIgnoreCase(selected.getIdFilm())) {
//                            String queryupdate = "DELETE FROM `film` WHERE `IdFilm` = " + selected.getIdFilm() + "";
//                            PreparedStatement ps = con.prepareStatement(queryupdate);
//                            ps.executeUpdate();
                            tableFilm.setEditable(true);
                            int index = tableFilm.getSelectionModel().getSelectedIndex();
                            tableFilm.getItems().remove(index);
                        }

                    }
//                }
                }
                String q = "UPDATE film SET CheckBox = 'D' WHERE IdFilm = '" + selected.getIdFilm() + "'";
                Statement st2 = con.createStatement();
                st2.executeUpdate(q);
//                String query = "select * from film WHERE CheckBox IS NULL";
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery(query);
//                int column_count = rs.getMetaData().getColumnCount();
//                if(column_count > 0)
//                {
//                    while (rs.next())
//                    {
//                        if (rs.getString(1).equalsIgnoreCase(selected.getIdFilm())) {
////                            String queryupdate = "DELETE FROM `film` WHERE `IdFilm` = " + selected.getIdFilm() + "";
////                            PreparedStatement ps = con.prepareStatement(queryupdate);
////                            ps.executeUpdate();
//                            System.out.println("lala");
//                            tableFilm.setEditable(true);
//                            int index = tableFilm.getSelectionModel().getSelectedIndex();
//                            tableFilm.getItems().remove(index);
//                        }
//
//                    }
////                }
//            }


            System.out.println("Film dihapus");

        }
        else {
            alert = new Alert(Alert.AlertType.NONE, "Tidak ada Film yang dipilih", ButtonType.OK);
            alert.setTitle("Delete Selected");
            alert.showAndWait();
        }
    }
    public void initialize() {
        try {
            ObservableList<Film> data = FXCollections.observableArrayList();
            Connection con =  App.createDataBaseConnector();
            String query = "SELECT * FROM Film WHERE CheckBox IS NULL";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int column_count = rs.getMetaData().getColumnCount();
            if(column_count > 0)
            {
                while (rs.next())
                {
                    String IdFilm = rs.getString("IdFilm");
                    String NamaFilm = rs.getString("Jam");
                    String BatasUsia = rs.getString("Tanggal");
                    String Sinopsis = rs.getString("NamaFilm");
                    data.add(new Film(IdFilm,NamaFilm,BatasUsia,Sinopsis));

                }
            }
            tableFilm.setItems(data);
            tableFilm.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IdFilm"));
            tableFilm.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("NamaFilm"));
            tableFilm.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("BatasUsia"));
            tableFilm.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Sinopsis"));
        }
        catch(SQLException e)
        {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



//    @Override
//    public void start(Stage stage) throws Exception {
//        this.primaryStage = stage;
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("delete.fxml"));
//        sceneDel = new Scene(fxmlLoader.load());
//        deleteCon = fxmlLoader.getController();
//        stage.setScene(sceneDel);
//        deleteCon.initialize();
//        stage.show();
//
//    }
}
