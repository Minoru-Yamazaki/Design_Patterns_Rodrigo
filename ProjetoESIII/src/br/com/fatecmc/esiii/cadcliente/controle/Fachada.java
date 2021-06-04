package br.com.fatecmc.esiii.cadcliente.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dao.impl.ClienteDAO;
import br.com.fatecmc.esiii.cadcliente.dao.impl.EnderecoDAO;
import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.negocio.IStrategy;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ComplementarDtCadastro;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ValidadorCpf;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ValidadorCredito;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ValidadorDadosObrigatoriosCliente;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ValidadorDependentes;
import br.com.fatecmc.esiii.cadcliente.negocio.impl.ValidadorExistencia;



public class Fachada implements IFachada {
	private Map<String, IDAO> daos;
	private Map<String, List<IStrategy>> rns;

	public Fachada() {
		definirDAOS();
		definirRNS();
	}

	private void definirRNS() {
		rns = new HashMap<String, List<IStrategy>>();

		ValidadorDadosObrigatoriosCliente vCiente = new ValidadorDadosObrigatoriosCliente();
		ValidadorCpf vCpf = new ValidadorCpf();
		ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
		ValidadorCredito vCredito = new ValidadorCredito();
		ValidadorDependentes vDependnetes = new ValidadorDependentes();
		ValidadorExistencia vExistencia = new ValidadorExistencia();

		List<IStrategy> rnsCliente = new ArrayList<IStrategy>();
		rnsCliente.add(vCiente);
		rnsCliente.add(vCpf);		
		rnsCliente.add(vCredito);
		rnsCliente.add(vDependnetes);
		rnsCliente.add(vExistencia);
		rnsCliente.add(cDtCadastro);
		rns.put(Cliente.class.getName(), rnsCliente);
		
		/*	List<IStrategy> rnsFornecedor = new ArrayList<IStrategy>();
		rnsFornecedor.add(vCpf);
		rnsFornecedor.add(cDtCadastro);*/
	//	rns.put(Fornecedor.class.getName(), rnsFornecedor);
	}

	private void definirDAOS() {
		daos = new HashMap<String, IDAO>();
		daos.put(Cliente.class.getName(), new ClienteDAO());		
		//daos.put(Produto.class.getName(), new ProdutoDAO());
		//daos.put(Fornecedor.class.getName(), new FornecedorDAO());
	}

	@Override
	public String cadastrar(EntidadeDominio entidade) {
		String msg = executarRegras(entidade);
		String nmClasse = entidade.getClass().getName();
		if (msg == null) {
			IDAO dao = daos.get(nmClasse);
			dao.salvar(entidade);
		} else {
			return msg;
		}
		return null;
	}

	private String executarRegras(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();

		List<IStrategy> regras = rns.get(nmClasse);

		if (regras != null) {
			for (IStrategy s : regras) {
				String m = s.processar(entidade);

				if (m != null) {
					msg.append(m);
					msg.append("\n");
				}
			}
		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
