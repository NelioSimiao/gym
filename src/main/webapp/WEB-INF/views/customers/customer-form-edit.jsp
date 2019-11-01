<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<custom:template title="Cadastrar novo Processo">
	<jsp:body>
		<div class="container">
		
		
			<h3 class="text-center">Actualizar dados Cliente</h3>
			
				<c:if test="${param.error ne null}">
					<div class="alert alert-danger">
						<p>Dados inválidos!</p>
					</div>
		        </c:if>
			
				<form:form method="POST" modelAttribute="customer"
				action="/gym/customers/update">
				
			  <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
					<div class="form-group col-md-12">
					
						<form:hidden path="id" />
						</div>
					
		
			 <div class="form-row">
				<div class="form-group col-md-12">
					<label for="autor">Nome Completo</label>
					<form:input path="nomeCompleto" name="nomeCompleto"
							class="form-control" data-error="enter valid username" />
					<form:errors path="nomeCompleto" cssClass="error" />
				</div>
				
				
				<div class="form-group col-md-4">
					<label for="autor">BI</label>
					<form:input path="numeroBI" name="numeroBI" class="form-control"
							data-error="enter valid username" />
				     <form:errors path="numeroBI" cssClass="error" />
				</div>
				
				 <div class="form-group col-md-4">
					<label for="autor">Naturalidade</label>
					<form:input path="naturalDe" name="naturalDe" class="form-control" />
					<form:errors path="naturalDe" cssClass="error" />
				</div>
				
				 
				 <div class="form-group col-md-4">
					<label for="autor">Profissão</label>
					<form:input path="profissao" name="profissao" class="form-control" />
						<form:errors path="profissao" cssClass="error" />
				</div>
				
				<div class="form-group col-md-4">
					<label for="autor">Contacto</label>
					<form:input path="contacto" name="contacto" class="form-control" />
					<form:errors path="contacto" cssClass="error" />
				</div>
				
				<div class="form-group col-md-8">
					<label for="autor">Email</label>
					<form:input path="email" name="email" class="form-control" />
					<form:errors path="email" cssClass="error" />
					
				</div>
				
				<div class="form-group col-md-6">
					<label for="autor">Residencia</label>
					<form:input path="residencia" name="residencia"
							class="form-control" />
					<form:errors path="residencia" cssClass="error" />
				</div>
				
				
				<div class="form-group col-md-6">
					<label for="autor">Local de Trabalho</label>
					<form:input path="localDeTrabalho" name="localDeTrabalho"
							class="form-control" />
					<form:errors path="localDeTrabalho" cssClass="error" />
				</div>
				
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Nascimento</label>
					<form:input path="dataDeNascimento" name="dataDeNascimento"
							class="form-control" placeholder="dd/MM/YYYY" />
					<form:errors path="dataDeNascimento" cssClass="error" />
				</div>
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Inicio</label>
					<form:input path="dataDeInicio" name="dataDeInicio"
							class="form-control" placeholder="dd/MM/YYYY" />
					<form:errors path="dataDeInicio" cssClass="error" />
				</div>  
				
	            <div class="form-group col-md-12">
				<input type="submit" value="Gravar" class="btn btn-primary" />
				<a href="<c:url value='/customers' />" class="btn btn-default">Cancelar</a>
				</div>
				</div>
			</form:form>
		</div>
	</jsp:body>
</custom:template>
