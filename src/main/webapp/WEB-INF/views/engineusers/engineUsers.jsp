<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<custom:template title="Usuarios do Sistema">
	<jsp:body>
		<div class="container">
		
			<h4 class="text-center text-primary ">Usuarios do Sistema </h4>
			
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
							<th scope="col">Nome</th>
							
							<th scope="col">Email</th>		
							<th scope="col">Actualizar</th>	
							<th scope="col">Apagar</th>													
											
																		
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${engineUsers}" var="engineUser">
							<tr>
								<td>
								<c:out value="${engineUser.nome }" />
								</td>
								
								<td>
								<c:out value="${engineUser.login }" />
								</td>
								<td>
									<form method="post"
										action="<c:url value='/engineUsers/update/${engineUser.id}' />">
										<input type="hidden" name="_method" value=GET>
										<input type="hidden" name="id" value="${engineUser.id}">
										
										<button type="submit" class="btn btn-info  btn-sm"">
											<span class="glyphicon glyphicon-pencil"></span> Editar
										</button>
									</form>
								</td>
								<td>
									<form method="post"
										action="<c:url value='/engineUsers/${engineUser.id}' />">
										<input type="hidden" name="_method" value="DELETE">
										<input type="hidden" name="id" value="${engineUser.id}">
										
										<button type="submit" class="btn btn-danger  btn-sm">
											<span class="glyphicon glyphicon-trash  btn-sm"></span> Apagar
										</button>
									</form>
								</td>
							</tr> 
						</c:forEach>
					</tbody>
				</table>
				
				
					<a href="<c:url value='/engineUsers/add' />"
					class="btn btn-primary margin-top  btn-sm"> Novo Usuário</a>
			</div>
		</div>
	</jsp:body>
</custom:template>
