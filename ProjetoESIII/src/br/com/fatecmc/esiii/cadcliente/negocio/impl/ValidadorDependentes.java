package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Dependente;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorDependentes implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		List<Dependente> dependentes = cliente.getDependentes();
		if(dependentes != null) {
			if(dependentes.size() >2) {
				return "É permitido a vinculação com no máximo dois dependentes!";
			}
			
			ValidadorParentesco vParentesco = new ValidadorParentesco();
			StringBuilder sb = new StringBuilder();
			for(Dependente d:dependentes) {
				String msg = vParentesco.processar(d.getParentesco());
				if(msg != null) {
					sb.append(msg);
					sb.append("\n");
				}				
			}
			
			if(sb.length()>0) {
				return sb.toString();
			}
			
		}
		
		
		
		return null;
	}

}
