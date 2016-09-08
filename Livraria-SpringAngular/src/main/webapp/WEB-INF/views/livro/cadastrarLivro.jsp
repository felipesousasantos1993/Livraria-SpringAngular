<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE>
<html ng-app="cadastrarControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>

<style type="text/css">
label {
	display: inline-block;
	width: 90px;
}
</style>
<script type="text/javascript" src="../resources/js/angular.min.js"></script>
<script type="text/javascript" src="../resources/js/livro/cadastrarLivroController.js"></script>


</head>
<body>

	<form ng-controller="cadastrarController">

		<h2>Cadastrar Livro</h2>
		<br />

		<label for="input-nome">Título:</label>
		<input type="text" id="input-nome" style="width: 220px;" ng-model="deTitulo" />

		<br /> <br />

		<label for="input-login">Ano Publicação:</label>
		<input type="text" id="input-login" style="width: 120px;" ng-model="aaPublicacao" />

		<br /> <br />

		<label for="input-senha">Autor:</label>
		<input type="text" id="input-senha" style="width: 120px;" ng-model="deAutor" />

		<br /> <br />
		<label for="input-senha">Editora:</label>
		<input type="text" id="input-senha" style="width: 120px;" ng-model="deEditora" />

		<br /> <br />

		<label for="input-senha">Edição:</label>
		<input type="text" id="input-senha" style="width: 120px;" ng-model="deEdicao" />

		<br /> <br />

		<label for="input-registroAtivo">Ativo:</label>
		<input type="checkbox" id="input-registroAtivo" ng-model="ativo" />

		<br /> <br />


		<p>
			<a href="../">Voltar</a>

			<input type="button" value="Salvar" ng-click="salvarLivro()" />

		</p>


	</form>



</body>
</html>