package br.com.fatecmc.esiii.cadcliente.dao.impl;

import java.sql.Connection;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;

public abstract class AbstractDAO implements IDAO {

	protected Connection connection;

}
