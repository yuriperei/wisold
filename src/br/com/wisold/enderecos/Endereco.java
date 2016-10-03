package br.com.wisold.enderecos;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.industrias.Industria;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enderecos")
public class Endereco
{
  @Id
  @GeneratedValue
  private Long id;
  private String pais;
  private String estado;
  private String cidade;
  private String bairro;
  private String rua;
  private String cep;
  private String numero;
  private String complemento;
  private String referencia;
  private String tipo;
  private String observacao;
  @ManyToOne
  private Cliente cliente;
  @ManyToOne
  private Industria industria;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
  
  public String getPais()
  {
    return this.pais;
  }
  
  public void setPais(String pais)
  {
    this.pais = pais;
  }
  
  public String getEstado()
  {
    return this.estado;
  }
  
  public void setEstado(String estado)
  {
    this.estado = estado;
  }
  
  public String getCidade()
  {
    return this.cidade;
  }
  
  public void setCidade(String cidade)
  {
    this.cidade = cidade;
  }
  
  public String getBairro()
  {
    return this.bairro;
  }
  
  public void setBairro(String bairro)
  {
    this.bairro = bairro;
  }
  
  public String getRua()
  {
    return this.rua;
  }
  
  public void setRua(String rua)
  {
    this.rua = rua;
  }
  
  public String getCep()
  {
    return this.cep;
  }
  
  public void setCep(String cep)
  {
    this.cep = cep;
  }
  
  public String getNumero()
  {
    return this.numero;
  }
  
  public void setNumero(String numero)
  {
    this.numero = numero;
  }
  
  public String getComplemento()
  {
    return this.complemento;
  }
  
  public void setComplemento(String complemento)
  {
    this.complemento = complemento;
  }
  
  public String getReferencia()
  {
    return this.referencia;
  }
  
  public void setReferencia(String referencia)
  {
    this.referencia = referencia;
  }
  
  public String getTipo()
  {
    return this.tipo;
  }
  
  public void setTipo(String tipo)
  {
    this.tipo = tipo;
  }
  
  public String getObservacao()
  {
    return this.observacao;
  }
  
  public void setObservacao(String observacao)
  {
    this.observacao = observacao;
  }
  
  public Cliente getCliente()
  {
    return this.cliente;
  }
  
  public void setCliente(Cliente cliente)
  {
    this.cliente = cliente;
  }
  
  public Industria getIndustria()
  {
    return this.industria;
  }
  
  public void setIndustria(Industria industria)
  {
    this.industria = industria;
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
    Endereco other = (Endereco)obj;
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
