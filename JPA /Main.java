package com.Pizzax.javafxApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = loadFXML("main.fxml");
            Scene scene = new Scene(root);
            
   
            stage.setTitle("PizzaX");
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {
            showError("Erro ao iniciar a aplicação", "Não foi possível carregar a interface gráfica.");
            e.printStackTrace();
        }
    }

    private Parent loadFXML(String fxml) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        return fxmlLoader.load();
    }


    private void showError(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
