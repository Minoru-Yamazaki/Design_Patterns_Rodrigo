package br.com.fatecmc.esiii.cadcliente.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.impl.ClienteDAO;

public class TesteSalvar {

	public static void main(String[] args) {

		TipoDocumento tpDocRg = new TipoDocumento();

		tpDocRg.setDescricao("REGISTRO GERAL");

		tpDocRg.setNome("RG");

		Documento rg = new Documento("30309900/7", new Date(), tpDocRg);

		List<EntidadeDominio> documentos = new ArrayList<EntidadeDominio>();
		documentos.add(rg);

		TipoCliente tpClienteVip = new TipoCliente("Cliente que gasta bem!", "VIP");

		Cliente maria = new Cliente(documentos, tpClienteVip, null, "MARIA DO CARMO");

		TipoDocumento tpDocCpf = new TipoDocumento("CADASTRO DE PESSOA FISICA", "CPF");

		Documento cpf = new Documento("29889790090", new Date(), tpDocCpf);

		maria.addDocumento(cpf);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(maria);

	}

}
