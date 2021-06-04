package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.List;


public class Cliente extends Pessoa{

	private TipoCliente tpCliente;
	private List<Endereco> enderecos;
	private List<Dependente> dependentes;
	
	private double credito;
	
	public Cliente () {}
	
	public Cliente (List<EntidadeDominio> documentos, TipoCliente tpCliente, 
			List<Endereco> enderecos, String nome) {
		
		super(documentos);		
		this.tpCliente = tpCliente;
		this.enderecos = enderecos;
		this.nome = nome;

	}

	public TipoCliente getTpCliente() {
		return tpCliente;
	}
	
	

	public void setTpCliente(TipoCliente tpCliente) {
		this.tpCliente = tpCliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public void addEndereco(Endereco endereco) {
		if(enderecos == null) {
			enderecos = new ArrayList<Endereco>();
		}
		enderecos.add(endereco);
	}	
	
	public void addDependente(Dependente dependente) {
		if(dependentes == null) {
			dependentes = new ArrayList<Dependente>();
		}
		dependentes.add(dependente);
	}	

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	
	public String getCpf() {
		for(EntidadeDominio e:documentos) {
			Documento d = (Documento)e;
			if(d.getTpDocumento().getNome().equals("CPF")) {
				return d.getCodigo();
			}
		}
		return null;
	}
	
	
}
