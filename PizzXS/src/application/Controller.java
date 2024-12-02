package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller{
	
	@FXML
	GridPane gridPedidos;
	
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	public void setPedidos(ArrayList<Pedido> p) {
		this.listaPedidos = p;
	}
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
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
	
	public void RemoverPedido(ActionEvent event) {
		listaPedidos.removeFirst();
		showPedidos();
	}
	
	public String getDescrições(int index, ArrayList<Pedido> list) {
		String s = "";
		for(Produto p : list.get(index).getLista()) {
			s += p.getDescrição() + "\n";
		}
		return s;
	}
	
	public void showPedidos() {
		for(Node node : gridPedidos.getChildren()) {
			if(node.getAccessibleRole() == AccessibleRole.PARENT)
				node.setVisible(false);
		}
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
}
