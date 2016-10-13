package br.com.wisold.web.usuarios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.wisold.usuarios.Usuario;
import br.com.wisold.usuarios.UsuarioDLO;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	UsuarioDLO dlo;
	
	private ModelAndView retorno = new ModelAndView();
	
	@RequestMapping("/cadastrar")
	public String cadastrar(){
		return "usuario/index";
	}
	
	@RequestMapping("/manterUsuario")
	public ModelAndView manter(Usuario usuario, String reSenha){
				
		retorno.getModelMap().remove("usuario");
		retorno.getModelMap().remove("sucesso");
		retorno.getModelMap().remove("erro");
		
		if(usuario != null){
			if(usuario.getSenha().equals(reSenha)){
				if(this.dlo.buscarPorEmail(usuario.getEmail()) == null){
					this.dlo.manter(usuario);
					retorno.addObject("sucesso", "Sr(a). "+usuario.getNome()+", seu cadastro foi efetuado!");
				}else{
					retorno.addObject("erro", "Já existe um usuário cadastrado com esse e-mail!");
					retorno.addObject("novoUsuario", usuario);
				}
			}else{
				retorno.addObject("erro", "As senhas não conferem!");
				retorno.addObject("novoUsuario", usuario);
			}
		}
		
		retorno.setViewName("usuario/index");
		return retorno;
	}

}
