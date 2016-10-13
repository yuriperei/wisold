<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto</title>

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
			Manter produto <small>DETALHES DO PRODUTO</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Produtos</a></li>
			<li class="active">Produto</li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content">
		<div class="row">
			<form class="form-horizontal" action="manterProduto" method="post">
				<input name="id" type="hidden" value="${produto.id}">

				<div class="col-md-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Detalhes do Produto</h3>
						</div>
						<!-- /.box-header -->

						<div class="box-body">

							<div class="col-md-8">

								<div class="form-group col-md-4">
									<label>Código do produto</label> <input type="text"
										class="form-control" id="codigoProduto" name="codigoProduto"
										placeholder="Informe o código do produto"
										value="${produto.codigoProduto}" required>
								</div>
								<!-- /.form-group -->
							</div>

							<div class="col-md-8">
								<div class="form-group col-md-10">
									<label>Indústria</label> <select class="form-control select2"
										data-placeholder="Selecione a indústria" name="idIndustria"
										id="idIndustria">
										<c:forEach items="${industrias}" var="industria">
											<option value="${industria.id}"
												${industria.id == produto.industria.id ? "selected" : "" }>${industria.nomeFantasia}</option>
										</c:forEach>

									</select>
								</div>
								<!-- /.form-group -->
							</div>

							<div class="col-md-8">
								<div class="form-group col-md-10">
									<label>Nome</label> <input type="text" class="form-control"
										id="nome" name="nome" placeholder="Informe o nome do produto"
										value="${produto.nome}" required>
								</div>
								<!-- /.form-group -->
							</div>

							<div class="col-md-8">
								<div class="form-group col-md-5">
									<label>Embalagem</label> <input type="number"
										class="form-control" id="embalagem" name="embalagem"
										placeholder="Quantidade de produto por embalagem: 1, 5, 10 etc."
										value="${produto.embalagem}">

								</div>
								<!-- /.form-group -->

								<div class="col-md-5">
									<label>Unidade de medida</label> <input type="text"
										class="form-control" id="unidadeMedida" name="unidadeMedida"
										placeholder="Exemplo: KG, CX, PCT, FARDO etc."
										value="${produto.unidadeMedida}">

								</div>
								<!-- /.form-group -->

							</div>

							<div class="col-md-8">
								<div class="form-group col-md-4">
									<label>Preço</label> <input type="number" class="form-control"
										id="preco" name="preco" placeholder="R$"
										value="${produto.preco}" step='any' min='0' required>
								</div>
								<!-- /.form-group -->

								<div class="col-md-4">
									<label>Peso bruto (Kg)</label> <input type="number"
										class="form-control" id="pesoBruto" name="pesoBruto"
										placeholder="Peso em Kg" value="${produto.pesoBruto}" step='any' min='0'>
								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->

							<div class="col-md-8">
								<div class="form-group col-md-10">
									<label>Observação</label> <textarea class="form-control" rows="2"
								placeholder="Entre com sua observação ..." name="observacao"
								id="observacao">${produto.observacao}</textarea>
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

				<div class="col-md-12">
					<c:if test="${not empty mensagem}">
						<div class="alert alert-danger alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							<p>${mensagem}</p>
						</div>
					</c:if>
				</div>
				<!-- /.col -->


			</form>
		</div>
		<!-- /.row --> </section>
		<!-- /.content -->


	</div>
	<!-- /.content-wrapper -->
	<%@ include file="../estrutura/rodape.jspf"%>

	<!-- Select2 -->
	<script src="resources/plugins/select2/select2.full.min.js"
		type="text/javascript"></script>
	<!-- InputMask -->
	<script src="resources/plugins/input-mask/jquery.inputmask.js"
		type="text/javascript"></script>
	<script
		src="resources/plugins/input-mask/jquery.inputmask.date.extensions.js"
		type="text/javascript"></script>
	<script
		src="resources/plugins/input-mask/jquery.inputmask.extensions.js"
		type="text/javascript"></script>

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

	<script src="resources/plugins/iCheck/icheck.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			//Initialize Select2 Elements
			$(".select2").select2();

			//Datemask dd/mm/yyyy
			$("#datemask").inputmask("dd/mm/yyyy", {
				"placeholder" : "dd/mm/yyyy"
			});
			//Datemask2 mm/dd/yyyy
			$("#datemask2").inputmask("mm/dd/yyyy", {
				"placeholder" : "mm/dd/yyyy"
			});
			//Money Euro
			$("[data-mask]").inputmask();

			//Date range picker
			$('#reservation').daterangepicker();
			//Date range picker with time picker
			$('#reservationtime').daterangepicker({
				timePicker : true,
				timePickerIncrement : 30,
				format : 'MM/DD/YYYY h:mm A'
			});
			//Date range as a button
			$('#daterange-btn').daterangepicker(
					{
						ranges : {
							'Today' : [ moment(), moment() ],
							'Yesterday' : [ moment().subtract(1, 'days'),
									moment().subtract(1, 'days') ],
							'Last 7 Days' : [ moment().subtract(6, 'days'),
									moment() ],
							'Last 30 Days' : [ moment().subtract(29, 'days'),
									moment() ],
							'This Month' : [ moment().startOf('month'),
									moment().endOf('month') ],
							'Last Month' : [
									moment().subtract(1, 'month').startOf(
											'month'),
									moment().subtract(1, 'month')
											.endOf('month') ]
						},
						startDate : moment().subtract(29, 'days'),
						endDate : moment()
					},
					function(start, end) {
						$('#reportrange span').html(
								start.format('MMMM D, YYYY') + ' - '
										+ end.format('MMMM D, YYYY'));
					});

			//iCheck for checkbox and radio inputs
			$('input[type="checkbox"].minimal, input[type="radio"].minimal')
					.iCheck({
						checkboxClass : 'icheckbox_minimal-blue',
						radioClass : 'iradio_minimal-blue'
					});
			//Red color scheme for iCheck
			$(
					'input[type="checkbox"].minimal-red, input[type="radio"].minimal-red')
					.iCheck({
						checkboxClass : 'icheckbox_minimal-red',
						radioClass : 'iradio_minimal-red'
					});
			//Flat red color scheme for iCheck
			$('input[type="checkbox"].flat-red, input[type="radio"].flat-red')
					.iCheck({
						checkboxClass : 'icheckbox_flat-green',
						radioClass : 'iradio_flat-green'
					});

			//Colorpicker
			$(".my-colorpicker1").colorpicker();
			//color picker with addon
			$(".my-colorpicker2").colorpicker();

			//Timepicker
			$(".timepicker").timepicker({
				showInputs : false
			});
		});
	</script>
</body>
</html>