package br.com.fatecmc.esiii.cadcliente.dao;

import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public interface IDAO {
	
	public void salvar(EntidadeDominio entidade);
	public void alterar(EntidadeDominio entidade);
	public void excluir(EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);

}
