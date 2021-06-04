package br.com.fatecmc.esiii.cadcliente.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public abstract class Tipo extends EntidadeDominio{

	protected String nome;
	protected String descricao;

		
	public Tipo() {	}
	
	protected Tipo(String descricao, String nome) {
		this.descricao = descricao;
		this.nome = nome;		
	}	
	
	
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
