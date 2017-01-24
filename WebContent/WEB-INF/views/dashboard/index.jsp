<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>WISold</title>
<%@ include file="../estrutura/head.jspf" %>
</head>
<body class="skin-blue-light fixed sidebar-mini  sidebar-mini wysihtml5-supported skin-blue">
  
  <%@ include file="../estrutura/cabecalho.jspf" %>
  
  <!-- content-wrapper  -->
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
            <small>DETALHES DO SISTEMA </small>
          </h1>
          <ol class="breadcrumb">
            <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
   
   Construção

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      
      <%@ include file="../estrutura/rodape.jspf" %>

    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script type="text/javascript">
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="<c:url value="/resources/plugins/morris/morris.min.js" />" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="<c:url value="/resources/plugins/sparkline/jquery.sparkline.min.js" />" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" />" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value="/resources/plugins/knob/jquery.knob.js" />" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js" type="text/javascript"></script>
    <script src="<c:url value="/resources/plugins/daterangepicker/daterangepicker.js" />" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="<c:url value="/resources/plugins/datepicker/bootstrap-datepicker.js" />" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" />" type="text/javascript"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value="/resources/dist/js/pages/dashboard.js" />" type="text/javascript"></script>
  </body>
</html>