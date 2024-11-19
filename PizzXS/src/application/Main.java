package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("PizSystem - by ByteX");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
