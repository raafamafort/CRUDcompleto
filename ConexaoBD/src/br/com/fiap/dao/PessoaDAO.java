package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Pessoa;

public class PessoaDAO {
	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}
	
	public PessoaDAO(Connection con) {
		setCon(con);
	}
	
	// Inserir
	public String inserir(Pessoa pessoa) {
		String sql = "insert into pessoa(nome, endereco) values (?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			}	else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Deletar com Where
	public String deletarComWhere(Pessoa pessoa) {
		String sql = "delete from pessoa where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			if(ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e){
			return e.getMessage();
		}
	}
	
	
	// Deletar sem Where
	public String deletarSemWhere(Pessoa pessoa) {
		String sql = "delete from pessoa";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			if(ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e){
			return e.getMessage();
		}
	}
	
	// Alterar endreco por nome
	public String alterar(Pessoa pessoa) {
        String sql = "update pessoa set endereco = ? where nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, pessoa.getEndereco());
            ps.setString(2, pessoa.getNome());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
	
	// Select
	
	public ArrayList<Pessoa> retornarDados(){
		String sql = "select * from pessoa";
		ArrayList<Pessoa> retornarPessoa = new ArrayList<Pessoa>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if ( rs != null ) {
				while (rs.next()) {
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(rs.getString(1));
					pessoa.setEndereco(rs.getString(2));
					retornarPessoa.add(pessoa);
				}
				return retornarPessoa;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
}
