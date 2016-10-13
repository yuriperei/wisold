package br.com.wisold.produtos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.wisold.industrias.Industria;
import br.com.wisold.usuarios.Usuario;

@Repository
public class ProdutoDAO {
	@PersistenceContext
	private EntityManager manager;

	public Produto buscarPorId(Long id) {
		return (Produto) this.manager.find(Produto.class, id);
	}

	public List<Produto> listar(Usuario usuario) {
		return this.manager.createQuery("select t from Produto t WHERE t.usuario.id = :id")
				.setParameter("id", usuario.getId()).getResultList();
	}

	public void inserir(Produto t) {
		this.manager.persist(t);
	}

	public void alterar(Produto t) {
		this.manager.merge(t);
	}

/*	public void excluir(Produto t) {

		this.manager.createQuery("UPDATE Usuario tFROM Produto WHERE t.usuario.id = :id").setParameter("id", t.getUsuario().getId());
//		this.manager.remove(t);

	}*/

	public List<Produto> listarPorIndustria(Usuario usuario, Industria industria) {
		return this.manager
				.createQuery("select t from Produto t WHERE t.usuario.id = :id and t.industria.id = :idIndustria")
				.setParameter("id", usuario.getId()).setParameter("idIndustria", industria.getId()).getResultList();
	}
}
