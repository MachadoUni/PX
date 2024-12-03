package com.Pizzax.javafxApp;
import com.Pizzax.api.ApiService;
import com.Pizzax.api.models.Pizza;
import com.Pizzax.api.models.Bebida;
import com.Pizzax.api.models.Massa;
import com.Pizzax.api.models.Sobremesa;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ListView<String> pizzaListView;

    public void initialize() {

        List<Produto> menuCompleto = new ArrayList<>();

        addPizza(menuCompleto);
        addBebida(menuCompleto);
        addMassa(menuCompleto);

   
        for (Produto produto : menuCompleto) {
            pizzaListView.getItems().add(String.format("%s: %s - R$%.2f", 
                produto.getTipo(), produto.getNome(), produto.getPreco()));
        }
    }

    private void addPizza(List<Produto> menuCompleto) {
        menuCompleto.add(new Produto("Pepperoni", 59.90, Tipo.Pizza));
        menuCompleto.add(new Produto("Mussarela", 64.90, Tipo.Pizza));
        menuCompleto.add(new Produto("Calabresa", 56.90, Tipo.Pizza));
        menuCompleto.add(new Produto("Frango com Catupiry", 67.90, Tipo.Pizza));
        menuCompleto.add(new Produto("Portuguesa", 69.90, Tipo.Pizza));
        menuCompleto.add(new Produto("Champignon", 59.90, Tipo.Pizza));
    }

    private void addBebida(List<Produto> menuCompleto) {
        menuCompleto.add(new Produto("Água", 3.50, Tipo.Bebida));
        menuCompleto.add(new Produto("Guaraná Lata", 6.25, Tipo.Bebida));
        menuCompleto.add(new Produto("Coca Lata", 7.00, Tipo.Bebida));
        menuCompleto.add(new Produto("Garrafa de Vinho", 34.90, Tipo.Bebida));
        menuCompleto.add(new Produto("Cerveja Lata", 9.90, Tipo.Bebida));
    }

    private void addMassa(List<Produto> menuCompleto) {
        menuCompleto.add(new Produto("Borda de Chocolate", 25.00, Tipo.Massa));
        menuCompleto.add(new Produto("Massa Fina", 15.00, Tipo.Massa));
        menuCompleto.add(new Produto("Massa Pan", 18.00, Tipo.Massa));
    }
}
