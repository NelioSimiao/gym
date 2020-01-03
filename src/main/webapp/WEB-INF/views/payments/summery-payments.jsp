<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<custom:template title="Resumos">
	<jsp:body>
	
		<div class="container">
			
			<div class="table-responsive">
				<table class="table table-stripped table-hover">
					<thead class="thead-light">
						<tr>
							<th scope="col">DESCRIÇÂO</th>
							<th scope="col">VALORES</th>												
						</tr>
					</thead>
					
					<tbody>
						<!--<c:forEach items="${payments}" var="payment">
							<tr>
								<td>
								<c:out value="${payment.customer.nomeCompleto}" />
								</td>
								
								<td>
								<c:out value="${validatePayment}" />
								</td>
							</tr> 
						</c:forEach>-->
						
					</tbody>
				</table>
			
			</div>
		</div>
	</jsp:body>
</custom:template>
