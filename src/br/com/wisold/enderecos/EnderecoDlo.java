package br.com.wisold.enderecos;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.industrias.Industria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoDlo {
	@Autowired
	private EnderecoDao dao;

	public void manterEndereco(Endereco endereco) {
		if (endereco.getId() == null) {
			this.dao.inserir(endereco);
		} else {
			this.dao.alterar(endereco);
		}
	}

	public Endereco buscarPorId(Long id, Cliente cliente) {
		Endereco endereco = this.dao.buscaPorId(id);
		if (validarDados(cliente, endereco)) {
			return endereco;
		}
		return null;
	}

	public Endereco buscarPorId(Long id, Industria industria) {
		Endereco endereco = this.dao.buscaPorId(id);
		if (validarDados(industria, endereco)) {
			return endereco;
		}
		return null;
	}

	public boolean excluir(Long id, Cliente cliente) {
		Endereco endereco = this.dao.buscaPorId(id);
		if (validarDados(cliente, endereco)) {
			this.dao.excluir(endereco);
			return true;
		}
		return false;
	}

	public boolean excluir(Long id, Industria industria) {
		Endereco endereco = this.dao.buscaPorId(id);
		if (validarDados(industria, endereco)) {
			this.dao.excluir(endereco);
			return true;
		}
		return false;
	}

	public boolean validarDados(Cliente cliente, Endereco endereco) {
		if (endereco.getCliente().getId() == cliente.getId()) {
			return true;
		}
		return false;
	}

	public boolean validarDados(Industria industria, Endereco endereco) {
		if (endereco.getIndustria().getId() == industria.getId()) {
			return true;
		}
		return false;
	}
}
