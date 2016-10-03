package br.com.wisold.pedidos;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDlo
{
  @Autowired
  private PedidoDao dao;
  
  public List<Pedido> listar(Usuario usuario)
  {
    List<Pedido> retorno = new ArrayList();
    
    retorno = this.dao.listar(usuario);
    
    return retorno;
  }
  
  public void manterPedido(Pedido pedido)
  {
    if (pedido.getId() == null) {
      this.dao.inserir(pedido);
    } else {
      this.dao.alterar(pedido);
    }
  }
  
  public Pedido buscarPorId(Long id, Usuario usuario)
  {
    Pedido pedido = this.dao.buscaPorId(id);
    if (validarDados(pedido, usuario)) {
      return pedido;
    }
    return null;
  }
  
  public boolean excluir(Long id, Usuario usuario)
  {
    Pedido pedido = this.dao.buscaPorId(id);
    if (validarDados(pedido, usuario))
    {
      this.dao.excluir(pedido);
      return true;
    }
    return false;
  }
  
  public boolean validarDados(Pedido pedido, Usuario usuario)
  {
    if (pedido.getCliente().getUsuario().getId() == usuario.getId()) {
      return true;
    }
    return false;
  }
}
