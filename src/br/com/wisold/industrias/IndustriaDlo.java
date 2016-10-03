package br.com.wisold.industrias;

import br.com.wisold.usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndustriaDlo
{
  @Autowired
  private IndustriaDao dao;
  
  public List<Industria> listar(Usuario usuario)
  {
    List<Industria> retorno = new ArrayList();
    
    retorno = this.dao.listar(usuario);
    
    return retorno;
  }
  
  public void manterIndustria(Industria industria)
  {
    if (industria.getId() == null) {
      this.dao.inserir(industria);
    } else {
      this.dao.alterar(industria);
    }
  }
  
  public Industria buscarPorId(Long id, Usuario usuario)
  {
    Industria industria = this.dao.buscaPorId(id);
    if (validarDados(industria, usuario)) {
      return industria;
    }
    return null;
  }
  
  public boolean excluir(Long id, Usuario usuario)
  {
    Industria industria = this.dao.buscaPorId(id);
    if (validarDados(industria, usuario))
    {
      this.dao.excluir(industria);
      return true;
    }
    return false;
  }
  
  public boolean validarDados(Industria industria, Usuario usuario)
  {
    if ((industria != null) && (industria.getUsuario().getId() == usuario.getId())) {
      return true;
    }
    return false;
  }
}
