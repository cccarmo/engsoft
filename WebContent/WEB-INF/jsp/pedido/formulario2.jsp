<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adiciona_item">
		<fieldset>
			<legend>Adicionar item no pedido de ${pedido.nome_cliente }</legend>
			<label for="nome">Item:</label> <input id="nome"
				type="text" name="nome_Produto" /> <label for="quantidade">Quantidade:</label>
			<input id="quantidade" type="text" name="quantidade" /> <label
				for="valor_unitario">Valor unitario:</label> <input id="valor_unitario" type="text"
				name="valor_unitario" />
				
				<input type="hidden" name="id" value="${pedido.id }" />
				
				
			<button type="submit">Cadastrar item no pedido</button>
		</fieldset>
	</form>
	<form action="lista_pedido">
		<fieldset>
					
				
			<button type="submit">Terminar cadastro</button>
		</fieldset>
	</form>
</body>
</html>