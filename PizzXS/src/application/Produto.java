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
    private String nome = null;
    private double valor;
    private Tipo t;
    
    //Getters
    public String getDescrição() {
    	switch(this.t) {
    	case Tipo.Pizza:
    		return ("Pizza: " + this.nome);
    	case Tipo.Bebida:
    		return ("Bebida: " + this.nome);
    	default:
    		return ("Sem descrição");
    	}
    }
    
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