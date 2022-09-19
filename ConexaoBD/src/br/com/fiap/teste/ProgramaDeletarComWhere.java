package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaDeletarComWhere {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// delete com Where
		pessoa.setNome("Rafael Mafort Coimbra");
		System.out.println(pessoadao.deletarComWhere(pessoa));
		
		Conexao.fecharConexao(con);
	}
}
