/*    */ package br.com.wisold.web.clientes;
/*    */ 
/*    */ import br.com.wisold.clientes.Cliente;
/*    */ import br.com.wisold.clientes.ClienteDlo;
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
/*    */ @Controller
/*    */ @Transactional
/*    */ public class ClienteController
/*    */ {
/*    */   @Autowired
/*    */   private ClienteDlo dlo;
/*    */   @Autowired
/*    */   private HttpSession session;
/* 28 */   private ModelAndView retorno = new ModelAndView();
/* 29 */   private ModelMap mm = this.retorno.getModelMap();
/*    */   
/*    */   @RequestMapping({"/cadastrarCliente"})
/*    */   public String cadastrar() {
/* 33 */     this.session.removeAttribute("cliente");
/* 34 */     return "cliente/manter";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/alterarCliente"})
/*    */   public ModelAndView alterar(Long id)
/*    */   {
/* 40 */     Cliente cliente = this.dlo.buscarPorId(id, getUsuario());
/*    */     
/* 42 */     if (cliente != null) {
/* 43 */       this.session.removeAttribute("industria");
/* 44 */       this.session.setAttribute("cliente", cliente);
/* 45 */       this.retorno.setViewName("cliente/manter");
/* 46 */       this.mm.remove("mensagem");
/*    */     } else {
/* 48 */       this.retorno.addObject("mensagem", "O cliente não existe!");
/* 49 */       this.retorno.setViewName("cliente/index");
/*    */     }
/*    */     
/* 52 */     return this.retorno;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/excluirCliente"})
/*    */   public ModelAndView excluir(Long id)
/*    */   {
/* 58 */     if (this.dlo.excluir(id, getUsuario())) {
/* 59 */       this.retorno.setViewName("redirect:clientes");
/* 60 */       this.mm.remove("mensagem");
/*    */     } else {
/* 62 */       this.retorno.addObject("mensagem", "Não foi possível deletar o cliente");
/* 63 */       this.retorno.setViewName("cliente/index");
/*    */     }
/*    */     
/* 66 */     return this.retorno;
/*    */   }
/*    */   
/*    */ 
/*    */   @RequestMapping({"/manterCliente"})
/*    */   public ModelAndView manter(Cliente cliente)
/*    */   {
/* 73 */     cliente.setUsuario(getUsuario());
/*    */     
/* 75 */     this.dlo.manterCliente(cliente);
/* 76 */     this.retorno.setViewName("redirect:clientes");
/* 77 */     return this.retorno;
/*    */   }
/*    */   
/*    */   @RequestMapping({"/clientes"})
/*    */   public ModelAndView listar() {
/* 82 */     List<Cliente> clientes = this.dlo.listar(getUsuario());
/*    */     
/* 84 */     this.mm.remove("mensagem");
/* 85 */     this.retorno.addObject("clientes", clientes);
/* 86 */     this.retorno.setViewName("cliente/index");
/*    */     
/* 88 */     return this.retorno;
/*    */   }
/*    */   
/*    */   private Usuario getUsuario() throws NullPointerException {
/* 92 */     return (Usuario)this.session.getAttribute("user");
/*    */   }
/*    */ }


/* Location:              C:\Users\Yuri Pereira\Documents\wi-9-9\WiSold-0.1\WEB-INF\classes\!\br\com\wisold\web\clientes\ClienteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */