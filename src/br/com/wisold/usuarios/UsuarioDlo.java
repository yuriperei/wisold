package br.com.wisold.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wisold.util.Validador;

@Repository
public class UsuarioDlo {
	@Autowired
	private UsuarioDao dao;

	public boolean existeUsuario(String email, String senha) {
		boolean retorno = false;
		if ((Validador.email(email)) && (!Validador.vazio(email)) && (!Validador.vazio(senha))) {
			Usuario usuario = buscarPorEmail(email);
			if ((usuario != null) && (usuario.getSenha() != null) && (usuario.getSenha().equals(senha))) {
				retorno = true;
			}
		}
		return retorno;
	}

	public Usuario buscarPorEmail(String email) {
		Usuario usuario;
		try {
			usuario = this.dao.buscarPorEmail(email);
		} catch (Exception e) {
			usuario = null;
		}
		return usuario;
	}
}
