package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaAlterarPorEndereco {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();	
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// alterar nome por endereco
		pessoa.setEndereco("Rua Y");
		pessoa.setNome("Rafael Mafort Coimbra");
		System.out.println(pessoadao.alterarDois(pessoa));
		
		Conexao.fecharConexao(con);
	}
}
