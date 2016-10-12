package br.com.wisold.produtos;

import br.com.wisold.industrias.Industria;
import br.com.wisold.persitencia.AbstractDLO;
import br.com.wisold.usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository
public class ProdutoDLO{
	@Autowired
	private ProdutoDAO dao;

	public List<Produto> listar(Usuario usuario) {
		List<Produto> retorno = new ArrayList();

		retorno = this.dao.listar(usuario);

		return retorno;
	}

	public List<Produto> listarPorIndustria(Usuario usuario, Industria industria) {
		List<Produto> retorno = new ArrayList();

		retorno = this.dao.listarPorIndustria(usuario, industria);

		return retorno;
	}

	public void manter(Produto produto) {
		if (produto.getId() == null) {
			this.dao.inserir(produto);
		} else {
			this.dao.alterar(produto);
		}
	}

	public Produto buscarPorId(Long id, Usuario usuario) {
		Produto produto = this.dao.buscarPorId(id);
		if (validarDados(produto, usuario)) {
			return produto;
		}
		return null;
	}

	public boolean excluir(Long id, Usuario usuario){
		Produto produto = this.dao.buscarPorId(id);
		if (validarDados(produto, usuario)) {
			produto.setUsuario(null);
			this.dao.alterar(produto);
			return true;
		}
		return false;
	}

	public boolean validarDados(Produto produto, Usuario usuario) {
		if (produto.getUsuario().getId() == usuario.getId()) {
			return true;
		}
		return false;
	}
}
