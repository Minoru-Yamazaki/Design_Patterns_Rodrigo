package br.com.fatecmc.esiii.cadcliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.dominio.Tipo;
import br.com.fatecmc.esiii.cadcliente.util.Conexao;

public class TipoDAO extends AbstractDAO {
	
	public TipoDAO() {}
	
	public TipoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		Tipo tipo = (Tipo)entidade;
		PreparedStatement pst=null;		
		boolean ctrTransacao = false;
		try {
			String nmClass = entidade.getClass().getSimpleName().toLowerCase();
			if(connection == null) {
				connection = Conexao.getConnectionPostgres();	
				ctrTransacao = true;
			}			
			connection.setAutoCommit(false);						
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("tb_");
			sql.append(nmClass);
			sql.append("(nome, descricao) ");
			sql.append("VALUES (?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, tipo.getNome());
			pst.setString(2, tipo.getDescricao());
			
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				tipo.setId(rs.getInt(1));		
			
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
		}finally{
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
