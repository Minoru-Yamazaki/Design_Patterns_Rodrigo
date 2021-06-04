package br.com.fatecmc.esiii.cadcliente.controle;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand{
	
	public String execute(EntidadeDominio entidade) {
		
		return fachada.excluir(entidade);
	}

}
