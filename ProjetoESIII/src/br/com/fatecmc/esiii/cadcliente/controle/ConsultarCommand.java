package br.com.fatecmc.esiii.cadcliente.controle;

import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;



public class ConsultarCommand extends AbstractCommand{
	
	public List<EntidadeDominio> execute(EntidadeDominio entidade) {
		
		return fachada.consultar(entidade);
	}

}
