package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa extends EntidadeDominio{


	protected List<EntidadeDominio> documentos;
	protected String nome;

	public Pessoa() {	}

	

	public Pessoa(List<EntidadeDominio> documentos) {
		this.documentos = documentos;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<EntidadeDominio> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<EntidadeDominio> documentos) {
		this.documentos = documentos;
	}

	public void addDocumento(EntidadeDominio documento) {
		if (documentos == null) {
			documentos = new ArrayList<EntidadeDominio>();
		}
		documentos.add(documento);
	}
	
	

}
