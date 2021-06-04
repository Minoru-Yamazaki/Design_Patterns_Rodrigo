package br.com.fatecmc.esiii.cadcliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.Endereco;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public class EnderecoDAO extends AbstractDAO{
	
	public EnderecoDAO() {
		
	}
	
	public EnderecoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {		
		Endereco endereco = (Endereco)entidade;
		PreparedStatement pst=null;
		boolean ctrTransacao = false;
		try {
			
			if(connection == null) {
				connection = Conexao.getConnectionPostgres();	
				ctrTransacao = true;
			}		
			
			TipoDAO tipoDao = new TipoDAO(connection);	
			tipoDao.salvar(endereco.getTpEndereco());			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_endereco(cli_id, tpend_id, cidade, estado, ");
			sql.append("logradouro, numero, cep) VALUES (?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, endereco.getPessoa().getId());
			pst.setInt(2, endereco.getTpEndereco().getId());
			pst.setString(3, endereco.getCidade().getDescricao());	
			pst.setString(4, endereco.getCidade().getEstado().getDescricao());	
			pst.setString(5, endereco.getLogradouro());
			pst.setString(6, endereco.getNumero());
			pst.setString(7, endereco.getCep());
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				endereco.setId(rs.getInt(1));		
			
			if(ctrTransacao) {
				connection.commit();	
			}				
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}
		
		
		finally{
			try {
				pst.close();
				if(ctrTransacao) {
					connection.close();
				}
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
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
