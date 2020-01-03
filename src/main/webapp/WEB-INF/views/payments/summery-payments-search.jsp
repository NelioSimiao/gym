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
			
			<form method="post" action="<c:url value='/summarise' />">
			
				<div class="form-group">
					<label for="ano">Ano</label>
					<input id="ano" name="ano" class="form-control" required="required">
				</div>
				
			<input type="submit" value="Logar" class="btn btn-primary">
		    </form>
				
			</div>
		</div>
	</jsp:body>
</custom:template>
