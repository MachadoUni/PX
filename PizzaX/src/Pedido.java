import java.util.ArrayList;
public class Pedido{
    
    // Construtor base (não delivery)
    public Pedido(ArrayList<Produto> produtos){
        for(Produto produto : produtos){
            this.valor += produto.getValor();
        }
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
    private ArrayList<Produto> listaProdutos;
    private Endereco endereco;
    
    //	Getters
    public double getValor() {
    	return this.valor;
    }
    public ArrayList<Produto> getProdutos(){
    	return this.listaProdutos;
    }
    public Endereco getEndereco() {
    	return this.endereco;
    }
    
}