package br.com.fatecmc.esiii.cadcliente.dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public class Documento extends EntidadeDominio{

	private String codigo;
	private Date validade;
	private TipoDocumento tpDocumento;
	private Pessoa pessoa;
	
	public Documento() {}
	
	public Documento(String codigo, Date validade, TipoDocumento tpDocumento) {
		this.codigo = codigo;
		this.validade = validade;
		this.tpDocumento = tpDocumento;
	}
	
	public TipoDocumento getTpDocumento() {
		return tpDocumento;
	}
	public void setTpDocumento(TipoDocumento tpDocumento) {
		this.tpDocumento = tpDocumento;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
