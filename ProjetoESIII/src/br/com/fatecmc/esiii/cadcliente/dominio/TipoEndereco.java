package br.com.fatecmc.esiii.cadcliente.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public class TipoEndereco extends Tipo {

	public TipoEndereco() {
	
	}

	public TipoEndereco(String descricao, String nome) {
		super(descricao, nome);
	}

}
