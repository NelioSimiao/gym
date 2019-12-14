<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<custom:template title="Cadastrar novo Processo">
	<jsp:body>
		<div class="container">
			<h4 class="text-center text-primary  ">PAGAMENTOS</h4>
			
		  <form:form method="POST" modelAttribute="payment"
				action="/gym/payments/add">
		
				 <div class="form-row">
				 
				 
				 	  <div class="form-group col-md-12">
					
						<form:hidden path="id" />
						</div>
					 
							<div class="form-group col-md-8">
							    <label for="cargo">Clientes</label>
							    
								<form:select path="customer" name="customer.id" class="form-control">
									<c:forEach items="${customers}" var="customer">
										<form:option value="${customer.id}">${customer.nomeCompleto}</form:option>
									</c:forEach>
								</form:select>
							</div>
							
							
							<div class="form-group col-md-4">
							    <label for="cargo">Tipo de Pagamento</label>
							    
								<form:select path="paymentType" name="paymentType" class="form-control">
									<c:forEach items="${paymentTypes}" var="paymentType">
										<form:option value="${paymentType}">${paymentType}</form:option>
									</c:forEach>
								</form:select>
							</div>
							
							 <div class="form-group col-md-4">
								<label for="amount">Tipo de pagamento</label>	   
								<form:select path="paymentMethod" name="paymentMethod" class="form-control">
									<c:forEach items="${paymentMethods}" var="paymentMethod" >
										<form:option value="${paymentMethod}"> ${paymentMethod} </form:option>
									</c:forEach>
								</form:select>
							 </div>
			
						  <div class="form-group col-md-6">
						     <label for="descricao">Data de Inicio</label>
								<div class="input-group date" data-provide="datepicker">
				                      <form:input path="initialDate" name="initialDate" type="text" class="form-control"
				                      placeholder="dd/MM/YYYY" data-date-format='yyyy-MM-dd' />
				                       <div class="input-group-addon">
				                      <span class="glyphicon glyphicon-trash"></span>
				                    </div>
				                    
				                 </div>
				              	<small>   <form:errors path="initialDate" cssClass="error" />	</small>
					    </div>
							
							 
						
				          <div class="form-group col-md-12">
							<input type="submit" value="Pagar" class="btn btn-primary">
							<a href="<c:url value='/payments' />" class="btn btn-default">Cancelar</a>
						 </div>	

					</div>
			</form:form>
		</div>

	</jsp:body>
</custom:template>
