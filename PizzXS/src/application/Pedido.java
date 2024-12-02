package application;
import java.util.ArrayList;

public class Pedido{
    
    // Construtor base 
	public Pedido(Produto p1){
		produtos.add(p1);
        this.valor = p1.getValor();
    }
	//	Construtor com dois produtos
	public Pedido(Produto p1, Produto p2){
        produtos.add(p1);
        produtos.add(p2);
        this.valor = p1.getValor() + p2.getValor();
    }
    
    //	Variáveis
    private double valor;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    //	Getters
    public double getValor() {
    	return this.valor;
    }
    public ArrayList<Produto> getLista(){
    	return this.produtos;
    }
    
}