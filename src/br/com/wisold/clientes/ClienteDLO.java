package br.com.wisold.clientes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wisold.persitencia.AbstractDLO;
import br.com.wisold.usuarios.Usuario;

@Repository
public class ClienteDLO implements AbstractDLO<Cliente>{
	@Autowired
	private ClienteDAO dao;

	@Override
	public List<Cliente> listar(Usuario usuario) {
		List<Cliente> retorno = new ArrayList();

		retorno = this.dao.listar(usuario);

		return retorno;
	}

	@Override
	public void manter(Cliente cliente) {
		if (cliente.getId() == null) {
			this.dao.inserir(cliente);
		} else {
			this.dao.alterar(cliente);
		}
	}

	@Override
	public Cliente buscarPorId(Long id, Usuario usuario) {
		Cliente cliente = this.dao.buscarPorId(id);
		if (validarDados(cliente, usuario)) {
			return cliente;
		}
		return null;
	}

	@Override
	public boolean excluir(Long id, Usuario usuario) {
		Cliente cliente = this.dao.buscarPorId(id);
		if (validarDados(cliente, usuario)) {
			this.dao.excluir(cliente);
			return true;
		}
		return false;
	}

	public boolean validarDados(Cliente cliente, Usuario usuario) {
		if (cliente.getUsuario().getId() == usuario.getId()) {
			return true;
		}
		return false;
	}

}
