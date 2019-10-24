<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
		
			<h4 class="text-center text-primary ">Clientes </h4>
			
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
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>
								<c:out value="${cliente.nomeCompleto }" />
								</td>
								
								<td>
								<c:out value="${cliente.numeroBI }" />
								</td>
								<td>
								<c:out value="${cliente.contacto }" />
								</td>
								<td>
								<c:out value="${cliente.profissao }" />
								</td>
								<td>
								<c:out value="${cliente.residencia }" />
								</td>
								
								<td>
								<c:out value="${cliente.dataDeInscricaoFormatada() }" />
								</td>
								<td>
								<c:out value="${cliente.dataDeInicioFormatada() }" />
								</td>
								<td>
									<form method="post"
										action="<c:url value='/clientes/actualizar/${cliente.id}' />">
										<input type="hidden" name="_method" value=GET>
										<input type="hidden" name="id" value="${cliente.id}">
										
										<button type="submit" class="btn btn-info">
											<span class="glyphicon glyphicon-pencil"></span> Editar
										</button>
									</form>
								</td>
								<td>
									<form method="post"
										action="<c:url value='/clientes/${cliente.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${cliente.id}">
										
										<button type="submit" class="btn btn-danger">
											<span class="glyphicon glyphicon-trash"></span> Remover
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
					<a href="<c:url value='/clientes/form' />" class="btn btn-primary margin-top">Novo</a>
			</div>
		</div>
	</jsp:body>
</custom:template>
