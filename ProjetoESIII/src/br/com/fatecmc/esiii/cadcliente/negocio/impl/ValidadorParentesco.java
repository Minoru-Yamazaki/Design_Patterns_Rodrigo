package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoParentesco;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorParentesco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		TipoParentesco parentesco = (TipoParentesco)entidade;
		if(parentesco.getId()!=1 && parentesco.getId()!=2){            
            return "Parentesco do Dependente é inválido!";
  
        }    
		return null;
	}

}
