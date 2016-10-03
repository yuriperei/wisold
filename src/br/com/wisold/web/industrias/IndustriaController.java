package br.com.wisold.web.industrias;

import br.com.wisold.industrias.Industria;
import br.com.wisold.industrias.IndustriaDlo;
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
public class IndustriaController {
	@Autowired
	private IndustriaDlo dlo;
	@Autowired
	private HttpSession session;
	private ModelAndView retorno = new ModelAndView();
	private ModelMap mm = this.retorno.getModelMap();

	@RequestMapping({ "/cadastrarIndustria" })
	public String cadastrar() {
		this.session.removeAttribute("industria");
		return "industria/manter";
	}

	@RequestMapping({ "/alterarIndustria" })
	public ModelAndView alterar(Long id) {
		Industria industria = this.dlo.buscarPorId(id, getUsuario());

		if (industria != null) {
			this.session.removeAttribute("cliente");
			this.session.setAttribute("industria", industria);
			this.retorno.setViewName("industria/manter");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "A indústria não existe!");
			this.retorno.setViewName("industria/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/excluirIndustria" })
	public ModelAndView excluir(Long id) {
		if (this.dlo.excluir(id, getUsuario())) {
			this.retorno.setViewName("redirect:industrias");
			this.mm.remove("mensagem");
		} else {
			this.retorno.addObject("mensagem", "Não foi possível deletar a indústria");
			this.retorno.setViewName("industria/index");
		}

		return this.retorno;
	}

	@RequestMapping({ "/manterIndustria" })
	public ModelAndView manter(Industria industria) {
		industria.setUsuario(getUsuario());

		this.dlo.manterIndustria(industria);
		this.retorno.setViewName("redirect:industrias");
		return this.retorno;
	}

	@RequestMapping({ "/industrias" })
	public ModelAndView listar() {
		List<Industria> industrias = this.dlo.listar(getUsuario());

		this.mm.remove("mensagem");
		this.retorno.addObject("industrias", industrias);
		this.retorno.setViewName("industria/index");

		return this.retorno;
	}

	private Usuario getUsuario() throws NullPointerException {
		return (Usuario) this.session.getAttribute("user");
	}
}
