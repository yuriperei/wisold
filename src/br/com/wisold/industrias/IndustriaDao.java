package br.com.wisold.industrias;

import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class IndustriaDao
{
  @PersistenceContext
  private EntityManager manager;
  
  public Industria buscaPorId(Long id)
  {
    return (Industria)this.manager.find(Industria.class, id);
  }
  
  public List<Industria> listar(Usuario usuario)
  {
    return this.manager.createQuery("select t from Industria t WHERE t.usuario.id = :id").setParameter("id", usuario.getId()).getResultList();
  }
  
  public void inserir(Industria t)
  {
    this.manager.persist(t);
  }
  
  public void alterar(Industria t)
  {
    this.manager.merge(t);
  }
  
  public void excluir(Industria t)
  {
    this.manager.remove(t);
  }
}
