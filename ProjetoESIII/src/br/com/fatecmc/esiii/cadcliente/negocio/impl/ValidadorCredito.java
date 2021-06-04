package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorCredito implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		if(cliente.getCredito()<1000) {
			return "O crédito de cliente deve ser maior que R$ 1000,00";
		}
		return null;
	}

}
