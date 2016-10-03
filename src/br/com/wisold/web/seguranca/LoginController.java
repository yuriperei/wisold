/*    */ package br.com.wisold.web.seguranca;
/*    */ 
/*    */ import br.com.wisold.usuarios.Usuario;
/*    */ import br.com.wisold.usuarios.UsuarioDlo;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @Transactional
/*    */ public class LoginController
/*    */ {
/*    */   @Autowired
/*    */   private UsuarioDlo dlo;
/*    */   @Autowired
/*    */   private HttpSession session;
/*    */   
/*    */   @RequestMapping({"/login"})
/*    */   public String loginForm()
/*    */   {
/* 27 */     return "login/index";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/dashboard"})
/*    */   public String dashboard() {
/* 32 */     return "dashboard/index";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/sistema"})
/*    */   public ModelAndView efetuaLogin(Usuario usuario)
/*    */   {
/* 38 */     ModelAndView retorno = new ModelAndView();
/* 39 */     if (this.dlo.existeUsuario(usuario.getEmail(), usuario.getSenha())) {
/* 40 */       usuario = this.dlo.buscarPorEmail(usuario.getEmail());
/* 41 */       this.session.setAttribute("user", usuario);
/* 42 */       this.session.removeAttribute("mensagem");
/* 43 */       retorno.setViewName("dashboard/index");
/*    */     } else {
/* 45 */       this.session.removeAttribute("deslogado");
/* 46 */       this.session.setAttribute("mensagem", "O usuário e/ou senha estão incorretos!");
/* 47 */       this.session.setAttribute("userAcesso", usuario);
/* 48 */       retorno.setViewName("redirect:index");
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 53 */     return retorno;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/logout"})
/*    */   public ModelAndView logout()
/*    */   {
/* 59 */     ModelAndView retorno = new ModelAndView("redirect:index");
/*    */     
/* 61 */     this.session.removeAttribute("user");
/* 62 */     this.session.removeAttribute("mensagem");
/* 63 */     this.session.removeAttribute("userAcesso");
/* 64 */     this.session.setAttribute("deslogado", "Usuário desconectado com sucesso!");
/*    */     
/* 66 */     return retorno;
/*    */   }
/*    */ }


/* Location:              C:\Users\Yuri Pereira\Documents\wi-9-9\WiSold-0.1\WEB-INF\classes\!\br\com\wisold\web\seguranca\LoginController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */