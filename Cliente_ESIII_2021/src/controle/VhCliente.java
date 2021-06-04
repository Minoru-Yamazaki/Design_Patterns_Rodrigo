package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.cadcliente.dominio.Cidade;
import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Dependente;
import br.com.fatecmc.esiii.cadcliente.dominio.Documento;
import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.dominio.Estado;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoCliente;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoDocumento;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoEndereco;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoParentesco;

public class VhCliente implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String txtEstado = request.getParameter("txtEstado");
		String txtCidade = request.getParameter("txtCidade");
		String txtTpEnd = request.getParameter("txtTend");
		String txtLogradouro = request.getParameter("txtLogradouro");
		String txtNumero = request.getParameter("txtNumero");
		String txtCep = request.getParameter("txtCep");
		String txtTpCliente = request.getParameter("txtTpCliente");
		String txtCredito = request.getParameter("txtCredito");
		String txtNome = request.getParameter("txtCliente");
		String txtTpDocumento = request.getParameter("txtTpDoc");
		String txtCPF = request.getParameter("txtCPF");
		String txtDep1 = request.getParameter("txtDep1");
		String txtDep2 = request.getParameter("txtDep2");
		String txtParentesco1 = request.getParameter("txtParentesco1");
		String txtParentesco2 = request.getParameter("txtParentesco2");

		Estado estado = new Estado(txtEstado);
		Cidade cidade = new Cidade(txtCidade, estado);
		TipoEndereco tpEndereco = new TipoEndereco(txtTpEnd, txtTpEnd);

		Endereco end = new Endereco(txtLogradouro, txtNumero, txtCep, null, cidade, tpEndereco);

		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(end);
		List<EntidadeDominio> documentos = new ArrayList<EntidadeDominio>();

		TipoCliente tpCliente = new TipoCliente(txtTpCliente, txtTpCliente);

		TipoParentesco par1 = new TipoParentesco(Integer.parseInt(txtParentesco1));
		TipoParentesco par2 = new TipoParentesco(Integer.parseInt(txtParentesco2));

		Dependente dep1 = new Dependente(txtDep1, par1);
		Dependente dep2 = new Dependente(txtDep2, par2);

		Cliente cliente = new Cliente(documentos, tpCliente, enderecos, txtNome);
		cliente.setCredito(Double.parseDouble(txtCredito));

		TipoDocumento tpDocumento = new TipoDocumento(txtTpDocumento, txtTpDocumento);

		Documento doc = new Documento(txtCPF, new Date(), tpDocumento);

		cliente.addDocumento(doc);
		cliente.addDependente(dep1);
		cliente.addDependente(dep2);
		return cliente;
	}

	@Override
	public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		PrintWriter out;
		try {
			out = response.getWriter();
			if (resultado != null) {
				out.println(resultado);
			} else {
				out.println("<h1>Cliente cadastrado!</h1>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
