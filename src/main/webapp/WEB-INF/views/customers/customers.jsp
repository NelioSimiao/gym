<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
		
			<h4 class="text-center text-primary ">CLIENTES </h4>
			
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
							<th scope="col">Nome Completo</th>
							<th scope="col">Número BI</th>	
							<th scope="col">Contacto</th>
							<th scope="col">Profissão</th>
							<th scope="col">Residencia</th>																					
							<th scope="col">Inscrição</th>
							<th scope="col">Inicio</th>	
							<th scope="col">Actualizar</th>												
							<th scope="col">Remover</th>	
														
												
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td>
								<c:out value="${customer.nomeCompleto }" />
								</td>
								
								<td>
								<c:out value="${customer.numeroBI }" />
								</td>
								<td>
								<c:out value="${customer.contacto }" />
								</td>
								<td>
								<c:out value="${customer.profissao }" />
								</td>
								<td>
								<c:out value="${customer.residencia }" />
								</td>
								
								<td>
								<c:out value="${customer.dataDeInscricaoFormatada() }" />
								</td>
								<td>
								<c:out value="${customer.dataDeInicioFormatada() }" />
								</td>
								<td>
									<form method="post"
										action="<c:url value='/customers/actualizar/${customer.id}' />">
										<input type="hidden" name="_method" value=GET>
										<input type="hidden" name="id" value="${customer.id}">
										
										<button type="submit" class="btn btn-info  btn-sm"">
											<span class="glyphicon glyphicon-pencil"></span> Editar
										</button>
									</form>
								</td>
								<td>
									<form method="post"
										action="<c:url value='/customers/${customer.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${customer.id}">
										
										<button type="submit" class="btn btn-danger  btn-sm">
											<span class="glyphicon glyphicon-trash  btn-sm""></span> Apagar
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			
	     	    <p class="text-right text-primary">Número total dos Clientes : <c:out
						value="${totalCustomers}" /> </p>
		   	   <hr>
		
			<br>
				
				
				
					<a href="<c:url value='/customers/form' />"
					class="btn btn-primary margin-top  btn-sm">Novo</a>
					
						<a href="<c:url value='/payments' />"
					class="btn btn-primary margin-top btn-sm">Pagamentos</a>
					
					
					
			</div>
		</div>
	</jsp:body>
</custom:template>
