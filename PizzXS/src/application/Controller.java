package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	@FXML
	GridPane gridPedidos;
	
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	public void setPedidos(ArrayList<Pedido> p) {
		this.listaPedidos = p;
	}
	
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPedido.fxml"));
		root = loader.load();
		ControllerAddPedido controller = loader.getController();
		
		controller.setPedidos(this.listaPedidos);
		
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
	
	public String getDescrições(int index, ArrayList<Pedido> list) {
		String s = "";
		for(Produto p : list.get(index).getLista()) {
			s += p.getDescrição() + "\n";
		}
		return s;
	}
	
	public void showPedidos() {
		ArrayList<Pedido> list = this.listaPedidos;
		int index = 0;
		for(Node node : gridPedidos.getChildren()) {
			if(index < this.listaPedidos.size()) {
				node.setVisible(true);
				for(Node n : ((AnchorPane)node).getChildren()) {
					if(n.getAccessibleRole() == AccessibleRole.TEXT) {
						((Label)n).setText(getDescrições(index, list));
					}
				}
			}
			index++;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
