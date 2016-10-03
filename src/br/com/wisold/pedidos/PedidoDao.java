package br.com.wisold.pedidos;

import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDao {
	@PersistenceContext
	private EntityManager manager;

	public Pedido buscaPorId(Long id) {
		return (Pedido) this.manager.find(Pedido.class, id);
	}

	public List<Pedido> listar(Usuario usuario) {
		return this.manager.createQuery("select t from Pedido t WHERE t.cliente.usuario.id = :id")
				.setParameter("id", usuario.getId()).getResultList();
	}

	public void inserir(Pedido t) {
		this.manager.persist(t);
	}

	public void alterar(Pedido t) {
		this.manager.merge(t);
	}

	public void excluir(Pedido t) {
		this.manager.remove(t);
	}
}
