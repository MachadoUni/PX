package com.Pizzax.javafxApp;

import com.Pizzax.api.ApiService;
import com.Pizzax.api.models.Pizza;
import com.Pizzax.api.models.Bebida;
import com.Pizzax.api.models.Massa;
import com.Pizzax.api.models.Sobremesa;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {
    @FXML
    private ListView<String> pizzaListView;

    public void initialize() {
        String pizzaData = ApiService.getDataFromApi("pizzas");
        String bebidaData = ApiService.getDataFromApi("bebidas");
        String massaData = ApiService.getDataFromApi("massas");
        String sobremesaData = ApiService.getDataFromApi("sobremesas");

        // a pizza
        Pizza pizza = new Pizza();
        pizza.setNome(pizzaData);
        pizza.setPreco(20.5);
        pizzaListView.getItems().add("Pizza Portuguesa : " + pizza.getNome() + " - R$" + pizza.getPreco());

        // a bebida
        Bebida bebida = new Bebida();
        bebida.setNome("Coca-Cola");
        bebida.setPreco(7.5);
        pizzaListView.getItems().add("Bebida: " + bebida.getNome() + " - R$" + bebida.getPreco());

        // massa
        Massa massa = new Massa();
        massa.setNome("Borda de Chocolate");
        massa.setPreco(25.0);
        pizzaListView.getItems().add("Massa: " + massa.getNome() + " - R$" + massa.getPreco());

        //  sobremesa
        Sobremesa sobremesa = new Sobremesa();
        sobremesa.setNome("Petit Gateu");
        sobremesa.setPreco(15.0);
        pizzaListView.getItems().add("Sobremesa: " + sobremesa.getNome() + " - R$" + sobremesa.getPreco());
    }
}
// chamada à API  para exibição no JavaFX.
