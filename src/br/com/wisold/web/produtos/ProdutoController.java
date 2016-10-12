package br.com.wisold.web.produtos;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.wisold.industrias.Industria;
import br.com.wisold.industrias.IndustriaDLO;
import br.com.wisold.produtos.Produto;
import br.com.wisold.produtos.ProdutoDLO;
import br.com.wisold.usuarios.Usuario;

@Controller
@Transactional
public class ProdutoController {
	@Autowired
	private ProdutoDLO dlo;
	@Autowired
	private IndustriaDLO industriaDLO;
	@Autowired
	private HttpSession session;

	private ModelAndView retorno = new ModelAndView();

	private ModelMap mm = this.retorno.getModelMap();

	@RequestMapping({ "/cadastrarProduto" })
	public String cadastrar() {

		this.session.setAttribute("industrias", listarIndustrias());
		this.session.removeAttribute("produto");
		return "produto/manter";
	}

	@RequestMapping({ "/alterarProduto" })
	public ModelAndView alterar(Long id) {
		Produto produto = this.dlo.buscarPorId(id, getUsuario());

		if (produto != null) {
			this.session.setAttribute("industrias", listarIndustrias());
			this.session.setAttribute("produto", produto);
			this.retorno.setViewName("produto/manter");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "O produto não existe!");
			this.retorno.setViewName("produto/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/excluirProduto" })
	public ModelAndView excluir(Long id) {

		if (this.dlo.excluir(id, getUsuario())) {
			this.retorno.setViewName("redirect:produtos");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "Não foi possível deletar o produto");
			this.retorno.setViewName("produto/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/manterProduto" })
	public ModelAndView manter(Produto produto, Long idIndustria) {
		Usuario usuario = getUsuario();
		Industria industria = this.industriaDLO.buscarPorId(idIndustria, usuario);

		if (industria != null) {
			produto.setUsuario(usuario);
			produto.setIndustria(industria);
			this.dlo.manter(produto);
		}

		this.retorno.setViewName("redirect:produtos");
		return this.retorno;
	}

	@RequestMapping({ "/produtos" })
	public ModelAndView listar() {
		List<Produto> produtos = this.dlo.listar(getUsuario());

		this.mm.remove("mensagem");
		this.retorno.addObject("produtos", produtos);
		this.retorno.setViewName("produto/index");

		return this.retorno;
	}

	private List<Industria> listarIndustrias() {
		return this.industriaDLO.listar(getUsuario());
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}
}
