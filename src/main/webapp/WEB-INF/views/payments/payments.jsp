<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
		
			<h4 class="text-center text-primary ">PAGAMENTOS 
				<c:choose>
				    <c:when test="${validatePayment}">
				        VÁLIDOS
				        <br />
				    </c:when>    
				    <c:otherwise>
				        INSPIRADOS
				        <br />
				    </c:otherwise>
				</c:choose>
			</h4>
			
			
				<c:if test="${not empty msgSucesso}">
						<div class="alert alert-success mt-2" role="alert">
							<c:out value="${msgSucesso}" />
						</div>
					</c:if>	
					<c:if test="${not empty errorSucesso}">
						<div class="alert alert-danger mt-2" role="alert">
							<c:out value="${errorSucesso}" />
						</div>
				</c:if>				
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead class="thead-light">
						<tr>
							<th scope="col">NOME</th>
							<th scope="col">DATA PAG</th>	
						    <th scope="col">INICIO</th>							
							<th scope="col">VÁLIDO</th>
							<th scope="col">VALOR</th>
							<th scope="col">PACOTE</th>	
							<th scope="col">UPDADE</th>									
							<th scope="col">APAGAR</th>	
																										
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${payments}" var="payment">
							<tr>
								<td>
								<c:out value="${payment.customer.nomeCompleto}" />
								</td>
								
								<td>
								<c:out value="${payment.paymentdate}" />
								</td>
								
								<td>
								<c:out value="${payment.initialDate}" />
								</td>
								<td>
								<c:out value="${payment.lastDayOfValidPaymentDate}" />
								</td>
								<td>
								<c:out value="${payment.amount}" />
								</td>
								
								<td>
								<c:out value="${payment.paymentType }" />
								</td>
								
								<td>
									<form method="post"
										action="<c:url value='/payments/update/${payment.id}' />">
										<input type="hidden" name="_method" value=GET>
										<input type="hidden" name="id" value="${payment.id}">
										
										<button type="submit" class="btn btn-info  btn-sm"">
											<span class="glyphicon glyphicon-pencil"></span> Editar
										</button>
									</form>
								</td>
						 	  <td>
									<form method="post"
										action="<c:url value='/payments/${payment.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${payment.id}">
										
										<button type="submit" class="btn btn-danger  btn-sm">
											<span class="glyphicon glyphicon-trash  btn-sm""></span> Apagar
										</button>
									</form>
								</td>
							</tr> 
						</c:forEach>
					</tbody>
				</table>
				
					<a href="<c:url value='/payments/form' />"
					class="btn btn-primary margin-top btn-sm">Pagar</a>
					
					
					<a href="<c:url value='/payments/inspiredPayment' />"
					class="btn btn-danger margin-top btn-sm">Pag vencidos</a>
					
						
					<a href="<c:url value='/customers' />"
					class="btn btn-primary margin-top  btn-sm"">Clientes</a>
			</div>
		</div>
	</jsp:body>
</custom:template>
