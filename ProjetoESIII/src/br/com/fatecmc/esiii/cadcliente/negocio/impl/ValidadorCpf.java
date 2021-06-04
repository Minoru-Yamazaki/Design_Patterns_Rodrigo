package br.com.fatecmc.esiii.cadcliente.negocio.impl;

import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Documento;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;

public class ValidadorCpf implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		boolean hasCPF = false;
		if (entidade instanceof Cliente) {
			Cliente c = (Cliente) entidade;

			if (c.getDocumentos() != null) {
				for (EntidadeDominio e : c.getDocumentos()) {
					Documento d = (Documento)e;
					if (d.getTpDocumento().getNome().equals("CPF")) {	
						hasCPF = true;
						if (d.getCodigo() == null || d.getCodigo().length() < 11) {							
							return "CPF deve conter 11 digitos!";
						}

					}
				}	
				if(!hasCPF)
					return "CPF é obrigatório!";
			}else {
				return "CPF é obrigatório!";
			}
			
			
		} 

		return null;
	}

}
