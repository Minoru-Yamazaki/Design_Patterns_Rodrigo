package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Endereco){
			Endereco endereco = (Endereco)entidade;
			
			String cidade = endereco.getCidade().getDescricao();
			String logradouro = endereco.getLogradouro();
			String estado = endereco.getCidade().getEstado().getDescricao();
			String nr = endereco.getNumero();
			String tpEndereco = endereco.getTpEndereco().getNome();
			
			
			if(logradouro == null || cidade == null || estado == null || nr==null){
				return "cidade, estado e nr no endereço:"+tpEndereco+"são de preenchimento obrigatório!";
			}else if(logradouro.trim().equals("") ||cidade.trim().equals("") || estado.trim().equals("") || 
					nr.trim().equals("")){
				return "cidade, estado e nr no endereço:"+tpEndereco+"são de preenchimento obrigatório!";
			}
			
		}else{
			return "Deve ser registrado um endereco!";
		}
		
		return null;
	}

}
