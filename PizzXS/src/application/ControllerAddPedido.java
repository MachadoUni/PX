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
	
	
	private ArrayList<Pedido> listaPedidos;
	public void setPedidos(ArrayList<Pedido> p) {
		this.listaPedidos = p;
	}
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
		menuCompleto.add(new Produto("Pepperoni", 60, Tipo.Pizza));
		menuCompleto.add(new Produto("Calabresa", 50, Tipo.Pizza));
		menuCompleto.add(new Produto("Queijo e Orégano", 40, Tipo.Pizza));
		menuCompleto.add(new Produto("Frango", 70, Tipo.Pizza));
		menuCompleto.add(new Produto("Água", 3.50, Tipo.Bebida));
		menuCompleto.add(new Produto("Guaraná Lata", 6.25, Tipo.Bebida));
		menuCompleto.add(new Produto("Coca Lata", 7.00, Tipo.Bebida));
		menuCompleto.add(new Produto("Garrafa de Vinho", 34.90, Tipo.Bebida));
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
	
	// Vars para trocar de cena
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// Função para voltar a tela principal adicionando o pedido
	public void trocarParaPrincipal(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		root = loader.load();
		Controller controller = loader.getController();
		
		controller.setPedidos(LerAddPedidos());
		controller.showPedidos();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void cancelarParaPrincipal(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		root = loader.load();
		Controller controller = loader.getController();
		
		controller.setPedidos(this.listaPedidos);
		controller.showPedidos();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public ArrayList<Pedido> LerAddPedidos() {
		ArrayList<Pedido> ps = this.listaPedidos;
		Produto p1 = null;
		Produto p2 = null;
		for(Produto p : menuCompleto) {
			if (caixaEscolhaPizza.getValue() == p.getNome()) {
				p1 = p;
			}
			if (caixaEscolhaBebida.getValue() == p.getNome()) {
				p2 = p;
			}
		}
		if(p1 != null && p2!= null) {
			ps.add(new Pedido(p1, p2));
		}else if(p1 != null){
			ps.add(new Pedido(p1));
		}else if(p2 != null){
			ps.add(new Pedido(p2));
		}
		return ps;
	}
	
	// private void AddPedido(Pedido pedido){}
	
}
