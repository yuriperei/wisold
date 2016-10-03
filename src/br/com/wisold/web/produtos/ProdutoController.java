/*     */ package br.com.wisold.web.produtos;
/*     */ 
/*     */ import br.com.wisold.industrias.Industria;
/*     */ import br.com.wisold.industrias.IndustriaDlo;
/*     */ import br.com.wisold.produtos.Produto;
/*     */ import br.com.wisold.produtos.ProdutoDlo;
/*     */ import br.com.wisold.usuarios.Usuario;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import javax.transaction.Transactional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @Transactional
/*     */ public class ProdutoController
/*     */ {
/*     */   @Autowired
/*     */   private ProdutoDlo dlo;
/*     */   @Autowired
/*     */   private IndustriaDlo industriaDlo;
/*     */   @Autowired
/*     */   private HttpSession session;
/*  33 */   private ModelAndView retorno = new ModelAndView();
/*  34 */   private ModelMap mm = this.retorno.getModelMap();
/*     */   
/*     */   @RequestMapping({"/cadastrarProduto"})
/*     */   public String cadastrar() {
/*  38 */     this.session.setAttribute("industrias", listarIndustrias());
/*  39 */     this.session.removeAttribute("produto");
/*  40 */     return "produto/manter";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/alterarProduto"})
/*     */   public ModelAndView alterar(Long id)
/*     */   {
/*  58 */     return this.retorno;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/excluirProduto"})
/*     */   public ModelAndView excluir(Long id)
/*     */   {
/*  72 */     return this.retorno;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/manterProduto"})
/*     */   public ModelAndView manter(Produto produto, Long idIndustria)
/*     */   {
/*  78 */     Usuario usuario = getUsuario();
/*  79 */     Industria industria = this.industriaDlo.buscarPorId(idIndustria, usuario);
/*     */     
/*  81 */     if (industria != null) {
/*  82 */       produto.setUsuario(usuario);
/*  83 */       produto.setIndustria(industria);
/*  84 */       this.dlo.manterProduto(produto);
/*     */     }
/*     */     
/*  87 */     this.retorno.setViewName("redirect:produtos");
/*  88 */     return this.retorno;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/produtos"})
/*     */   public ModelAndView listar() {
/*  93 */     List<Produto> produtos = this.dlo.listar(getUsuario());
/*     */     
/*  95 */     this.mm.remove("mensagem");
/*  96 */     this.retorno.addObject("produtos", produtos);
/*  97 */     this.retorno.setViewName("produto/index");
/*     */     
/*  99 */     return this.retorno;
/*     */   }
/*     */   
/*     */   private List<Industria> listarIndustrias() {
/* 103 */     return this.industriaDlo.listar(getUsuario());
/*     */   }
/*     */   
/*     */   private Usuario getUsuario() throws NullPointerException {
/* 107 */     return (Usuario)this.session.getAttribute("user");
/*     */   }
/*     */ }


/* Location:              C:\Users\Yuri Pereira\Documents\wi-9-9\WiSold-0.1\WEB-INF\classes\!\br\com\wisold\web\produtos\ProdutoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */