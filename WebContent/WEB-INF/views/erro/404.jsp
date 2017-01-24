<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>

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
            Página não encontrada
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Página não encontrada</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="error-page">
            <h2 class="headline text-yellow"> 404</h2>
            <div class="error-content">
              <h3><i class="fa fa-warning text-yellow"></i> Oops! Página não encontrada.</h3>
              <p>
                Não foi possível encontrar a página que você estava procurando.
                Enquanto isso, você pode <a href="dashboard">retornar para a dashboard</a>
              </p>
            </div><!-- /.error-content -->
          </div><!-- /.error-page -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

	<%@ include file="../estrutura/rodape.jspf"%>
	
</body>
</html>