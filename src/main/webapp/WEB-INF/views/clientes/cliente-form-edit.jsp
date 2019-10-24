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
			
				<form:form method="POST" modelAttribute="cliente"
				action="/gym/clientes/update">
				
			  <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
					<div class="form-group col-md-12">
					
						<form:hidden path="id" />
						</div>
					
		
			 <div class="form-row">
				<div class="form-group col-md-12">
					<label for="autor">Nome Completo</label>
					<form:input path="nomeCompleto" name="nomeCompleto"
							class="form-control" required="required" />
				</div>
				<div class="form-group col-md-4">
					<label for="autor">Numero De BI</label>
					<form:input path="numeroBI" name="numeroBI" class="form-control"
							required="required" />
				</div>
				  <div class="form-group col-md-4">
					<label for="autor">Naturalidade</label>
					<form:input path="naturalDe" name="naturalDe" class="form-control"
							required="required" />
				</div>
						<div class="form-group col-md-4">
					<label for="autor">Profissao</label>
					<form:input path="profissao" name="profissao" class="form-control" />
				</div>
				<div class="form-group col-md-4">
					<label for="autor">Contacto</label>
					<form:input path="contacto" name="contacto" class="form-control"
							required="required" />
				</div>
				<div class="form-group col-md-8">
					<label for="autor">Email</label>
					<form:input path="email" name="email" class="form-control" />
				</div>
				<div class="form-group col-md-6">
					<label for="autor">Residencia</label>
					<form:input path="residencia" name="residencia"
							class="form-control" required="required" />
				</div>
				<div class="form-group col-md-6">
					<label for="autor">Local de Trabalho</label>
					<form:input path="localDeTrabalho" name="localDeTrabalho"
							class="form-control" required="required" />
				</div>
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Nascimento</label>
					<form:input path="dataDeNascimento" name="dataDeNascimento"
							class="form-control" placeholder="dd/MM/YYYY" />
				</div>
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Inicio</label>
					<form:input path="dataDeInicio" name="dataDeInicio"
							class="form-control" placeholder="dd/MM/YYYY" />
				</div>  
	            <div class="form-group col-md-12">
				<input type="submit" value="Gravar" class="btn btn-primary" />
				<a href="<c:url value='/clientes' />" class="btn btn-default">Cancelar</a>
				</div>
				</div>
			</form:form>
		</div>
	</jsp:body>
</custom:template>
