package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import java.util.Date;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ComplementarDtCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		entidade.setDtCadastro(new Date());
		return null;
	}

}
