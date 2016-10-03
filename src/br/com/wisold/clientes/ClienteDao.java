package br.com.wisold.clientes;

import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao
{
  @PersistenceContext
  private EntityManager manager;
  
  public Cliente buscaPorId(Long id)
  {
    return (Cliente)this.manager.find(Cliente.class, id);
  }
  
  public List<Cliente> listar(Usuario usuario)
  {
    return this.manager.createQuery("select t from Cliente t WHERE t.usuario.id = :id").setParameter("id", usuario.getId()).getResultList();
  }
  
  public void inserir(Cliente t)
  {
    this.manager.persist(t);
  }
  
  public void alterar(Cliente t)
  {
    this.manager.merge(t);
  }
  
  public void excluir(Cliente t)
  {
    this.manager.remove(t);
  }
}
