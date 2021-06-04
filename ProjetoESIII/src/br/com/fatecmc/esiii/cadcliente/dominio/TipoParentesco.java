package br.com.fatecmc.esiii.cadcliente.dominio;

public class TipoParentesco extends Tipo{
	
	
	public TipoParentesco() {
		
	}
	
	public TipoParentesco(String descricao, String nome) {
		super(descricao, nome);
	}
	
	public TipoParentesco(int id) {
		this.id = id;
	}
	
	

}
