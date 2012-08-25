<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cliente: ${pedido.nome_cliente }</h1> 
	<h1>Data: ${pedido.data }</h1> 
	<h1>Total: R$${pedido.valor_total }</h1> 
	<table>
		<thead>
			<tr>
				<th>Descrição do item</th>
				<th>Quantidade</th>
				<th>Valor unitário</th>
				<th>Valor total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pedido.lista}" var="item">
				<tr>
					<td>${item.nome }</td>
					<td>${item.quantidade }</td>
					<td>${item.valor_unitario }</td>
					<td>${item.valor_total }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>