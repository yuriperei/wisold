package br.com.wisold.produtos;

import br.com.wisold.industrias.Industria;
import br.com.wisold.usuarios.Usuario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto
{
  @Id
  @GeneratedValue
  private Long id;
  private String codigoProduto;
  private String nome;
  private Double preco;
  private Integer embalagem;
  private Double pesoBruto;
  private String unidadeMedida;
  private String observacao;
  @ManyToOne
  private Industria industria;
  @ManyToOne
  private Usuario usuario;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getCodigoProduto()
  {
    return this.codigoProduto;
  }
  
  public void setCodigoProduto(String codigoProduto)
  {
    this.codigoProduto = codigoProduto;
  }
  
  public String getNome()
  {
    return this.nome;
  }
  
  public void setNome(String nome)
  {
    this.nome = nome;
  }
  
  public Double getPreco()
  {
    return this.preco;
  }
  
  public void setPreco(Double preco)
  {
    this.preco = preco;
  }
  
  public Integer getEmbalagem()
  {
    return this.embalagem;
  }
  
  public void setEmbalagem(Integer embalagem)
  {
    this.embalagem = embalagem;
  }
  
  public Double getPesoBruto()
  {
    return this.pesoBruto;
  }
  
  public void setPesoBruto(Double pesoBruto)
  {
    this.pesoBruto = pesoBruto;
  }
  
  public String getUnidadeMedida()
  {
    return this.unidadeMedida;
  }
  
  public void setUnidadeMedida(String unidadeMedida)
  {
    this.unidadeMedida = unidadeMedida;
  }
  
  public String getObservacao()
  {
    return this.observacao;
  }
  
  public void setObservacao(String observacao)
  {
    this.observacao = observacao;
  }
  
  public Industria getIndustria()
  {
    return this.industria;
  }
  
  public void setIndustria(Industria industria)
  {
    this.industria = industria;
  }
  
  public Usuario getUsuario()
  {
    return this.usuario;
  }
  
  public void setUsuario(Usuario usuario)
  {
    this.usuario = usuario;
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
    Produto other = (Produto)obj;
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
