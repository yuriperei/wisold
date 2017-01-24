package br.com.wisold.web.pedidos;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.clientes.ClienteDLO;
import br.com.wisold.industrias.Industria;
import br.com.wisold.industrias.IndustriaDLO;
import br.com.wisold.pedidos.ItemPedido;
import br.com.wisold.pedidos.Pedido;
import br.com.wisold.pedidos.PedidoDLO;
import br.com.wisold.produtos.Produto;
import br.com.wisold.produtos.ProdutoDLO;
import br.com.wisold.usuarios.Usuario;
import br.com.wisold.util.json.AjaxResponseBody;
import br.com.wisold.util.json.Views;

@Controller
@Transactional
@RequestMapping(value = "/pedido")
public class PedidoController {
	@Autowired
	private PedidoDLO dlo;
	@Autowired
	private IndustriaDLO industriaDLO;
	@Autowired
	private ClienteDLO clienteDLO;
	private List<ItemPedido> itensPedido;
	@Autowired
	private ProdutoDLO produtoDLO;
	@Autowired
	private HttpSession session;
	private ModelAndView retorno = new ModelAndView();

	@RequestMapping(value = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarPedidoPage() {
		this.session.removeAttribute("itensPedido");
		return "pedido/manter_industria";
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value={"/carregar/industria.json"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AjaxResponseBody<Industria> getIndustrias() {

		AjaxResponseBody<Industria> result = new AjaxResponseBody<Industria>();
		
		List<Industria> industrias = listarIndustrias();
		
		if (industrias.size() > 0) {
			result.setCode("200");
			result.setMsg("");
			result.setResult(industrias);
		} else {
			result.setCode("204");
			result.setMsg("É necessário ter ao menos uma Indústria cadastrada.");
		}
		
		return result;
	}
	
	@RequestMapping({ "/industria/{id}" })
	public String cadastrar(@PathVariable Long id) {
		Industria industria = this.industriaDLO.buscarPorId(id, getUsuario());

		if ((industria != null) && (!industria.getProdutos().isEmpty())) {
			this.session.setAttribute("produtos", listarProdutos(industria));

			this.session.setAttribute("industria", industria);
		}

		return "pedido/manter_produto";
	}

	@RequestMapping({ "/adicionarProduto" })
	public String pedidoProduto(Produto produto, Integer quantidade_, Double valor_, Double total_, String embalagem_) {
		ItemPedido itemPedido = new ItemPedido();

		itemPedido.setQuantidade(quantidade_);
		itemPedido.setValor(valor_);
		itemPedido.setTotal(total_);
		itemPedido.setEmbalagem(embalagem_);
		itemPedido.setProduto(produto);

		if (this.session.getAttribute("itensPedido") == null) {
			this.itensPedido = new ArrayList();
		} else {
			this.itensPedido = (List<ItemPedido>) this.session.getAttribute("itensPedido");
		}

		this.itensPedido.add(itemPedido);
		this.session.setAttribute("itensPedido", itensPedido);
		this.session.setAttribute("mensagem", "Produto "+ produto.getNome() + " adicionado com sucesso");

		return "pedido/manter_produto";
	}

	@RequestMapping({ "/gerar" })
	public ModelAndView gerarPedido() {

		List<Cliente> clientes = clienteDLO.listar(getUsuario());
		session.setAttribute("clientes", clientes);

		retorno.setViewName("pedido/detalhes");
		this.session.removeAttribute("mensagem");
		
		return this.retorno;
	}
	
	@RequestMapping("/obter/{id}")
	public ModelAndView obter(@PathVariable Long id){
		Pedido pedido = this.dlo.buscarPorId(id, getUsuario());

		if (pedido != null) {
			this.session.setAttribute("pedido", pedido);
			this.retorno.setViewName("pedido/visualizar");
			this.retorno.getModelMap().remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "O pedido não existe!");
			this.retorno.setViewName("pedido/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/excluir/{id}" })
	public ModelAndView excluir(@PathVariable Long id) {
		if (this.dlo.excluir(id, getUsuario())) {
			this.retorno.setViewName("redirect:pedidos");
			this.retorno.getModelMap().remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "Não foi possível deletar o pedido");
			this.retorno.setViewName("pedido/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/manter"})
	public ModelAndView manter(Pedido pedido) {

		pedido.setIndustria((Industria) session.getAttribute("industria"));
		pedido.setItens(this.manterItensPedido(pedido));

		dlo.manter(pedido);
		this.retorno.setViewName("redirect:pedidos");
		return this.retorno;
	}

	@RequestMapping({ "/obter" })
	public ModelAndView listar() {
		List<Pedido> pedidos = this.dlo.listar(getUsuario());

		this.retorno.getModelMap().remove("mensagem");
		this.retorno.addObject("pedidos", pedidos);
		this.retorno.setViewName("pedido/index");

		return this.retorno;
	}

	private List<Industria> listarIndustrias() {
		return this.industriaDLO.listar(getUsuario());
	}

	private List<Produto> listarProdutos(Industria industria) {
		return this.produtoDLO.listarPorIndustria(getUsuario(), industria);
	}

	private List<Cliente> listarClientes() {
		return this.clienteDLO.listar(getUsuario());
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}

	// Responsável por settar qual é o pedido do item
	private List<ItemPedido> manterItensPedido(Pedido pedido) {

		List<ItemPedido> itens = (List<ItemPedido>) session.getAttribute("itensPedido");

		for (ItemPedido itemPedido : itens) {
			itemPedido.setPedido(pedido);
		}

		return itens;
	}
}
