package br.com.wisold.web.seguranca;

import br.com.wisold.usuarios.Usuario;
import br.com.wisold.usuarios.UsuarioDLO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class LoginController {
	@Autowired
	private UsuarioDLO dlo;
	@Autowired
	private HttpSession session;
	
	private ModelAndView retorno = new ModelAndView();

	@RequestMapping({ "/login" })
	public String loginForm() {
		this.session.removeAttribute("deslogado");
		return "login/index";
	}

	@RequestMapping({ "/dashboard" })
	public String dashboard() {
		return "dashboard/index";
	}

	@RequestMapping({ "/sistema" })
	public ModelAndView efetuaLogin(Usuario usuario) {
		if (this.dlo.existeUsuario(usuario.getEmail(), usuario.getSenha())) {
			usuario = this.dlo.buscarPorEmail(usuario.getEmail());
			this.session.setAttribute("user", usuario);
			this.session.removeAttribute("mensagem");
			retorno.setViewName("dashboard/index");
		} else {
			this.session.setAttribute("mensagem", "O usu�rio e/ou senha est�o incorretos!");
			this.session.setAttribute("userAcesso", usuario);
			retorno.setViewName("redirect:login");
		}

		return retorno;
	}

	@RequestMapping({ "/logout" })
	public ModelAndView logout() {
		this.session.removeAttribute("user");
		this.session.removeAttribute("mensagem");
		this.session.removeAttribute("userAcesso");
		this.session.setAttribute("deslogado", "Usu�rio desconectado com sucesso!");

		retorno.setViewName("redirect:login");
		return retorno;
	}
}
