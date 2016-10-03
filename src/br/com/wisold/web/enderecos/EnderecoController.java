/*     */ package br.com.wisold.web.enderecos;
/*     */ 
/*     */ import br.com.wisold.clientes.Cliente;
/*     */ import br.com.wisold.enderecos.Endereco;
/*     */ import br.com.wisold.enderecos.EnderecoDlo;
/*     */ import br.com.wisold.industrias.Industria;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Transactional
/*     */ public class EnderecoController
/*     */ {
/*     */   @Autowired
/*     */   private EnderecoDlo dlo;
/*     */   @Autowired
/*     */   private HttpSession session;
/*  27 */   private ModelAndView retorno = new ModelAndView();
/*  28 */   private ModelMap mm = this.retorno.getModelMap();
/*     */   
/*     */   @RequestMapping({"/cadastrarEndereco"})
/*     */   public String cadastrar() {
/*  32 */     return "endereco/manter";
/*     */   }
/*     */   
/*     */   @RequestMapping({"/manterEndereco"})
/*     */   public ModelAndView manter(Endereco endereco)
/*     */   {
/*  38 */     if (getCliente() != null) {
/*  39 */       endereco.setCliente(getCliente());
/*  40 */       this.retorno.setViewName("redirect:alterarCliente?id=" + getCliente().getId());
/*     */     }
/*     */     
/*  43 */     if (getIndustria() != null) {
/*  44 */       endereco.setIndustria(getIndustria());
/*  45 */       this.retorno.setViewName("redirect:alterarIndustria?id=" + getIndustria().getId());
/*     */     }
/*     */     
/*  48 */     this.dlo.manterEndereco(endereco);
/*     */     
/*  50 */     return this.retorno;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/alterarEndereco"})
/*     */   public ModelAndView alterar(Long id)
/*     */   {
/*  56 */     Endereco endereco = null;
/*     */     
/*  58 */     if (getCliente() != null) {
/*  59 */       endereco = this.dlo.buscarPorId(id, getCliente());
/*  60 */       this.retorno.setViewName("cliente/manter");
/*     */     }
/*     */     
/*  63 */     if (getIndustria() != null) {
/*  64 */       endereco = this.dlo.buscarPorId(id, getIndustria());
/*  65 */       this.retorno.setViewName("industria/manter");
/*     */     }
/*     */     
/*  68 */     if (endereco != null) {
/*  69 */       this.retorno.addObject("endereco", endereco);
/*  70 */       this.mm.remove("mensagem");
/*  71 */       this.retorno.setViewName("endereco/manter");
/*     */     } else {
/*  73 */       this.retorno.addObject("mensagem", "O endereço não existe!");
/*     */     }
/*     */     
/*  76 */     return this.retorno;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/excluirEndereco"})
/*     */   public ModelAndView excluir(Long id)
/*     */   {
/*  82 */     if (getCliente() != null) {
/*  83 */       if (this.dlo.excluir(id, getCliente())) {
/*  84 */         this.mm.remove("mensagem");
/*  85 */         this.retorno.setViewName("redirect:alterarCliente?id=" + getCliente().getId());
/*     */       } else {
/*  87 */         this.retorno.addObject("mensagem", "Não foi possível excluir o endereço");
/*     */       }
/*     */     }
/*     */     
/*  91 */     if (getIndustria() != null) {
/*  92 */       if (this.dlo.excluir(id, getIndustria())) {
/*  93 */         this.mm.remove("mensagem");
/*  94 */         this.retorno.setViewName("redirect:alterarIndustria?id=" + getIndustria().getId());
/*     */       } else {
/*  96 */         this.retorno.addObject("mensagem", "Não foi possível excluir o endereço");
/*     */       }
/*     */     }
/*     */     
/* 100 */     return this.retorno;
/*     */   }
/*     */   
/*     */   private Cliente getCliente() throws NullPointerException {
/* 104 */     return (Cliente)this.session.getAttribute("cliente");
/*     */   }
/*     */   
/*     */   private Industria getIndustria() throws NullPointerException {
/* 108 */     return (Industria)this.session.getAttribute("industria");
/*     */   }
/*     */ }


/* Location:              C:\Users\Yuri Pereira\Documents\wi-9-9\WiSold-0.1\WEB-INF\classes\!\br\com\wisold\web\enderecos\EnderecoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */