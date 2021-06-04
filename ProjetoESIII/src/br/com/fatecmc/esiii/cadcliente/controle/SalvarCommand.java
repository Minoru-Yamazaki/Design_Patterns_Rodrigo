package br.com.fatecmc.esiii.cadcliente.controle;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public class SalvarCommand extends AbstractCommand{
	
	public String execute(EntidadeDominio entidade) {		
		return fachada.cadastrar(entidade);
	}

}
