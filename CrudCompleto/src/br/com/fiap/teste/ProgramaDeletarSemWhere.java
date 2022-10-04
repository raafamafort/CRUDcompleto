package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaDeletarSemWhere {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// delete sem Where ( deleta tudo )
		System.out.println(pessoadao.deletarSemWhere(pessoa));
		
		Conexao.fecharConexao(con);
	}
}