<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>

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

				<!-- Horizontal Form -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">Cadastro de endereço</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="manterEndereco">
						<input name="id" type="hidden" value="${endereco.id}">
						<div class="box-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Cidade</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="cidade"
										name="cidade" placeholder="Cidade" value="${endereco.cidade}">
								</div>
								<label for="inputEmail3" class="col-sm-2 control-label">Estado</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="estado"
										name="estado" placeholder="Estado" value="${endereco.estado}">
								</div>
								<label for="inputEmail3" class="col-sm-2 control-label">País</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="pais" name="pais"
										placeholder="País" value="${endereco.pais}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Bairro</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="bairro"
										name="bairro" placeholder="Bairro" value="${endereco.bairro}">
								</div>
								<label for="inputEmail3" class="col-sm-2 control-label">CEP</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="cep" name="cep"
										placeholder="CEP" value="${endereco.cep}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Rua</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="rua" name="rua"
										placeholder="Rua" value="${endereco.rua}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Número</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="numero"
										name="numero" placeholder="Número" value="${endereco.numero}">
								</div>
								<label for="inputEmail3" class="col-sm-2 control-label">Complemento</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="complemento"
										name="complemento" placeholder="Complemento"
										value="${endereco.complemento}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Tipo</label>
								<div class="col-sm-3">
									<select class="form-control select2"
										data-placeholder="Selecione o nome" name="tipo">
										<c:choose>
											<c:when test="${not empty endereco.tipo}">
												<option value="${endereco.tipo}">${endereco.tipo}</option>
											</c:when>
											<c:when test="${empty endereco.tipo}">
												<option value="Endereço da loja">Endereço da loja</option>
												<option value="Endereço de entrega">Endereço de entrega</option>
											</c:when>
										</c:choose>
									</select>

									<!-- /.col -->
								</div>

								<label for="inputEmail3" class="col-sm-2 control-label">Referencia</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="referencia"
										name="referencia" placeholder="Referência"
										value="${endereco.referencia}">
								</div>

								<!-- /.form-group -->
							</div>

							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Observação</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="2" placeholder="Entre com sua observação ..."
										name="observacao" value="${endereco.observacao}"></textarea>
								</div>
								<!-- /.form-group -->
							</div>

							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-info pull-right">Salvar</button>
							</div>
							<!-- /.box-footer -->
					</form>
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
			$("#example1").DataTable();
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false
			});
		});
	</script>
</body>
</html>