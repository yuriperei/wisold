package br.com.wisold.web.clientes;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.clientes.ClienteDlo;
import br.com.wisold.usuarios.Usuario;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class ClienteController {
	@Autowired
	private ClienteDlo dlo;
	@Autowired
	private HttpSession session;
	private ModelAndView retorno = new ModelAndView();
	private ModelMap mm = this.retorno.getModelMap();

	@RequestMapping({ "/cadastrarCliente" })
	public String cadastrar() {
		this.session.removeAttribute("cliente");
		return "cliente/manter";
	}

	@RequestMapping({ "/alterarCliente" })
	public ModelAndView alterar(Long id) {
		Cliente cliente = this.dlo.buscarPorId(id, getUsuario());

		if (cliente != null) {
			this.session.removeAttribute("industria");
			this.session.setAttribute("cliente", cliente);
			this.retorno.setViewName("cliente/manter");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "O cliente não existe!");
			this.retorno.setViewName("cliente/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/excluirCliente" })
	public ModelAndView excluir(Long id) {
		if (this.dlo.excluir(id, getUsuario())) {
			this.retorno.setViewName("redirect:clientes");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "Não foi possível deletar o cliente");
			this.retorno.setViewName("cliente/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/manterCliente" })
	public ModelAndView manter(Cliente cliente) {
		cliente.setUsuario(getUsuario());

		this.dlo.manterCliente(cliente);
		this.retorno.setViewName("redirect:clientes");
		return this.retorno;
	}

	@RequestMapping({ "/clientes" })
	public ModelAndView listar() {
		List<Cliente> clientes = this.dlo.listar(getUsuario());

		this.mm.remove("mensagem");
		this.retorno.addObject("clientes", clientes);
		this.retorno.setViewName("cliente/index");

		return this.retorno;
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}
}
