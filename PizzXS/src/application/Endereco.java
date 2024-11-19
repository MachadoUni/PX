package application;
public class Endereco{
    
    public Endereco(String ruaAvenida, String bairro, int numero){
        this.bairro = bairro;
        this.ruaAvenida = ruaAvenida;
        this.numero = numero;
    }
    
    private String ruaAvenida;
    private String bairro;
    private int numero;
    
    public String getRuaAvenida() {
    	return this.ruaAvenida;
    }
    public String getBairro() {
    	return this.bairro;
    }
    public int getNumero() {
    	return this.numero;
    }
}