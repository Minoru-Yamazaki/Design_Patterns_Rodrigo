package controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatecmc.esiii.cadcliente.controle.AlterarCommand;
import br.com.fatecmc.esiii.cadcliente.controle.ConsultarCommand;
import br.com.fatecmc.esiii.cadcliente.controle.ExcluirCommand;
import br.com.fatecmc.esiii.cadcliente.controle.ICommand;
import br.com.fatecmc.esiii.cadcliente.controle.SalvarCommand;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;


/**
 * Servlet implementation class CtrlCliente
 */
public class CtrlCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String operacao = null;
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CtrlCliente() {
		super();
		commands = new HashMap<String, ICommand>();
		commands.put("SALVAR", new SalvarCommand());
		commands.put("EXCLUIR", new ExcluirCommand());
		commands.put("CONSULTAR", new ConsultarCommand());
		commands.put("ALTERAR", new AlterarCommand());

		/*
		 * Utilizando o ViewHelper para tratar especificações de qualquer tela e
		 * indexando cada viewhelper pela url em que esta servlet é chamada no form
		 * garantimos que esta servelt atenderá qualquer entidade
		 */

		vhs = new HashMap<String, IViewHelper>();
		/*
		 * A chave do mapa é o mapeamento da servlet para cada form que está configurado
		 * no web.xml e sendo utilizada no action do html
		 */
		vhs.put("/Cliente_ESIII_2021/SalvarCliente", new VhCliente());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtêm a operação executada
		operacao = request.getParameter("operacao");

		// Obtêm a uri que invocou esta servlet (O que foi definido no methdo do form
		// html)
		String uri = request.getRequestURI();

		IViewHelper vh = vhs.get(uri);
		EntidadeDominio entidade = vh.getEntidade(request);

		ICommand cmd = commands.get(operacao);

		Object msg = cmd.execute(entidade);

		vh.setView(msg, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
