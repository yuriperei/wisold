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
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Indústria</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="manterIndustria">
						<div class="box-body">
							<input name="id" type="hidden" value="${industria.id}">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Nome Fantasia</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="nomeFantasia" name="nomeFantasia"
										placeholder="Nome Fantasia" value="${industria.nomeFantasia}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Razão social</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="razaoSocial"
										name="razaoSocial" placeholder="Razão Social" value="${industria.razaoSocial}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">CNPJ</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cnpj" name="cnpj"
										placeholder="CNPJ" value="${industria.cnpj}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">E-mail</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="email"
										name="email" placeholder="E-mail"
										value="${industria.email}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Telefone</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="telefone"
										name="telefone" placeholder="Telefone"
										value="${industria.telefone}">
								</div>
								<label for="inputEmail3" class="col-sm-2 control-label">Comissão (%)</label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="comissao"
										name="comissao" placeholder="Comissão (%)" min="0" max="100" step="0.1"
										value="${industria.comissao}">
								</div>
							</div>
							
							
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="submit" class="btn btn-primary pull-right">Salvar</button>
						</div>
						<!-- /.box-footer -->

					</form>
				</div>
				<!-- /.box -->

			</div>
			<!-- /.col -->


			<div class="col-xs-12">

<c:if test="${not empty mensagem}">
			<div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                     <p>${mensagem}</p>
                  </div>
		</c:if>
		
				<!-- Horizontal Form -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Endereços</h3>
					</div>
					<!-- /.box-header -->

					<c:if test="${not empty industria.enderecos}">
						<div class="box-body">
							<table id="tabela" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Tipo</th>
										<th>Endereço</th>
										<th>Cidade / Estado</th>
										<th>CEP</th>
										<th>Observação</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${industria.enderecos}" var="endereco">
									<tr>
											<td>${endereco.tipo}</td>
											<td>${endereco.rua} - 
											<c:choose>
											<c:when test="${not empty endereco.numero}"> Nº ${endereco.numero}
											</c:when>
											<c:when test="${empty endereco.numero}"> S/Nº
											</c:when>
											</c:choose> <c:if
													test="${not empty endereco.complemento}"> - ${endereco.complemento}</c:if></td>
											<td>${endereco.cidade}/ ${endereco.estado}</td>
											<td>${endereco.cep}</td>
											<td>${endereco.observacao}</td>
											<td><a class="btn .btn-xs"
												href="alterarEndereco?id=${endereco.id}"> <i
													class="fa fa-edit"></i> Visualizar
											</a> <a class="btn .btn-xs"
												href="excluirEndereco?id=${endereco.id}"> <i
													class="fa  fa-trash"></i> Excluir
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- /.box-body -->
						</div>
						<!-- /.if -->
					</c:if>

					<div class="box-footer">
						<a style="${not empty industria.id ? 'display:block' : 'display:none'}" class="btn btn-primary pull-right" href="cadastrarEndereco">Cadastrar novo</a>
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
		 $(function () {
		        //Initialize Select2 Elements
		        $(".select2").select2();

		        //Datemask dd/mm/yyyy
		        $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
		        //Datemask2 mm/dd/yyyy
		        $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
		        //Money Euro
		        $("[data-mask]").inputmask();

		        //Date range picker
		        $('#reservation').daterangepicker();
		        //Date range picker with time picker
		        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
		        //Date range as a button
		        $('#daterange-btn').daterangepicker(
		                {
		                  ranges: {
		                    'Today': [moment(), moment()],
		                    'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
		                    'Last 7 Days': [moment().subtract(6, 'days'), moment()],
		                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
		                    'This Month': [moment().startOf('month'), moment().endOf('month')],
		                    'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		                  },
		                  startDate: moment().subtract(29, 'days'),
		                  endDate: moment()
		                },
		        function (start, end) {
		          $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
		        }
		        );

		        //iCheck for checkbox and radio inputs
		        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
		          checkboxClass: 'icheckbox_minimal-blue',
		          radioClass: 'iradio_minimal-blue'
		        });
		        //Red color scheme for iCheck
		        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
		          checkboxClass: 'icheckbox_minimal-red',
		          radioClass: 'iradio_minimal-red'
		        });
		        //Flat red color scheme for iCheck
		        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
		          checkboxClass: 'icheckbox_flat-green',
		          radioClass: 'iradio_flat-green'
		        });

		        //Colorpicker
		        $(".my-colorpicker1").colorpicker();
		        //color picker with addon
		        $(".my-colorpicker2").colorpicker();

		        //Timepicker
		        $(".timepicker").timepicker({
		          showInputs: false
		        });
		      });
	</script>
</body>
</html>