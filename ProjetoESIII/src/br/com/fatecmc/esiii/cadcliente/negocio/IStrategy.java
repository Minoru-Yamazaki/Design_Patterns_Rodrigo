package br.com.fatecmc.esiii.cadcliente.negocio;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public interface IStrategy {
	
	public String processar(EntidadeDominio entidade);

}
