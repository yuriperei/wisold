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

<script>
var total = 0;

function writeTotal(valor) {
total = total + valor		

}

function exibir(){
	document.getElementById("td-total").innerHTML = total;
}

onload = function(){
	exibir();
};


</script>

</head>
<body
	class="skin-blue-light fixed sidebar-mini  sidebar-mini wysihtml5-supported skin-blue">

	<%@ include file="../estrutura/cabecalho.jspf"%>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Pedido #${pedido.codigo} <small>DETALHES DO PEDIDO</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Pedido</a></li>
			<li class="active"><a href="#">Visualizar pedido</a></li>
		</ol>
		</section>

		<!-- Main content -->
		<section class="content"> 
		<div class="row">
			<form class="form-horizontal" action="manterPedido" method="post">

				<div class="col-md-12">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Detalhes do Pedido</h3>
						</div>
						<!-- /.box-header -->

						<div class="box-body">

							<div class="col-md-8">

								<div class="form-group col-md-4">
									<label>Código do Pedido</label> <input type="text"
										class="form-control" id="codigo" name="codigo"
										placeholder="Código do pedido" disabled="true" value="${pedido.codigo}" required>
								</div>
								<!-- /.form-group -->

								<div class="form-group col-md-12">
									<label>Cliente</label> <select class="form-control select2 disabled"
										data-placeholder="Selecione um cliente" name="cliente.id"
										style="width: 100%;" disabled="true">
											<option value="${pedido.cliente.id}" selected="selected">${pedido.cliente.nome}</option>
									</select>
								</div>
								<!-- /.form-group -->

								<div class="form-group col-md-12">
									<label>Indústria</label> <input type="text"
										class="form-control" id="codigo" name="codigo"
										placeholder="Indústria" value="${pedido.industria.nomeFantasia}"
										disabled="true">
								</div>
								<!-- /.form-group -->

							</div>
							<!-- /.col -->

						</div>
						<!-- /.box-body -->

					</div>
					<!-- /.box -->
				</div>
				<!-- /.col -->

				<div class="col-md-12">
				
					<div class="box box-default">
						<div class="box-header with-border">
							<h3 class="box-title">Produtos</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">

							<div class="col-md-12">
								<table class="table table-bordered">
									<tr>
										<th style="width: 100px">Código</th>
										<th>Descrição</th>
										<th style="width: 70px">Qtd.</th>
										<th style="width: 100px">Preço</th>
										<th style="width: 130px">Total</th>
									</tr>
									<c:forEach items="${pedido.itens}" var="item">
										<tr>
											<td>${item.produto.codigoProduto}</td>
											<td>${item.produto.nome}</td>
											<td>${item.quantidade}</td>
											<td>R$ ${item.valor}</td>
											<td>R$ ${item.total}</td>
										</tr>

										<script>writeTotal(${item.total})</script>
									</c:forEach>
								</table>
							</div>

							<div class="col-md-3 pull-right">

								<table class="table table-bordered">
									<tr>
										<th style="width: 150px">VALOR TOTAL:</th>
										<td>R$ <span id="td-total">0</span></td>
									</tr>
								</table>

							</div>
							<!-- /.div col -->
						</div>
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
	<!-- Select2 -->
	<link rel="stylesheet" href="resources/plugins/select2/select2.min.css">
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