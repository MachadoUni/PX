public class Produto{
    
    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    
    private String nome;
    private double valor;
    
    public String getNome() {
    	return this.nome;
    }
    
    public double getValor(){
        return this.valor;
    }
}