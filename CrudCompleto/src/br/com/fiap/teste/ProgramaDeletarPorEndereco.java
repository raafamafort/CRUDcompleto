package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaDeletarPorEndereco {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		
		PessoaDAO pessoadao = new PessoaDAO(con);
		
		// Deletar pelo endereco
		pessoa.setEndereco("Rua Y");
		System.out.println(pessoadao.deletarDois(pessoa));
		
		Conexao.fecharConexao(con);
	}
}
