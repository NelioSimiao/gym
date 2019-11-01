<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
		
			<h4 class="text-center text-primary ">PAGAMENTOS </h4>
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead class="thead-light">
						<tr>
							<th scope="col">CLIENTE</th>
							<th scope="col">DATA PAG</th>	
							<th scope="col">VÀLIDO</th>
							<th scope="col">VALOR</th>
							<th scope="col">MODALIDADE</th>																					
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
								<c:out value="${payment.lastDayOfValidPaymentDate}" />
								</td>
								<td>
								<c:out value="${payment.amount}" />
								</td>
								
								<td>
								<c:out value="${payment.paymentType }" />
								</td>
							<!--  	<td>
									<form method="post"
										action="<c:url value='/customers/actualizar/${customer.id}' />">
										<input type="hidden" name="_method" value=GET>
										<input type="hidden" name="id" value="${customer.id}">
										
										<button type="submit" class="btn btn-info">
											<span class="glyphicon glyphicon-pencil"></span> Editar
										</button>
									</form>
								</td>
								<td>
									<form method="post"
										action="<c:url value='/customers/${customer.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${customer.id}">
										
										<button type="submit" class="btn btn-danger">
											<span class="glyphicon glyphicon-trash"></span> Remover
										</button>
									</form>
								</td>
							</tr> -->
						</c:forEach>
					</tbody>
				</table>
				
				
					<a href="<c:url value='/payments/form' />" class="btn btn-primary margin-top">Pagar</a>
			</div>
		</div>
	</jsp:body>
</custom:template>
