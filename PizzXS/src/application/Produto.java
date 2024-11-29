package application;
public class Produto{
    
	enum Tipo {
		Pizza,
		Bebida;
	}
	
    public Produto(String nome, double valor, Tipo t){
        this.nome = nome;
        this.valor = valor;
        this.t = t;
    }
    
    //Vars
    private String nome;
    private double valor;
    private Tipo t;
    
    //Getters
    public String getNome() {
    	return this.nome;
    }
    public double getValor(){
        return this.valor;
    }
    public Tipo getTipo() {
    	return this.t;
    }
}