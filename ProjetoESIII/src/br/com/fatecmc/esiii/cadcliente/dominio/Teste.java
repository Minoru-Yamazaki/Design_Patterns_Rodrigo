package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.impl.ClienteDAO;

public class Teste {

	public static void main(String[] args) {
		//MSG: 1.1
		Estado sp = new Estado("SP");
		//MSG: 1.2
		Cidade mogi = new Cidade("Mogi das Cruzes", sp);
		//MSG: 1.3
		TipoEndereco tpEndEntrega = new TipoEndereco("Endereço entrega ", 
				"Entrega");	
		
		//MSG: 1.4
		Endereco av7setembro = new Endereco("Av 7 de setembro", "200", "08790000", null, mogi, tpEndEntrega);
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(av7setembro);		
			
		//MSG: 1.5
		TipoDocumento tpDocRg = new TipoDocumento();
		//MSG: 1.6
		tpDocRg.setDescricao("PASSAPORTE");
		//MSG: 1.7
		tpDocRg.setNome("PASSAPORTE");		
		//MSG: 1.8
		Documento rg = new Documento("xxxxxxxx/x", new Date(), tpDocRg);
		
		List<EntidadeDominio> documentos = new ArrayList<EntidadeDominio>();
		documentos.add(rg);	
		//MSG: 1.9
		TipoCliente tpClienteVip = new TipoCliente("Cliente que gasta bem!", "VIP");
		//MSG: 1.10
		Cliente maria = new Cliente(documentos, tpClienteVip, enderecos, "MARIA JOSÉ");
		//MSG: 1.11		
		TipoDocumento tpDocCpf = new TipoDocumento("HABILITACAO", "CNH");
		//MSG: 1.12
		Documento cpf = new Documento("098765432", new Date(), tpDocCpf);
		//MSG: 1.13
		maria.addDocumento(cpf);
		//MSG: 1.14
		TipoEndereco tpEndCobranca = new TipoEndereco("END DE COBRANCA", "Cobrança");
		maria.setCredito(1200);
		String avGet = "Av Getulio Vargas";
		String n1500 = "1500";
		String cepGet = "08791000";		
		//MSG: 1.15
		Endereco endGet = new Endereco(avGet, n1500, cepGet, null, mogi, tpEndCobranca);
		//MSG: 1.16
		maria.addEndereco(endGet);
		//MSG: 1.17
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(maria);

	}

}
