<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Indústrias</title>

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
			Indústrias <small>LISTA DE INDÚSTRIAS</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><a href="#"><i class="fa fa-dashboard"></i> Indústrias</a></li>
		</ol>
		</section>
		
		<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-xs-12">
			
			<c:if test="${not empty mensagem}">
			<div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                     <p>${mensagem}</p>
                  </div>
		</c:if>
		
				<div class="box box-primary">
					<!-- /.box-header -->
					<div class="box-body">
						<table id="tabela" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Nome Fantasia</th>
									<th>Razão Social</th>
									<th>CNPJ</th>
									<th>E-mail</th>
									<th>Telefone</th>
									<th>Comissão (%)</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="industria" items="${industrias}">
									<tr>
										<td>${industria.nomeFantasia}</td>
										<td>${industria.razaoSocial}</td>										
										<td>${industria.cnpj}</td>
										<td>${industria.email}</td>
										<td>${industria.telefone}</td>
										<td>${industria.comissao}</td>
										<td><a class="btn .btn-xs"
											href="alterarIndustria?id=${industria.id}"> <i
												class="fa fa-edit"></i> Visualizar
										</a> <a class="btn .btn-xs" href="excluirIndustria?id=${industria.id}">
												<i class="fa  fa-trash"></i> Excluir
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>Nome Fantasia</th>
									<th>Razão Social</th>
									<th>CNPJ</th>
									<th>E-mail</th>
									<th>Telefone</th>
									<th>Comissão (%)</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
							<a class="btn btn-primary pull-right" href="cadastrarIndustria">Cadastrar novo</a>
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

	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			$("#tabela").DataTable();

		});
	</script>
</body>
</html>