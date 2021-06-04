package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorDadosObrigatoriosCliente implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Cliente){
			Cliente cliente = (Cliente)entidade;
			
			String nome = cliente.getNome();
			double credito = cliente.getCredito();
		
			StringBuilder sb = new StringBuilder();
			if(nome == null || credito == 00){
				sb.append("Nome, e Crédito são de preenchimento obrigatório!");
			}else if(nome.trim().equals("")){
				sb.append("Nome e crédito são de preenchimento obrigatório!");
			}
			
			for(Endereco e:cliente.getEnderecos()) {
				ValidadorEndereco vEnd = new ValidadorEndereco();
				String msgEnd = vEnd.processar(e);
				if(msgEnd != null) {
					sb.append(msgEnd);				
				}
			}			
			
			if(sb.length()>0) {
				return sb.toString();
			}else {
				return null;
			}
			
		}else{
			return "Deve ser registrado um cliente!";
		}
		
		
		
	}

}
