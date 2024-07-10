package com.example.cobasql;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App extends Application {

    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/bioskop?&serverTimezone=UTC";
    final static String user = "root";
    final static String password = "";

    private Stage primaryStage;

    private Scene scene1;
    private Login sceneLoginController;
    private Scene scene2;
    private Data sceneDataController;

    private Scene scene3;
    private Laporan sceneLaporanController;

    private Scene scene4;
    private Laporan2 sceneLaporan2Controller;

    private Scene sceneDelete;

    private delete sceneDeleteController;

    private Scene pembeliSeringScene;
    private PembeliSering scenePembeliSeringController;

    private Scene sceneAdd;

    private Add sceneAddController;

    private Scene sceneUpdateFilm;

    private Insert sceneUpdateController;

    private Scene sceneTerbanyak;

    private Scene sceneProdukScene;
    private ProdukSering sceneProdukSeringController;

//    private HelloController sceneTerbanyakController;
    private static App applicationInstance;



    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
        scene1 = new Scene(fxmlLoader.load());
        sceneLoginController = fxmlLoader.getController();
        stage.setScene(scene1);
        stage.setTitle("Login page");


        fxmlLoader = new FXMLLoader(App.class.getResource("Data.fxml"));
        scene2 = new Scene(fxmlLoader.load());
        sceneDataController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(App.class.getResource("Laporan.fxml"));
        scene3 = new Scene(fxmlLoader.load());
        sceneLaporanController = fxmlLoader.getController();
        sceneLaporanController.initialize();

        fxmlLoader = new FXMLLoader(App.class.getResource("Laporan2.fxml"));
        scene4 = new Scene(fxmlLoader.load());
        sceneLaporan2Controller = fxmlLoader.getController();
        sceneLaporan2Controller.initialize();

        fxmlLoader = new FXMLLoader(App.class.getResource("delete.fxml"));
        sceneDelete = new Scene(fxmlLoader.load());
        sceneDeleteController = fxmlLoader.getController();
        stage.setOnShowing(event -> {
            sceneDeleteController.initialize();
        });

        fxmlLoader = new FXMLLoader(App.class.getResource("pembelisering.fxml"));
        pembeliSeringScene = new Scene(fxmlLoader.load());
        scenePembeliSeringController = fxmlLoader.getController();
        stage.setOnShowing(event -> {
            scenePembeliSeringController.initialize();
        });
//        scenePembeliSeringController.initialize();

        fxmlLoader = new FXMLLoader(App.class.getResource("Add.fxml"));
        sceneAdd = new Scene(fxmlLoader.load());
        sceneAddController = fxmlLoader.getController();
        stage.setOnShowing(event -> {
            sceneAddController.initialize();
        });

        fxmlLoader = new FXMLLoader(App.class.getResource("insert.fxml"));
        sceneUpdateFilm = new Scene(fxmlLoader.load());
        sceneUpdateController = fxmlLoader.getController();
        stage.setOnShowing(event -> {
            sceneUpdateController.initialize();
        });

//        fxmlLoader = new FXMLLoader(App.class.getResource("hello-view (1).fxml"));
//        sceneTerbanyak = new Scene(fxmlLoader.load());
//        sceneTerbanyakController = fxmlLoader.getController();
//        sceneTerbanyakController.Initilaize();

        fxmlLoader = new FXMLLoader(App.class.getResource("ProdukSering.fxml"));
        sceneProdukScene= new Scene(fxmlLoader.load());
        sceneProdukSeringController = fxmlLoader.getController();
        stage.setOnShowing(event -> {
            sceneProdukSeringController.initialize();
        });

        stage.show();
    }

    public static Connection createDataBaseConnector()throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con= DriverManager.getConnection(url,user,password);
        return con;
    }

    public static void main(String[] args) {
        launch();
    }


    public Scene getScene1() {
        return scene1;
    }

    public void setScene1(Scene scene1) {
        this.scene1 = scene1;
    }

    public Login getSceneLoginController() {
        return sceneLoginController;
    }

    public void setSceneLoginController(Login sceneLoginController) {
        this.sceneLoginController = sceneLoginController;
    }

    public Scene getScene2() {
        return scene2;
    }

    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }

    public Data getSceneDataController() {
        return sceneDataController;
    }

    public void setSceneDataController(Data sceneDataController) {
        this.sceneDataController = sceneDataController;
    }

    public static App getApplicationInstance() {
        return applicationInstance;
    }

    public static void setApplicationInstance(App applicationInstance) {
        App.applicationInstance = applicationInstance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public App(){
        applicationInstance = this;
    }

    public Scene getScene3() {
        return scene3;
    }

    public void setScene3(Scene scene3) {
        this.scene3 = scene3;
    }

    public Laporan getSceneLaporanController() {
        return sceneLaporanController;
    }

    public void setSceneLaporanController(Laporan sceneLaporanController) {
        this.sceneLaporanController = sceneLaporanController;
    }

    public Scene getScene4() {
        return scene4;
    }

    public void setScene4(Scene scene4) {
        this.scene4 = scene4;
    }

    public Laporan2 getSceneLaporan2Controller() {
        return sceneLaporan2Controller;
    }

    public void setSceneLaporan2Controller(Laporan2 sceneLaporan2Controller) {
        this.sceneLaporan2Controller = sceneLaporan2Controller;
    }

    public Scene getSceneDelete() {
        return sceneDelete;
    }

    public void setSceneDelete(Scene sceneDelete) {
        this.sceneDelete = sceneDelete;
    }

    public delete getSceneDeleteController() {
        return sceneDeleteController;
    }

    public void setSceneDeleteController(delete sceneDeleteController) {
        this.sceneDeleteController = sceneDeleteController;
    }

    public Scene getPembeliSeringScene() {
        return pembeliSeringScene;
    }

    public void setPembeliSeringScene(Scene pembeliSeringScene) {
        this.pembeliSeringScene = pembeliSeringScene;
    }

    public PembeliSering getScenePembeliSeringController() {
        return scenePembeliSeringController;
    }

    public void setScenePembeliSeringController(PembeliSering scenePembeliSeringController) {
        this.scenePembeliSeringController = scenePembeliSeringController;
    }

    public Scene getSceneAdd() {
        return sceneAdd;
    }

    public void setSceneAdd(Scene sceneAdd) {
        this.sceneAdd = sceneAdd;
    }

    public Add getSceneAddController() {
        return sceneAddController;
    }

    public void setSceneAddController(Add sceneAddController) {
        this.sceneAddController = sceneAddController;
    }

    public Scene getSceneUpdateFilm() {
        return sceneUpdateFilm;
    }

    public void setSceneUpdateFilm(Scene sceneUpdateFilm) {
        this.sceneUpdateFilm = sceneUpdateFilm;
    }

    public Insert getSceneUpdateController() {
        return sceneUpdateController;
    }

    public void setSceneUpdateController(Insert sceneUpdateController) {
        this.sceneUpdateController = sceneUpdateController;
    }

    public Scene getSceneTerbanyak() {
//        sceneTerbanyakController.Initilaize();
        return sceneTerbanyak;
    }

    public void setSceneTerbanyak(Scene sceneTerbanyak) {
        this.sceneTerbanyak = sceneTerbanyak;
    }

    public Scene getSceneProdukScene() {
        return sceneProdukScene;
    }

    public void setSceneProdukScene(Scene sceneProdukScene) {
        this.sceneProdukScene = sceneProdukScene;
    }

    public ProdukSering getSceneProdukSeringController() {
        return sceneProdukSeringController;
    }

    public void setSceneProdukSeringController(ProdukSering sceneProdukSeringController) {
        this.sceneProdukSeringController = sceneProdukSeringController;
    }

    //    public HelloController getSceneTerbanyakController() {
//        return sceneTerbanyakController;
//    }
//
//    public void setSceneTerbanyakController(HelloController sceneTerbanyakController) {
//        this.sceneTerbanyakController = sceneTerbanyakController;
//    }
}
