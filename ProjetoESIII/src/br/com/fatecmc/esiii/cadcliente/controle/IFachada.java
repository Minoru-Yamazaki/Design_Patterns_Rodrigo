package br.com.fatecmc.esiii.cadcliente.controle;

import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public interface IFachada {

	public String cadastrar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
	
}
