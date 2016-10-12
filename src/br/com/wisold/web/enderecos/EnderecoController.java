package br.com.wisold.web.enderecos;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.wisold.clientes.Cliente;
import br.com.wisold.enderecos.Endereco;
import br.com.wisold.enderecos.EnderecoDLO;
import br.com.wisold.industrias.Industria;

@Controller
@Transactional
public class EnderecoController {
	@Autowired
	private EnderecoDLO dlo;
	@Autowired
	private HttpSession session;
	private ModelAndView retorno = new ModelAndView();
	private ModelMap mm = this.retorno.getModelMap();

	@RequestMapping({ "/cadastrarEndereco" })
	public String cadastrar() {
		return "endereco/manter";
	}

	@RequestMapping({ "/manterEndereco" })
	public ModelAndView manter(Endereco endereco) {
		if (getCliente() != null) {
			endereco.setCliente(getCliente());
			this.retorno.setViewName("redirect:alterarCliente?id=" + getCliente().getId());
		}

		if (getIndustria() != null) {
			endereco.setIndustria(getIndustria());
			this.retorno.setViewName("redirect:alterarIndustria?id=" + getIndustria().getId());
		}

		this.dlo.manter(endereco);

		return this.retorno;
	}

	@RequestMapping({ "/alterarEndereco" })
	public ModelAndView alterar(Long id) {
		Endereco endereco = null;

		if (getCliente() != null) {
			endereco = this.dlo.buscarPorId(id, getCliente());
			this.retorno.setViewName("cliente/manter");
		}

		if (getIndustria() != null) {
			endereco = this.dlo.buscarPorId(id, getIndustria());
			this.retorno.setViewName("industria/manter");
		}

		if (endereco != null) {
			this.retorno.addObject("endereco", endereco);
			this.mm.remove("mensagem");
			this.retorno.setViewName("endereco/manter");
		} else {
			this.retorno.addObject("mensagem", "O endereço não existe!");
		}

		return this.retorno;
	}

	@RequestMapping({ "/excluirEndereco" })
	public ModelAndView excluir(Long id) {
		if (getCliente() != null) {
			if (this.dlo.excluir(id, getCliente())) {
				this.mm.remove("mensagem");
				this.retorno.setViewName("redirect:alterarCliente?id=" + getCliente().getId());
			} else {
				this.retorno.addObject("mensagem", "Não foi possível excluir o endereço");
			}
		}

		if (getIndustria() != null) {
			if (this.dlo.excluir(id, getIndustria())) {
				this.mm.remove("mensagem");
				this.retorno.setViewName("redirect:alterarIndustria?id=" + getIndustria().getId());
			} else {
				this.retorno.addObject("mensagem", "Não foi possível excluir o endereço");
			}
		}

		return this.retorno;
	}

	private Cliente getCliente() throws NullPointerException {
		return (Cliente) this.session.getAttribute("cliente");
	}

	private Industria getIndustria() throws NullPointerException {
		return (Industria) this.session.getAttribute("industria");
	}
}
