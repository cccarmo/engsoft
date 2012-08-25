<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>titulo legal</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nome do cliente</th>
				<th>Data da compra</th>
				<th>Total de itens</th>
				<th>Valor total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pedidoList}" var="pedido">
				<tr>
					<td>${pedido.nome_cliente }</td>
					<td>${pedido.data }</td>
					<td>${pedido.total_itens }</td>
					<td>${pedido.valor_total }</td>
					<td><a href="lista_item?id=${pedido.id }">Listar itens</a></td>
					<td><a href="remove?id=${pedido.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>