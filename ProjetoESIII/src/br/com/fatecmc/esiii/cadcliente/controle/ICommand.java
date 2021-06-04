package br.com.fatecmc.esiii.cadcliente.controle;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public interface ICommand {
	public Object execute(EntidadeDominio entidade);
	
}
