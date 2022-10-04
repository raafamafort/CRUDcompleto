package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.bo.Excecao;
import br.com.fiap.bo.PessoaBO;
import br.com.fiap.conexao.Conexao;

public class ProgramaComBO {

	public static void main(String[] args) throws Excecao {

		Connection con = Conexao.abrirConexao();

		Pessoa pessoa = new Pessoa();
		PessoaBO pessoabo = new PessoaBO();

		// Modo inserir pela BO
		pessoa.setNome("R");
		pessoa.setEndereco("R");
		pessoabo.inserirBO(pessoa);

		Conexao.fecharConexao(con);
	}
}

