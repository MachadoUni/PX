package com.Pizzax.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    private static final String API_URL = "https://api.exemplo.com/dados";

    public static String getDataFromApi() {
        try {
        
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
          
public void initialize() {
    ApiService apiService = new ApiService();
    List<Produto> menuCompleto = apiService.getMenu();  

    for (Produto produto : menuCompleto) {
        pizzaListView.getItems().add(String.format("%s: %s - R$%.2f", 
            produto.getTipo(), produto.getNome(), produto.getPreco()));
    }
}

        }
    }
}
