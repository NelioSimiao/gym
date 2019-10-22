<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<custom:template title="Cadastrar novo Processo">
	<jsp:body>
		<div class="container">
			<h3 class="text-center">Cadastrar novo Cliente</h3>
			
		  <form method="post" action="<c:url value='/clientes' />">
		
			 <div class="form-row">
				<div class="form-group col-md-12">
					<label for="autor">Nome Completo</label>
			
				 <input name="nomeCompleto" id="nomeCompleto" class="form-control"  />
				
				</div>
				<div class="form-group col-md-4">
					<label for="autor">Numero De BI</label>
					<input id="numeroBI" name="numeroBI" class="form-control"
							required="required" <c:out value="${cliente.numeroBI}" /> />
				</div>
				  <div class="form-group col-md-4">
					<label for="autor">Naturalidade</label>
					<input id="naturalDe" name="naturalDe" class="form-control"
							required="required" <c:out value="${cliente.naturalDe}" /> />
				  </div>
						<div class="form-group col-md-4">
					<label for="autor">Profissao</label>
					<input id="profissao" name="profissao" class="form-control"
							<c:out value="${cliente.profissao}" /> />
				</div>
				<div class="form-group col-md-4">
					<label for="autor">Contacto</label>
					<input id="contacto" name="contacto" class="form-control"
							required="required" <c:out value="${cliente.contacto}" /> />
				</div>
				<div class="form-group col-md-8">
					<label for="autor">Email</label>
					<input id="email" name="email" class="form-control"
							<c:out value="${cliente.email}" /> />
				</div>
				<div class="form-group col-md-6">
					<label for="autor">Residencia</label>
					<input id="residencia" name="residencia" class="form-control"
							required="required" <c:out value="${cliente.residencia}" /> />
				</div>
				<div class="form-group col-md-6">
					<label for="autor">Local de Trabalho</label>
					<input id="localDeTrabalho" name="localDeTrabalho"
							class="form-control" required="required"
							<c:out value="${cliente.localDeTrabalho}" /> />
				</div>
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Nascimento</label>
					<input id="dataDeNascimento" name="dataDeNascimento"
							class="form-control" placeholder="dd/MM/YYY"
							<c:out value="${cliente.dataDeNascimento}" /> />
				</div>
				
				<div class="form-group col-md-6">
					<label for="descricao">Data de Inicio</label>
					<input id="dataDeInicio" name="dataDeInicio" class="form-control"
							placeholder="dd/MM/YYY" <c:out value="${cliente.dataDeInicio}" /> />
				</div>  
	            <div class="form-group col-md-12">
				<input type="submit" value="Gravar" class="btn btn-primary">
				<a href="<c:url value='/clientes' />" class="btn btn-default">Cancelar</a>
				</div>
				</div>
			</form>
		</div>
	</jsp:body>
</custom:template>
