<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Editar Categoria</title>
</head>
<body>

	<h2>Editar Categoria</h2>
	<form action="<c:url value="/categorias/update" />" method="post">
		<table>
			<tr>
				<td> <label for="nome">Nome</label> </td>
				<td> <input type="text" value="${categoria.nome}" name="nome" id="nome" size="100"> </td>
			</tr>
			<tr>
				<td><label for="tipo">Tipo</label></td>
				<td><select name="tipo" id="tipo">
						<option value="Despesa">Despesa</option>
						<option value="Receita">Receita</option>
					</select></td>
			</tr>
		</table>
		
		<input type="hidden" value="${categoria.id}" name="id" id="id">
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