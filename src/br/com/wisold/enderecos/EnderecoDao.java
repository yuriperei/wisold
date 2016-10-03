package br.com.wisold.enderecos;

import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoDao
{
  @PersistenceContext
  private EntityManager manager;
  
  public Endereco buscaPorId(Long id)
  {
    return (Endereco)this.manager.find(Endereco.class, id);
  }
  
  public List<Endereco> listar(Usuario usuario)
  {
    return this.manager.createQuery("select t from Cliente t WHERE t.usuario.id = :id").setParameter("id", usuario.getId()).getResultList();
  }
  
  public void inserir(Endereco t)
  {
    this.manager.persist(t);
  }
  
  public void alterar(Endereco t)
  {
    this.manager.merge(t);
  }
  
  public void excluir(Endereco t)
  {
    this.manager.remove(t);
  }
}
