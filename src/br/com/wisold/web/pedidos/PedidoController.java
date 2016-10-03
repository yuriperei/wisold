package br.com.wisold.web.pedidos;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.clientes.ClienteDlo;
import br.com.wisold.industrias.Industria;
import br.com.wisold.industrias.IndustriaDlo;
import br.com.wisold.pedidos.ItemPedido;
import br.com.wisold.pedidos.Pedido;
import br.com.wisold.pedidos.PedidoDlo;
import br.com.wisold.produtos.Produto;
import br.com.wisold.produtos.ProdutoDlo;
import br.com.wisold.usuarios.Usuario;

@Controller
@Transactional
public class PedidoController {
	@Autowired
	private PedidoDlo dlo;
	@Autowired
	private IndustriaDlo industriaDlo;
	@Autowired
	private ClienteDlo clienteDlo;
	private List<ItemPedido> itensPedido;
	@Autowired
	private ProdutoDlo produtoDlo;
	@Autowired
	private HttpSession session;
	private ModelAndView retorno = new ModelAndView();

	@RequestMapping({ "/cadastrarPedido" })
	public String cadastrar() {
		this.session.setAttribute("industrias", listarIndustrias());

		return "pedido/manter_industria";
	}

	@RequestMapping({ "/pedido" })
	public String cadastrar(Long idIndustria) {
		Industria industria = this.industriaDlo.buscarPorId(idIndustria, getUsuario());

		if ((industria != null) && (!industria.getProdutos().isEmpty())) {
			this.session.setAttribute("produtos", listarProdutos(industria));

			this.session.setAttribute("industria", industria);
			this.itensPedido = new ArrayList();
		}

		return "pedido/manter";
	}

	@RequestMapping({ "/adicionarProduto" })
	public String pedidoProduto(Produto produto, Integer quantidade_, Double valor_, Double total_, String embalagem_) {
		ItemPedido itemPedido = new ItemPedido();

		itemPedido.setQuantidade(quantidade_);
		itemPedido.setValor(valor_);
		itemPedido.setTotal(total_);
		itemPedido.setEmbalagem(embalagem_);
		itemPedido.setProduto(produto);

		this.itensPedido.add(itemPedido);

		for (ItemPedido ip : this.itensPedido) {
			System.out.println(">>>>>> " + ip.getProduto().getNome());
			System.out.println(">>>>>> " + ip.getQuantidade());
			System.out.println(">>>>>> " + ip.getValor());
			System.out.println(">>>>>> " + ip.getTotal());
		}
		System.out.println("-----------------------------------------------");
		return "pedido/manter";
	}

	@RequestMapping({ "/alterarPedido" })
	public ModelAndView alterar(Long id) {
		return this.retorno;
	}

	@RequestMapping({ "/excluirPedido" })
	public ModelAndView excluir(Long id) {
		return this.retorno;
	}

	@RequestMapping({ "/manterPedido" })
	public ModelAndView manter(Pedido pedido, Long idIndustria) {
		return this.retorno;
	}

	@RequestMapping({ "/pedidos" })
	public ModelAndView listar() {
		List<Pedido> pedidos = this.dlo.listar(getUsuario());

		this.retorno.getModelMap().remove("mensagem");
		this.retorno.addObject("pedidos", pedidos);
		this.retorno.setViewName("pedido/index");

		return this.retorno;
	}

	private List<Industria> listarIndustrias() {
		return this.industriaDlo.listar(getUsuario());
	}

	private List<Produto> listarProdutos(Industria industria) {
		return this.produtoDlo.listarPorIndustria(getUsuario(), industria);
	}

	private List<Cliente> listarClientes() {
		return this.clienteDlo.listar(getUsuario());
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}
}
