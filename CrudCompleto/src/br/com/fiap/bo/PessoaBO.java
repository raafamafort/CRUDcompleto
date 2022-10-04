package br.com.fiap.bo;

import java.sql.Connection;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class PessoaBO {

	Connection con = Conexao.abrirConexao();

	PessoaDAO pessoadao = new PessoaDAO(con);

	public void inserirBO(Pessoa pessoa) throws Excecao {
		if ((pessoa.getNome().length() < 2) || (pessoa.getEndereco().length() < 4)) {
			System.out.println("Quantidade de caracteres " + "do nome e / ou endereço "
					+ "não atende o mínimo");
		} else {
			pessoa.setNome(pessoa.getNome().toUpperCase());
			pessoa.setEndereco(pessoa.getEndereco().toUpperCase());
			System.out.println(pessoadao.inserir(pessoa));
		}
	}
}
