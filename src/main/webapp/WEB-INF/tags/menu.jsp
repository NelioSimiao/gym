<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<div class="navbar-header">

			<!-- <a class="navbar-brand" href="<c:url value='/' />">NANDO'S GYM </a> -->
		</div>


		<div class="collapse navbar-collapse" id="menu">

			<sec:authorize access="!isAuthenticated()">
				<ul class="nav navbar-nav navbar-left">

					<li>
					<a href="<c:url value='/login' />">Login</a>
					</li>
				</ul>
			</sec:authorize>


			<sec:authorize access="isAuthenticated()">
				<a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Administração </a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="<c:url value='/clientes'/>">
							Clientes </a> <a class="dropdown-item"
							href="<c:url value='/clientes'/>"> Pagamentos </a>
					</div>
			</sec:authorize>


			<sec:authorize access="isAuthenticated()">

				<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">

					<ul class="navbar-nav ml-auto">
						<li class="nav-item">
							<form method="post" action="<c:url value='/logout' />">
								<button class="btn btn-light text-primary">Sair</button>
							</form>
						</li>

					</ul>
				</div>


			</sec:authorize>

		</div>
	</div>
</nav>
