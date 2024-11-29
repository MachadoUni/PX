package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Produto.Tipo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML
	GridPane gridPedidos;
	
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void trocarParaPrincipal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void trocarParaAddPedidos(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AddPedido.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void AdicionarPedido(Pedido p) {
		listaPedidos.add(p);
	}
	
	public void RemoverPedido(Pedido p) {
		listaPedidos.remove(p);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AdicionarPedido(new Pedido(new Produto("Pizza", 30, Tipo.Pizza)));
		AdicionarPedido(new Pedido(new Produto("Pizza 2", 40, Tipo.Pizza)));
		int index = 0;
		for(Node node : gridPedidos.getChildren()) {
			if(index < listaPedidos.size()) {
				node.setVisible(true);
			}
			index++;
		}
		System.out.println(index);
	}

}
