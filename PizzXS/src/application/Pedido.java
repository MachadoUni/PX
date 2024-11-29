package application;
import java.util.ArrayList;
public class Pedido{
    
    // Construtor base (não delivery)
	public Pedido(Produto p1){
        this.pizza = p1;
        this.valor = p1.getValor();
    }
	public Pedido(Produto p1, Produto p2){
        this.pizza = p1;
        this.bebida = p2;
        this.valor = p1.getValor() + p2.getValor();
    }
    
    // Construtor com endereço (para delivery)
    public Pedido(ArrayList<Produto> produtos, Endereco endereco){
        this.endereco = endereco;
        for(Produto produto : produtos){
            this.valor += produto.getValor();
        }
    }
    
    //	Variáveis
    private double valor;
    private Produto pizza;
    private Produto bebida;
    private Endereco endereco;
    
    //	Getters
    public double getValor() {
    	return this.valor;
    }
    public Produto getPizza(){
    	return this.pizza;
    }
    public Produto getBebida(){
    	return this.bebida;
    }
    public Endereco getEndereco() {
    	return this.endereco;
    }
    
}