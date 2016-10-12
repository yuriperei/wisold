package br.com.wisold.enderecos;

import br.com.wisold.persitencia.AbstractDAO;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoDAO implements AbstractDAO<Endereco> {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Endereco buscarPorId(Long id) {
		return this.manager.find(Endereco.class, id);
	}

	@Override
	public List<Endereco> listar(Usuario usuario) {
		return this.manager.createQuery("select t from Cliente t WHERE t.usuario.id = :id")
				.setParameter("id", usuario.getId()).getResultList();
	}

	@Override
	public void inserir(Endereco t) {
		this.manager.persist(t);
	}

	@Override
	public void alterar(Endereco t) {
		this.manager.merge(t);
	}

	@Override
	public void excluir(Endereco t) {
		this.manager.remove(t);
	}
}
