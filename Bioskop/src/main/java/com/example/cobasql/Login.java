package com.example.cobasql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private TextField email;

    public void switchToSceneData()
    {
        App app = App.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene2 = app.getScene2();
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Home page");
    }

    @FXML
    public void onLoginButton() {

//        ObservableList<Mahasiswa> data = FXCollections.observableArrayList();
        ObservableList<Admin> data = FXCollections.observableArrayList();
        try {
            Connection con = App.createDataBaseConnector();
            String query = "SELECT * FROM admin";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            if (columnCount > 0) {
                while (rs.next()) {

//                    String password = rs.getString("nrp");
//                    String username = rs.getString("nama");
//                    System.out.println("Username: " + username);
//                    System.out.println("Password: " + password);
//                    data.add(new Mahasiswa(123,username));

                    String username = rs.getString("Username");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    data.add(new Admin(username, email, password));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException a) {
            System.out.println(a.getMessage());
        }

        boolean sf = false;

        for (int i = 0; i < data.size(); i++)
        {
//            if (data.get(i).getNama().equalsIgnoreCase(String.valueOf(this.username.getCharacters())))
//                System.out.println("Login successful");
            if (data.get(i).getNamaAkun().equalsIgnoreCase(String.valueOf(this.username.getText())) && data.get(i).getEmail().equalsIgnoreCase(String.valueOf(this.email.getText())) && data.get(i).getPassword().equalsIgnoreCase(String.valueOf(this.password.getText())))
                sf = true;
        }

        this.username.setText("");
        this.email.setText("");
        this.password.setText("");

        sf = true;

        if (sf)
            switchToSceneData();
        else
            System.out.println("Login unsuccessful");
    }

}
