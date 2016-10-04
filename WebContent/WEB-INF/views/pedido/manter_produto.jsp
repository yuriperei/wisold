<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>

<!-- DATA TABLES -->
<link href="resources/plugins/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<%@ include file="../estrutura/head.jspf"%>
</head>

<body
	class="skin-blue-light fixed sidebar-mini  sidebar-mini wysihtml5-supported skin-blue">

	<%@ include file="../estrutura/cabecalho.jspf"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Data Tables <small>advanced tables</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Data tables</li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-xs-12">

				<div class="box box-primary">

					<!-- /.box-header -->
					<div class="box-body">
						<table id="tabela" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th style="width: 20px;"></th>
									<th>Código</th>
									<th>Nome</th>
									<th>Indústria</th>
									<th>Preço</th>
									<th>Embalagem</th>
									<th>Observação</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="produto" items="${produtos}">
									<tr>
										<td>


											<form class="form-horizontal" action="adicionarProduto"
												method="post">

												<input name="id" type="hidden" value="${produto.id}">
												<input name="codigoProduto" type="hidden"
													value="${produto.codigoProduto}"> <input
													name="nome" type="hidden" value="${produto.nome}">
												<input name="preco" type="hidden" value="${produto.preco}">
												<input name="embalagem" type="hidden"
													value="${produto.embalagem}"> <input
													name="unidadeMedida" type="hidden"
													value="${produto.unidadeMedida}">




												<button type="button" class="btn btn-primary"
													data-toggle="modal" data-target="#myModal${produto.id}"
													data-backdrop="static">+</button>
												<!-- Modal -->
												<div class="modal fade" id="myModal${produto.id}"
													tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h4 class="modal-title" id="gridModalLabel">
																	<font style='font-weight: bold;'>Produto: </font>
																	${produto.codigoProduto} - ${produto.nome}
																</h4>
																<h5 class="modal-title" id="gridModalLabel">
																	<font style='font-weight: bold;'>Indústria: </font>
																	${produto.industria.nomeFantasia}
																</h5>
															</div>
															<div class="modal-body">

																<div class="form-group">
																	<label for="inputEmail3" class="col-sm-2 control-label">Embalagem</label>
																	<div class="col-sm-3">
																		<input type="text" class="form-control" id="embalagem"
																			name="embalagem_"
																			value="${produto.embalagem} ${produto.unidadeMedida}">
																	</div>
																	<p class="help-block col-sm-7">Exemplo: 1 KG, 2 CX,
																		8 PCT, 6 FARDO etc.</p>
																</div>

																<div class="form-group">
																	<label for="inputEmail3" class="col-sm-2 control-label">Quantidade</label>
																	<div class="col-sm-3">
																		<input type="number" required class="form-control"
																			id="quantidade${produto.id}" name="quantidade_"
																			onblur="calcularTotal(${produto.id})" min='1'>
																	</div>
																	<p class="help-block col-sm-7">Informe a quantidade
																		do itens.</p>
																</div>

																<div class="form-group">
																	<label for="inputEmail3" class="col-sm-2 control-label">Preço</label>
																	<div class="col-sm-3">
																		<input type="number" required class="form-control"
																			id="valor${produto.id}" name="valor_"
																			value="${produto.preco}"
																			onblur="calcularTotal(${produto.id})" step='any'
																			min='0'>
																	</div>
																</div>

																<div class="form-group">
																	<label for="inputEmail3" class="col-sm-2 control-label">Total</label>
																	<div class="col-sm-3">
																		<input type="number" class="form-control"
																			id="total${produto.id}" name="total_" readonly="true">
																	</div>
																	<p class="help-block col-sm-7"></p>
																</div>

															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Cancelar</button>
																<button type="submit" class="btn btn-primary">Adicionar</button>
															</div>
														</div>
													</div>
												</div>

											</form>
										</td>
										<td>${produto.codigoProduto}</td>
										<td>${produto.nome}</td>
										<td>${produto.industria.nomeFantasia}</td>
										<td>${produto.preco}</td>
										<td>${produto.embalagem}${produto.unidadeMedida}</td>
										<td>${produto.observacao}</td>
									</tr>

									<script type="text/javascript">
										function calcularTotal(id) {
											document.getElementById("total"+id).value = document.getElementById("quantidade"+id).value * document.getElementById("valor"+id).value;
										}
										
										
									</script>

								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th></th>
									<th>Código</th>
									<th>Nome</th>
									<th>Indústria</th>
									<th>Preço</th>
									<th>Embalagem</th>
									<th>Observação</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<a class="btn btn-primary pull-right" href="gerarPedido">Gerar
							Pedido</a>
					</div>
					<!-- /.box-footer -->

				</div>
				<!-- /.box -->



			</div>
			<!-- /.col -->

		</div>
		<!-- /.row --> </section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="../estrutura/rodape.jspf"%>

	<!-- jQuery 2.1.4 -->
	<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"
		type="text/javascript"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="resources/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script src="resources/plugins/datatables/jquery.dataTables.min.js"
		type="text/javascript"></script>
	<script src="resources/plugins/datatables/dataTables.bootstrap.min.js"
		type="text/javascript"></script>
	<script src="resources/plugins/datatables/dataTablesTraducao.js"
		type="text/javascript"></script>
	<!-- SlimScroll -->
	<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script src="resources/plugins/fastclick/fastclick.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			$("#tabela").DataTable();

		});
		
	</script>
	<c:forEach var="produto" items="${produtos}">
		<script type="text/javascript">

			$('#myModal'+${produto.id}).on('shown.bs.modal', function () {
			   $('#quantidade'+${produto.id}).focus().val('1').select();
			   $('#total'+${produto.id}).val(${produto.preco});
			   $('#valor'+${produto.id}).val(${produto.preco});
			})
			 
		</script>
	</c:forEach>
</body>
</html>