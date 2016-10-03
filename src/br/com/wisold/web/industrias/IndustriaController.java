/*    */ package br.com.wisold.web.industrias;
/*    */ 
/*    */ import br.com.wisold.industrias.Industria;
/*    */ import br.com.wisold.industrias.IndustriaDlo;
/*    */ import br.com.wisold.usuarios.Usuario;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @Transactional
/*    */ public class IndustriaController
/*    */ {
/*    */   @Autowired
/*    */   private IndustriaDlo dlo;
/*    */   @Autowired
/*    */   private HttpSession session;
/* 29 */   private ModelAndView retorno = new ModelAndView();
/* 30 */   private ModelMap mm = this.retorno.getModelMap();
/*    */   
/*    */   @RequestMapping({"/cadastrarIndustria"})
/*    */   public String cadastrar() {
/* 34 */     this.session.removeAttribute("industria");
/* 35 */     return "industria/manter";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/alterarIndustria"})
/*    */   public ModelAndView alterar(Long id)
/*    */   {
/* 41 */     Industria industria = this.dlo.buscarPorId(id, getUsuario());
/*    */     
/* 43 */     if (industria != null) {
/* 44 */       this.session.removeAttribute("cliente");
/* 45 */       this.session.setAttribute("industria", industria);
/* 46 */       this.retorno.setViewName("industria/manter");
/* 47 */       this.mm.remove("mensagem");
/*    */     } else {
/* 49 */       this.retorno.addObject("mensagem", "A indústria não existe!");
/* 50 */       this.retorno.setViewName("industria/index");
/*    */     }
/*    */     
/* 53 */     return this.retorno;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/excluirIndustria"})
/*    */   public ModelAndView excluir(Long id)
/*    */   {
/* 59 */     if (this.dlo.excluir(id, getUsuario())) {
/* 60 */       this.retorno.setViewName("redirect:industrias");
/* 61 */       this.mm.remove("mensagem");
/*    */     } else {
/* 63 */       this.retorno.addObject("mensagem", "Não foi possível deletar a indústria");
/* 64 */       this.retorno.setViewName("industria/index");
/*    */     }
/*    */     
/* 67 */     return this.retorno;
/*    */   }
/*    */   
/*    */ 
/*    */   @RequestMapping({"/manterIndustria"})
/*    */   public ModelAndView manter(Industria industria)
/*    */   {
/* 74 */     industria.setUsuario(getUsuario());
/*    */     
/* 76 */     this.dlo.manterIndustria(industria);
/* 77 */     this.retorno.setViewName("redirect:industrias");
/* 78 */     return this.retorno;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/industrias"})
/*    */   public ModelAndView listar() {
/* 83 */     List<Industria> industrias = this.dlo.listar(getUsuario());
/*    */     
/* 85 */     this.mm.remove("mensagem");
/* 86 */     this.retorno.addObject("industrias", industrias);
/* 87 */     this.retorno.setViewName("industria/index");
/*    */     
/* 89 */     return this.retorno;
/*    */   }
/*    */   
/*    */   private Usuario getUsuario() throws NullPointerException {
/* 93 */     return (Usuario)this.session.getAttribute("user");
/*    */   }
/*    */ }


/* Location:              C:\Users\Yuri Pereira\Documents\wi-9-9\WiSold-0.1\WEB-INF\classes\!\br\com\wisold\web\industrias\IndustriaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */