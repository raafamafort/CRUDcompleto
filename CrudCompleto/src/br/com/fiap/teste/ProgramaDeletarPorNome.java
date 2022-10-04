package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaDeletarPorNome {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// Deletar por nome
		pessoa.setNome("Rafael Mafort Coimbra");
		System.out.println(pessoadao.deletar(pessoa));
		
		Conexao.fecharConexao(con);
	}
}
