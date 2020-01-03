<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<custom:template title="Cadastrar novo Processo">
	<jsp:body>
		<div class="container">
			<h4 class="text-center text-primary  ">Cadastrar novo Cliente</h4>
			
		  <form:form method="POST" modelAttribute="engineUser"
				action="/gym/engineUsers/add">
						
				<div ${msg} class="alert alert-sucess"></div>
		
				 <div class="form-row">
				 
				 
				 	<div class="form-group col-md-12">
					
						<form:hidden path="id" />
						</div>
				 
						    <div class="form-group col-md-12">
								<label for="autor">Nome </label>
							    <form:input path="nome" id="nome" class="form-control"
							placeholder="Nome " />	
							<small> <form:errors path="nome" cssClass="error" /></small>
							</div>
														
							<div class="form-group col-md-6">
								<label for="autor">Login</label>
								<form:input path="login" class="form-control"
							placeholder="Login" />
								<small><form:errors path="login" cssClass="error" /></small>
								
							</div>
											
							 <div class="form-group col-md-6">
								<label for="autor">Password</label>
								<form:input path="senha" class="form-control"
							placeholder="Senha" autocomplete="off" />
							<small>	<form:errors path="senha" cssClass="error" /></small>
							 </div>
						
			
				          <div class="form-group col-md-12">
							<input type="submit" value="Gravar"
							class="btn btn-primary  btn-sm">
							<a href="<c:url value='/engineUsers' />"
							class="btn btn-secondary  btn-sm">Cancelar</a>
						 </div>
						
					
			</form:form>
		</div>
	
	</jsp:body>
</custom:template>
