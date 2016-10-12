package br.com.wisold.pedidos;

import br.com.wisold.persitencia.AbstractDAO;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDAO implements AbstractDAO<Pedido> {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Pedido buscarPorId(Long id) {
		return (Pedido) this.manager.find(Pedido.class, id);
	}

	@Override
	public List<Pedido> listar(Usuario usuario) {
		return this.manager.createQuery("select t from Pedido t WHERE t.cliente.usuario.id = :id")
				.setParameter("id", usuario.getId()).getResultList();
	}

	@Override
	public void inserir(Pedido t) {
		this.manager.persist(t);
	}

	@Override
	public void alterar(Pedido t) {
		this.manager.merge(t);
	}

	@Override
	public void excluir(Pedido t) {
		this.manager.remove(t);
	}
}
