<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Endereço</title>

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
			Manter Endereço <small>INFORMAÇÕES SOBRE O ENDEREÇO</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><a href="#"><i class="fa fa-dashboard"></i>
					Endereço</a></li>
		</ol>
		</section>


		<!-- Main content -->
		<section class="content">
		<div class="row">
			<form class="form-horizontal" action="manterEndereco" method="post">
				<input name="id" type="hidden" value="${endereco.id}">

				<div class="col-md-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Detalhes do Endereço</h3>
						</div>
						<!-- /.box-header -->

						<div class="box-body">

							<div class="col-md-8">

								<div class="form-group col-md-12">
									<label>Rua</label> <input type="text" class="form-control"
										id="rua" name="rua" placeholder="Informe o nome da rua"
										value="${endereco.rua}" required>
								</div>
								<!-- /.form-group -->
							</div>

							<div class="col-md-8">

								<div class="form-group col-md-3">
									<label>Número</label> <input type="text" class="form-control"
										id="numero" name="numero" placeholder="Número"
										value="${endereco.numero}" required>
								</div>
								<!-- /.form-group -->


								<div class="col-md-4">
									<label>Complemento</label> <input type="text"
										class="form-control" id="complemento" name="complemento"
										placeholder="Complemento" value="${endereco.complemento}">
								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<div class="form-group col-md-7">
									<label>Bairro</label> <input type="text" class="form-control"
										id="bairro" name="bairro" placeholder="Informe o bairro"
										value="${endereco.bairro}" required>
								</div>
								<!-- /.form-group -->
								
								<div class="col-md-3">
									<label>CEP</label> <input type="text" class="form-control"
										id="cep" name="cep" placeholder="Informe o CEP"
										value="${endereco.cep}" required>
								</div>
								<!-- /.form-group -->

							</div>


							<div class="col-md-8">
							
							<div class="form-group col-md-4">
									<label>Cidade</label> <input type="text" class="form-control"
										id="cidade" name="cidade" placeholder="Cidade"
										value="${endereco.cidade}" required>
								</div>
								<!-- /.form-group -->
								
								<div class="col-md-4">
									<label>Estado</label> <input type="text" class="form-control"
										id="estado" name="estado" placeholder="Estado"
										value="${endereco.estado}" required>
								</div>
								<!-- /.form-group -->
								
								<div class="col-md-2">
									<label>País</label> <input type="text" class="form-control"
										id="pais" name="pais" placeholder="País"
										value="${endereco.pais}" required>
								</div>
								<!-- /.form-group -->
							</div>


							<div class="col-md-8">
								<div class="form-group col-md-12">
									<label>Referencia</label> <input type="text"
										class="form-control" id="referencia" name="referencia"
										placeholder="Referência" value="${endereco.referencia}">
								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<div class="form-group col-md-4">
									<label>Tipo de endereço</label> <select
										class="form-control select2"
										data-placeholder="Selecione o nome" name="tipo">
										<option value="Endereço da loja"
											${endereco.tipo eq 'Endereço de loja' ? "selected" : "" }>Endereço
											da loja</option>
										<option value="Endereço de entrega"
											${endereco.tipo eq 'Endereço de entrega' ? "selected" : "" }>Endereço
											de entrega</option>

									</select>

								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<div class="form-group col-md-10">
									<label>Observação</label>
									<textarea class="form-control" rows="2"
										placeholder="Entre com sua observação ..." name="observacao">${endereco.observacao}</textarea>

								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->



						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="submit" class="btn btn-primary pull-right">Salvar</button>
						</div>
						<!-- /.box-footer -->

					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->

			</form>
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