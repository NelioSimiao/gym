<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<custom:template title="Processos cadastradas">
	<jsp:body>
		<div class="container">
			<h3 class="text-center">Clientes </h3>
			
			<a href="<c:url value='/clientes/form' />" class="btn btn-primary">Novo</a>
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>Nome Completo</th>
							<th>Número BI</th>	
							<th>Contacto</th>
							<th>Profissão</th>
							<th>Residencia</th>																					
							<th>Inscrição</th>
							<th>Inicio</th>	
							<th>Actualizar</th>												
							<th>Remover</th>								
												
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
			</div>
		</div>
	</jsp:body>
</custom:template>
