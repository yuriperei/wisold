package br.com.wisold.industrias;

import br.com.wisold.enderecos.Endereco;
import br.com.wisold.produtos.Produto;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="industrias")
public class Industria
{
  @Id
  @GeneratedValue
  private Long id;
  private String nomeFantasia;
  private String razaoSocial;
  private String cnpj;
  private String email;
  private String telefone;
  private Double comissao;
  @ManyToOne
  private Usuario usuario;
  @OneToMany(mappedBy="industria", fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.REMOVE})
  private List<Endereco> enderecos;
  @OneToMany(mappedBy="industria", cascade={javax.persistence.CascadeType.REMOVE})
  private List<Produto> produtos;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getNomeFantasia()
  {
    return this.nomeFantasia;
  }
  
  public void setNomeFantasia(String nomeFantasia)
  {
    this.nomeFantasia = nomeFantasia;
  }
  
  public String getRazaoSocial()
  {
    return this.razaoSocial;
  }
  
  public void setRazaoSocial(String razaoSocial)
  {
    this.razaoSocial = razaoSocial;
  }
  
  public String getCnpj()
  {
    return this.cnpj;
  }
  
  public void setCnpj(String cnpj)
  {
    this.cnpj = cnpj;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getTelefone()
  {
    return this.telefone;
  }
  
  public void setTelefone(String telefone)
  {
    this.telefone = telefone;
  }
  
  public Usuario getUsuario()
  {
    return this.usuario;
  }
  
  public void setUsuario(Usuario usuario)
  {
    this.usuario = usuario;
  }
  
  public Double getComissao()
  {
    return this.comissao;
  }
  
  public void setComissao(Double comissao)
  {
    this.comissao = comissao;
  }
  
  public List<Endereco> getEnderecos()
  {
    return this.enderecos;
  }
  
  public void setEnderecos(List<Endereco> enderecos)
  {
    this.enderecos = enderecos;
  }
  
  public List<Produto> getProdutos()
  {
    return this.produtos;
  }
  
  public void setProdutos(List<Produto> produtos)
  {
    this.produtos = produtos;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Industria other = (Industria)obj;
    if (this.id == null)
    {
      if (other.id != null) {
        return false;
      }
    }
    else if (!this.id.equals(other.id)) {
      return false;
    }
    return true;
  }
}
