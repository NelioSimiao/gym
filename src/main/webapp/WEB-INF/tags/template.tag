<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="title" required="true"%>
<%@ attribute name="extraStyles" fragment="true"%>
<%@ attribute name="extraScripts" fragment="true"%>

<fmt:setLocale value="pt-BR" scope="session" />

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>${title}</title>

<link rel="stylesheet"
	href="<c:url value='/assets/vendor/bootstrap/css/bootstrap.min.css' />">

<link rel="stylesheet"
	href="<c:url value='/assets/vendor/bootstrap/css/bootstrap-datepicker.css' />">

<link rel="stylesheet" href="<c:url value='/assets/css/style.css' />">

<!-- Puxa os outros estilos especificos da pagina -->
<jsp:invoke fragment="extraStyles" />
</head>

<body data-msg="${msg}">
	<c:import url="/WEB-INF/tags/menu.jsp" />

	<div class="container">
		<jsp:doBody />
		<hr>
		<p class="text-right text-primary">by SW Solutions</p>
	</div>

	<script type="text/javascript"
		src="<c:url value='/assets/vendor/jquery/jquery-3.4.1.min.js' />"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/vendor/bootstrap/bootstrap.min.js' />"></script>


	<script type="text/javascript"
		src="<c:url value='/assets/vendor/bootstrap/bootstrap-datepicker.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/vendor/bootstrap/bootstrap-datepicker.pt.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/vendor/bootstrap/bootstrap-datepicker.pt-BR.min.js' />"></script>

	<script type="text/javascript"
		src="<c:url value='/assets/js/mensagens.js' />"></script>



	<!--	 Puxa os scripts especificos da pagina -->
	<jsp:invoke fragment="extraScripts" />
</body>
</html>
