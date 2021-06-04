package br.com.fatecmc.esiii.cadcliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dominio.Cliente;
import br.com.fatecmc.esiii.cadcliente.dominio.Documento;
import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public class ClienteDAO implements IDAO {

	@Override
	public void salvar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		
		Connection connection=null;
		PreparedStatement pst=null;			
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);				
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente(nome,credito)");
			sql.append("VALUES (?,?)");		
					
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, cliente.getNome());
			pst.setDouble(2, cliente.getCredito());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				cliente.setId(rs.getInt(1));	
			
			DocumentoDAO documentoDAO = new DocumentoDAO(connection);
			for(EntidadeDominio e : cliente.getDocumentos()) {
				Documento d = (Documento)e;
				d.setPessoa(cliente);
				documentoDAO.salvar(d);
			}
			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			for(Endereco e: cliente.getEnderecos()) {
				e.setPessoa(cliente);
				enderecoDAO.salvar(e);
			}
			
			connection.commit();		
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Cliente cliente = (Cliente)entidade;
		String query;
		
		if(entidade == null) {
			query = "SELECT * from tb_cliente";
		}else if(cliente.getDocumentos()!=null) {
			DocumentoDAO docDao = new DocumentoDAO();
			List<EntidadeDominio> documentos = new ArrayList<EntidadeDominio>();
			for(EntidadeDominio d: cliente.getDocumentos()) {
				documentos.addAll(docDao.consultar(d));
			}
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
			if(documentos.size()>0) {
				cliente.setDocumentos(documentos);
				clientes.add(cliente);
				return clientes;
			}else {
				return null;
			}
			
		}
		
		return null;
	}

}
