package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dao.impl.ClienteDAO;
import br.com.fatecmc.esiii.cadcliente.dao.impl.DocumentoDAO;

public class TesteConsultaDoc {

	public static void main(String[] args) {
		IDAO dao = new ClienteDAO();
		
		Documento documento = new Documento();
		Cliente c = new Cliente();
		c.setId(5);
		TipoDocumento tpDocumento = new TipoDocumento();
		tpDocumento.setNome("RG");
		documento.setPessoa(c);
		documento.setTpDocumento(tpDocumento);
		documento.setCodigo("30309900/7");
	List<EntidadeDominio> docs = new ArrayList<EntidadeDominio>();
	docs.add(documento);
	c.setDocumentos(docs);
		
		List<EntidadeDominio>  clientes= dao.consultar(c);
		
		if(clientes != null) {
			Cliente cliRetornado = (Cliente)clientes.get(0);
			Documento doc = (Documento)cliRetornado.getDocumentos().get(0);
			System.out.println(doc.getCodigo());
			
		}

	}

}
