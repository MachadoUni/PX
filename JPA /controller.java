package com.Pizzax.javafxApp;
import com.Pizzax.api.ApiService;
import com.Pizzax.api.models.Pizza;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Controller {
    @FXML
    private ListView<String> pizzaListView;

    public void initialize() {
        String data = ApiService.getDataFromApi("pizzas");
      
        Pizza pizza = new Pizza();
        pizza.setNome(data);
        pizza.setPreco(20.5);
        pizzaListView.getItems().add(pizza.getNome());
    }
}
// chamada à API  para exibição no JavaFX.
