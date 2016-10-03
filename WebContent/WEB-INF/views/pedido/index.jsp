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

				<c:if test="${not empty mensagem}">
					<div class="alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
						<p>${mensagem}</p>
					</div>
				</c:if>

				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">Data Table With Full Features</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="tabela" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Código</th>
									<th>Indústria</th>
									<th>Total</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pedido" items="${pedidos}">
									<tr>
										<td>${produto.codigo}</td>
										<td>${produto.industria.nomeFantasia}</td>
										<td>${produto.total}</td>
										<td><a class="btn .btn-xs"
											href="visualizarPedido?id=${pedido.id}"> <i
												class="fa fa-edit"></i> Editar
										</a> <a class="btn .btn-xs" href="excluirPedido?id=${pedido.id}">
												<i class="fa  fa-trash"></i> Excluir
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>Código</th>
									<th>Indústria</th>
									<th>Total</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<a class="btn btn-primary pull-right" href="cadastrarPedido">Cadastrar
							novo</a>
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
</body>
</html>