package br.com.wisold.web.produtos;

import br.com.wisold.industrias.Industria;
import br.com.wisold.industrias.IndustriaDlo;
import br.com.wisold.produtos.Produto;
import br.com.wisold.produtos.ProdutoDlo;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class ProdutoController {
	@Autowired
	private ProdutoDlo dlo;
	@Autowired
	private IndustriaDlo industriaDlo;
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
		return this.retorno;
	}

	@RequestMapping({ "/excluirProduto" })
	public ModelAndView excluir(Long id) {
		return this.retorno;
	}

	@RequestMapping({ "/manterProduto" })
	public ModelAndView manter(Produto produto, Long idIndustria) {
		Usuario usuario = getUsuario();
		Industria industria = this.industriaDlo.buscarPorId(idIndustria, usuario);

		if (industria != null) {
			produto.setUsuario(usuario);
			produto.setIndustria(industria);
			this.dlo.manterProduto(produto);
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
		return this.industriaDlo.listar(getUsuario());
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}
}
