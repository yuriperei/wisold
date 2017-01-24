<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos</title>

<%@ include file="../estrutura/head.jspf"%>
</head>
<body
	class="skin-blue-light fixed sidebar-mini  sidebar-mini wysihtml5-supported skin-blue">
	<%@ include file="../estrutura/avisoModal.jspf"%>
	<%@ include file="../estrutura/cabecalho.jspf"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Emitir Pedido <small>ESCOLHA UMA INDÚSTRIA - PARTE 1/3</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Pedidos</a></li>
			<li class="active">Indústrias</li>
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
					<div class="box-body">
						<table id="industriaPedidoTable"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Nome Fantasia</th>
									<th>Razão Social</th>
									<th>Comissão (%)</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%-- Preenchido dinamicamente com jquery! --%>
							</tbody>
							<tfoot>
								<tr>
									<th>Nome Fantasia</th>
									<th>Razão Social</th>
									<th>Comissão (%)</th>
									<th></th>
								</tr>

							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->

					<!-- 					<div class="box-footer">
							<a class="btn btn-primary pull-right" href="cadastrarIndustria">Cadastrar novo</a>
					</div>
					/.box-footer -->

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

	
	<!-- 	Pedido JS -->
	<script src="<c:url value="/resources/dist/js/pedido/Industria.js" />" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			$("#tabela").DataTable();

		});
	</script>
</body>
</html>