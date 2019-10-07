<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Lista de Movimentações</title>
</head>
<body>
	<h2>Lista de Movimentações</h2>
	<h3>
		<a href="<c:url value="/movimentacoes/form" />">Criar nova
			movimentação</a>
	</h3>
	<br>
	<br>
	<table>
		<thead>
			<tr>
				<th>
					<h3>Receitas</h3>
				</th>
				<th>
					<h3>Despesas</h3>
				</th>
			</tr>
		<tbody>
			<tr>
				<td valign="top">
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>CATEGORIA</th>
								<th>DATA</th>
								<th>VALOR (R$)</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="movimentacao"
								items="${listaMovimentacoesReceita}">
								<tr>
									<td>${movimentacao.categoria.nome}</td>
									<td>${movimentacao.dataHoraString}</td>
									<td align="right"><fmt:formatNumber
											value="${movimentacao.valor}" type="currency" /></td>
									<td><a
										href="<c:url value="/movimentacoes/edit/${movimentacao.id}" />">
											<button type="button" class="btn btn-outline-warning btn-sm">Editar</button>
									</a> <a
										href="<c:url value="/movimentacoes/delete/${movimentacao.id}" />">
											<button type="button" class="btn btn-outline-danger btn-sm">Excluir</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot bgcolor="#808080">
							<tr>
								<td></td>
								<td></td>
								<td align="right"><fmt:formatNumber
										value="${valorTotalReceitas}" type="currency" /></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</td>
				<td valign="top">
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>CATEGORIA</th>
								<th>DATA</th>
								<th>VALOR (R$)</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="movimentacao"
								items="${listaMovimentacoesDespesa}">
								<tr>
									<td>${movimentacao.categoria.nome}</td>
									<td>${movimentacao.dataHoraString}</td>
									<td align="right"><fmt:formatNumber
											value="${movimentacao.valor}" type="currency" /></td>
									<td><a
										href="<c:url value="/movimentacoes/edit/${movimentacao.id}" />">
											<button type="button" class="btn btn-outline-warning btn-sm">Editar</button>
									</a> <a
										href="<c:url value="/movimentacoes/delete/${movimentacao.id}" />">
											<button type="button" class="btn btn-outline-danger btn-sm">Excluir</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot bgcolor="#808080">
							<tr>
								<td></td>
								<td></td>
								<td align="right"><fmt:formatNumber
										value="${valorTotalDespesas}" type="currency" /></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</td>
			</tr>
		</tbody>
	</table>

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