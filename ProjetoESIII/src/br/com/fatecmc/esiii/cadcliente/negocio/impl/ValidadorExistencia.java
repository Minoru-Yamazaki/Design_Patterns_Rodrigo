package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dao.impl.ClienteDAO;
import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorExistencia implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		IDAO dao = new ClienteDAO();
		List<EntidadeDominio> clientes = dao.consultar(entidade);
		if(clientes != null && clientes.size()>0) {
			return "Cliente já cadastrado!";
		}
		return null;
	}

}
