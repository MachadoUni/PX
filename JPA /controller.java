package com.Pizzax.javafxApp;
import com.Pizzax.api.ApiService;
import com.Pizzax.api.models.Pizza;
import com.Pizzax.api.models.Bebida;
import com.Pizzax.api.models.Massa;
import com.Pizzax.api.models.Sobremesa;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ListView<String> pizzaListView;

    public void initialize() {
        // Lista para armazenar os produtos
        List<Produto> menuCompleto = new ArrayList<>();

        // pizzas
        Produto pizza1 = new Produto();
        pizza1.setNome("Pepperoni");
        pizza1.setPreco(59.90);
        pizza1.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza1);

        Produto pizza2 = new Produto();
        pizza2.setNome("Mussarela");
        pizza2.setPreco(64.90);
        pizza2.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza2);

        Produto pizza3 = new Produto();
        pizza3.setNome("Calabresa");
        pizza3.setPreco(56.90);
        pizza3.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza3);

        Produto pizza4 = new Produto();
        pizza4.setNome("Frango com Catupiry");
        pizza4.setPreco(67.90);
        pizza4.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza4);

        Produto pizza5 = new Produto();
        pizza5.setNome("Portuguesa");
        pizza5.setPreco(69.90);
        pizza5.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza5);

        Produto pizza6 = new Produto();
        pizza6.setNome("Champignon");
        pizza6.setPreco(59.90);
        pizza6.setTipo(Tipo.Pizza);
        menuCompleto.add(pizza6);

        //  bebidas
        Produto bebida1 = new Produto();
        bebida1.setNome("Água");
        bebida1.setPreco(3.50);
        bebida1.setTipo(Tipo.Bebida);
        menuCompleto.add(bebida1);

        Produto bebida2 = new Produto();
        bebida2.setNome("Guaraná Lata");
        bebida2.setPreco(6.25);
        bebida2.setTipo(Tipo.Bebida);
        menuCompleto.add(bebida2);

        Produto bebida3 = new Produto();
        bebida3.setNome("Coca Lata");
        bebida3.setPreco(7.00);
        bebida3.setTipo(Tipo.Bebida);
        menuCompleto.add(bebida3);

        Produto bebida4 = new Produto();
        bebida4.setNome("Garrafa de Vinho");
        bebida4.setPreco(34.90);
        bebida4.setTipo(Tipo.Bebida);
        menuCompleto.add(bebida4);

        Produto bebida5 = new Produto();
        bebida5.setNome("Cerveja Lata");
        bebida5.setPreco(9.90);
        bebida5.setTipo(Tipo.Bebida);
        menuCompleto.add(bebida5);

        //  massas
        Produto massa1 = new Produto();
        massa1.setNome("Borda de Chocolate");
        massa1.setPreco(25.00);
        massa1.setTipo(Tipo.Massa);
        menuCompleto.add(massa1);

        Produto massa2 = new Produto();
        massa2.setNome("Massa Fina");
        massa2.setPreco(15.00);
        massa2.setTipo(Tipo.Massa);
        menuCompleto.add(massa2);

        Produto massa3 = new Produto();
        massa3.setNome("Massa Pan");
        massa3.setPreco(18.00);
        massa3.setTipo(Tipo.Massa);
        menuCompleto.add(massa3);

      
        for (Produto produto : menuCompleto) {
            pizzaListView.getItems().add(produto.getTipo() + ": " + produto.getNome() + " - R$" + produto.getPreco());
        }
    }
}
