package application;
import java.util.ArrayList;

//import application.Produto.Tipo;
public class Pedido{
    
    // Construtor base (não delivery)
	public Pedido(Produto p1){
		produtos.add(p1);
        this.valor = p1.getValor();
    }
	public Pedido(Produto p1, Produto p2){
        produtos.add(p1);
        produtos.add(p2);
        this.valor = p1.getValor() + p2.getValor();
    }
    
    //	Variáveis
    private double valor;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Produto pizza = null;
    private Produto bebida = null;
    
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
    public ArrayList<Produto> getLista(){
    	return this.produtos;
    }
    
}