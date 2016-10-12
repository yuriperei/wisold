package br.com.wisold.industrias;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.wisold.usuarios.Usuario;

@Repository
public class IndustriaDLO {
	@Autowired
	private IndustriaDAO dao;
	
	@Autowired
	private HttpSession session;

	public List<Industria> listar(Usuario usuario) {
		List<Industria> retorno = new ArrayList();

		retorno = this.dao.listar(usuario);
	
		return retorno;
	}
	
/*	public void testar(String nome){
		List<Industria> retorno = new ArrayList();

		retorno = this.dao.listar((Usuario) session.getAttribute("user"));

		for (Industria industria : retorno) {
			System.out.println(">>>"+industria.getNomeFantasia());
		}
//		Usuario u = (Usuario) session.getAttribute("user");
		System.out.println(">>>"+nome);
	}*/
	

	public void manter(Industria industria) {
		if (industria.getId() == null) {
			this.dao.inserir(industria);
		} else {
			this.dao.alterar(industria);
		}
	}

	public Industria buscarPorId(Long id, Usuario usuario) {
		Industria industria = this.dao.buscaPorId(id);
		if (validarDados(industria, usuario)) {
			return industria;
		}
		return null;
	}

	public boolean excluir(Long id, Usuario usuario) {
		Industria industria = this.dao.buscaPorId(id);
		if (validarDados(industria, usuario)) {
			this.dao.excluir(industria);
			return true;
		}
		return false;
	}

	public boolean validarDados(Industria industria, Usuario usuario) {
		if ((industria != null) && (industria.getUsuario().getId() == usuario.getId())) {
			return true;
		}
		return false;
	}
	
}
