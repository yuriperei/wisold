package br.com.wisold.produtos;

import br.com.wisold.industrias.Industria;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDao {
	@PersistenceContext
	private EntityManager manager;

	public Produto buscaPorId(Long id) {
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

	public void excluir(Produto t) {
		this.manager.remove(t);
	}

	public List<Produto> listarPorIndustria(Usuario usuario, Industria industria) {
		return this.manager
				.createQuery("select t from Produto t WHERE t.usuario.id = :id and t.industria.id = :idIndustria")
				.setParameter("id", usuario.getId()).setParameter("idIndustria", industria.getId()).getResultList();
	}
}
