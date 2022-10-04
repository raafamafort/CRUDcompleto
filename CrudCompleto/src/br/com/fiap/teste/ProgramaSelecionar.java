package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaDAO;

public class ProgramaSelecionar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		PessoaDAO pessoadao = new PessoaDAO(con);

		// Selecionar
		ArrayList<Pessoa> lista = pessoadao.retornarDados();

		if (lista != null) {
			for (Pessoa p : lista) {
				System.out.println("Nome: " + p.getNome());
				System.out.println("Endereço: " + p.getEndereco() + "\n");
			}
		}

		Conexao.fecharConexao(con);
	}

}
