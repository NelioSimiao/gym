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
			
		  <form:form method="POST" modelAttribute="customer"
				action="/gym/customers/add">
						
				<div ${msg}class="alert alert-sucess"></div>
		
				 <div class="form-row">
				 
				 
				 	<div class="form-group col-md-12">
					
						<form:hidden path="id" />
						</div>
				 
						    <div class="form-group col-md-12">
								<label for="autor">Nome </label>
							    <form:input path="nomeCompleto" id="nomeCompleto"
							class="form-control" placeholder="Nome Completo" />	
							<small> <form:errors path="nomeCompleto" cssClass="error" /></small>
							</div>
														
							<div class="form-group col-md-4">
								<label for="autor">BI</label>
								<form:input path="numeroBI" name="numeroBI" class="form-control"
							placeholder="Número de BI" />
								<small><form:errors path="numeroBI" cssClass="error" /></small>
								
							</div>
							
							
							 <div class="form-group col-md-4">
								<label for="autor">Naturalidade</label>
								<form:input path="naturalDe" name="naturalDe"
							class="form-control" placeholder="Naturalidade" />
							<small>	<form:errors path="naturalDe" cssClass="error" /></small>
							 </div>
							 
							
							 <div class="form-group col-md-4">
								<label for="autor">Profissão </label>
								<form:input path="profissao" name="profissao"
							class="form-control" placeholder="Profissão" />
							<small>	<form:errors path="profissao" cssClass="error" /></small>
							 </div>
							 
							
							<div class="form-group col-md-4">
								<label for="autor">Contacto </label>
								<form:input path="contacto" name="contacto" class="form-control"
							placeholder="Contacto" />
							<small>	<form:errors path="contacto" cssClass="error" /></small>
							</div>
							
							
							<div class="form-group col-md-8">
								<label for="autor">Email</label>
								<form:input path="email" name="email" class="form-control"
							placeholder="Email" />
								<small>	<form:errors path="email" cssClass="error" /></small>
							</div>
							
							
							<div class="form-group col-md-6">
								<label for="autor">Residencia</label>
								<form:input path="residencia" name="residencia"
							class="form-control" placeholder="Residencia" />
							<small>	<form:errors path="residencia" cssClass="error" /></small>
							</div>
							
							<div class="form-group col-md-6">
								<label for="autor">Local de Trabalho</label>
								<form:input path="localDeTrabalho" name="localDeTrabalho"
							class="form-control" placeholder="Residencia" />
							<small>	<form:errors path="localDeTrabalho"
								cssClass="error" /></small>
							 </div>
							 
							
							<div class="form-group col-md-6">
						     <label for="descricao">Data de Nascimento</label>
								<div class="input-group date" data-provide="datepicker">
				                      <form:input path="dataDeNascimento"
								name="dataDeNascimento" type="text" class="form-control"
								placeholder="dd/MM/YYYY" data-date-format='yyyy-MM-dd' />
				                       <div class="input-group-addon">
				                      <span class="glyphicon glyphicon-trash"></span>
				                    </div>
				                 </div>
				              <small>   <form:errors path="dataDeNascimento"
								cssClass="error" /></small>
							</div>
							
							
						  <div class="form-group col-md-6">
						     <label for="descricao">Data de Inicio</label>
								<div class="input-group date" data-provide="datepicker">
				                      <form:input path="dataDeInicio"
								name="dataDeInicio" type="text" class="form-control"
								placeholder="dd/MM/YYYY" data-date-format='yyyy-MM-dd' />
				                       <div class="input-group-addon">
				                      <span class="glyphicon glyphicon-trash"></span>
				                    </div>
				                    
				                 </div>
				                <small> <form:errors path="dataDeInicio"
								cssClass="error" /></small>
							</div>
							
			
				          <div class="form-group col-md-12">
							<input type="submit" value="Gravar" class="btn btn-primary  btn-sm">
							<a href="<c:url value='/customers' />" class="btn btn-secondary  btn-sm">Cancelar</a>
						 </div>
					</div>
					
			</form:form>
		</div>
		
		
	<script type="text/javascript">
		$('.datepicker').datepicker({
			format : 'yyyy-MM-dd',
			startDate : '+0d',
			language : 'pt-BR'
		});
	</script>
	
	</jsp:body>
</custom:template>
