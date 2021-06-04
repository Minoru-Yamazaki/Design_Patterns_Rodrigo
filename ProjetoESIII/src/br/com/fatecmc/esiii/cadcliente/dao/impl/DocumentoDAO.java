package br.com.fatecmc.esiii.cadcliente.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.fatecmc.esiii.cadcliente.dao.IDAO;
import br.com.fatecmc.esiii.cadcliente.dominio.Documento;
import br.com.fatecmc.esiii.cadcliente.dominio.EntidadeDominio;
import br.com.fatecmc.esiii.cadcliente.dominio.TipoDocumento;
import br.com.fatecmc.esiii.cadcliente.util.Conexao;


public class DocumentoDAO extends AbstractDAO {

	public DocumentoDAO() {
	}

	public DocumentoDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		Documento documento = (Documento) entidade;
		PreparedStatement pst = null;
		boolean ctrTransacao = false;
		try {

			if (connection == null) {
				connection = Conexao.getConnectionPostgres();
				ctrTransacao = true;
			}

			TipoDAO tipoDao = new TipoDAO(connection);

			tipoDao.salvar(documento.getTpDocumento());

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_documento(cli_id, tpdoc_id, codigo, ");
			sql.append("validade) VALUES (?,?,?,?)");

			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, documento.getPessoa().getId());
			pst.setInt(2, documento.getTpDocumento().getId());
			pst.setString(3, documento.getCodigo());
			Timestamp time = new Timestamp(documento.getValidade().getTime());
			pst.setTimestamp(4, time);
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				documento.setId(rs.getInt(1));

			if (ctrTransacao) {
				connection.commit();
			}

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				if (ctrTransacao) {
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
		PreparedStatement pst = null;

		Documento documento = (Documento) entidade;
		StringBuilder sql = new StringBuilder();

		if (documento.getCodigo() != null) {
			sql.append("SELECT tpdoc_id, codigo, validade, nome ");
			sql.append("FROM TB_DOCUMENTO, TB_TIPODOCUMENTO ");
			sql.append("where codigo=? and nome=?");
		}

		try {
			connection = Conexao.getConnectionPostgres();
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, documento.getCodigo());
			pst.setString(2, documento.getTpDocumento().getNome());

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> documentos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Documento d = new Documento();
				d.setCodigo(rs.getString("codigo"));
				d.setTpDocumento(new TipoDocumento());
				d.getTpDocumento().setNome((rs.getString("nome")));
				d.setValidade(rs.getDate("validade"));
				d.getTpDocumento().setId(rs.getInt("tpdoc_id"));

				documentos.add(d);
			}
			return documentos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
