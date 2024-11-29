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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ControllerAddPedido implements Initializable{

	@FXML
	private ChoiceBox<String> caixaEscolhaPizza;
	@FXML
	private ChoiceBox<String> caixaEscolhaBebida;
	@FXML
	private Label labelValor;
	
	private ArrayList<Produto> menuCompleto = new ArrayList<Produto>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		EncherLista();
		String[] a = listaStringPizzas(menuCompleto);
		String[] b = listaStringBebidas(menuCompleto);
		caixaEscolhaPizza.getItems().addAll(a);
		caixaEscolhaBebida.getItems().addAll(b);
		caixaEscolhaPizza.setOnAction(this::setPreco);
		caixaEscolhaBebida.setOnAction(this::setPreco);
	}
	
	public void setPreco(ActionEvent event) {
		String pizza = caixaEscolhaPizza.getValue();
		String bebida = caixaEscolhaBebida.getValue();
		double p = 0, b = 0;
		for(int i = 0; i < menuCompleto.size(); i++) {
			if(pizza == menuCompleto.get(i).getNome())
				p = menuCompleto.get(i).getValor();
		}
		for(int i = 0; i < menuCompleto.size(); i++) {
			if(bebida == menuCompleto.get(i).getNome())
				b = menuCompleto.get(i).getValor();
		}
		
		labelValor.setText("Valor: R$" + (p+b));
	}
	
	public void EncherLista() {
		menuCompleto.add(new Produto("Pizza 1", 40, Tipo.Pizza));
		menuCompleto.add(new Produto("Pizza 2", 30, Tipo.Pizza));
		menuCompleto.add(new Produto("Pizza 3", 70, Tipo.Pizza));
		menuCompleto.add(new Produto("Água", 3.50, Tipo.Bebida));
	}
	
	public String[] listaStringPizzas(ArrayList<Produto> listaProdutos) {
		int s = 0;
		for(int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getTipo() == Tipo.Pizza)
				s++;
		}
		String[] listaStrings = new String[s];
		int index = 0;
		for(int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getTipo() == Tipo.Pizza) {
				listaStrings[index] = listaProdutos.get(i).getNome();
				index++;
			}
		}
		return listaStrings;
	}
	
	public String[] listaStringBebidas(ArrayList<Produto> listaProdutos) {
		int s = 0;
		for(int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getTipo() == Tipo.Bebida)
				s++;
		}
		String[] listaStrings = new String[s];
		int index = 0;
		for(int i = 0; i < listaProdutos.size(); i++) {
			if(listaProdutos.get(i).getTipo() == Tipo.Bebida) {
				listaStrings[index] = listaProdutos.get(i).getNome();
				index++;
			}
		}
		return listaStrings;
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
	
	// private void AddPedido(Pedido pedido){}
	
}
