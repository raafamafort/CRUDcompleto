package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaAlterarPorNome {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();	
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// alterar endereco por nome
		pessoa.setNome("Rafael Mafort");
		pessoa.setEndereco("Rua Y");
		System.out.println(pessoadao.alterar(pessoa));
		
		Conexao.fecharConexao(con);
	}
}
