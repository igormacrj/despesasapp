<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css" />">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Adicionar Movimentação</title>
</head>
<body>
	<h2>Adicionar Movimentação</h2>
	<form action="<c:url value="/movimentacoes/add" />" method="post">
		<table>
			<tr>
				<td> <label for="nome">Categoria</label> </td>
				<td> 
					<select name="idCategoria" id="categoria">
    					<c:forEach var="categoria" items="${listaCategorias}">
        					<option value="${categoria.id}">${categoria.nome}</option> 
    					</c:forEach>
					</select>									
				</td>
			</tr>
			<tr>
				<td><label for="tipo">Valor(R$)</label></td>
 				<td>
 				<input type="text" value="${movimentacao.valor}" name="valor" id="valor" size="10">
 				</td>
			</tr>
		</table>
		<br /> 
		<input type="submit" value="Salvar">
	</form>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>