package br.com.wisold.clientes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.wisold.persitencia.AbstractDAO;
import br.com.wisold.usuarios.Usuario;

@Repository
public class ClienteDAO implements AbstractDAO<Cliente> {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Cliente buscarPorId(Long id) {
		return this.manager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> listar(Usuario usuario) {
		return this.manager.createQuery("select t from Cliente t WHERE t.usuario.id = :id")
				.setParameter("id", usuario.getId()).getResultList();
	}

	@Override
	public void inserir(Cliente t) {
		this.manager.persist(t);
	}

	@Override
	public void alterar(Cliente t) {
		this.manager.merge(t);
	}

	@Override
	public void excluir(Cliente t) {
		this.manager.remove(t);
	}
		
}
