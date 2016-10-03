package br.com.wisold.produtos;

import br.com.wisold.industrias.Industria;
import br.com.wisold.usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDlo {
	@Autowired
	private ProdutoDao dao;

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

	public void manterProduto(Produto produto) {
		if (produto.getId() == null) {
			this.dao.inserir(produto);
		} else {
			this.dao.alterar(produto);
		}
	}

	public Produto buscarPorId(Long id, Usuario usuario) {
		Produto produto = this.dao.buscaPorId(id);
		if (validarDados(produto, usuario)) {
			return produto;
		}
		return null;
	}

	public boolean excluir(Long id, Usuario usuario) {
		Produto produto = this.dao.buscaPorId(id);
		if (validarDados(produto, usuario)) {
			this.dao.excluir(produto);
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
