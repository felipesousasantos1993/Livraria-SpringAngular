var editarLivroControllerApp = angular.module("editarLivroControllerApp", []);

editarLivroControllerApp.controller("editarLivroController", function($scope,
		$window, $http) {

	/* DEFININDO O MODELO PARA O NOSSO FORMULÁRIO */
	$scope.deTitulo = null;
	$scope.aaPublicacao = null;
	$scope.deAutor = null;
	$scope.deEditora = null;
	$scope.deEdicao = null;

	$scope.alterarLivro = function() {

		/* DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS */
		var livro = new Object();
		livro.deTitulo = $scope.deTitulo,
				livro.aaPublicacao = $scope.aaPublicacao,
				livro.deAutor = $scope.deAutor,
				livro.deEditora = $scope.deEditora,
				livro.deEdicao = $scope.deEdicao, livro.ativo = $scope.ativo;

		/* EXECUTA O POST PARA ALTERAR O REGISTRO */
		var response = $http.post("../alterar", livro);

		response.success(function(data, status, headers, config) {

			/* MOSTRA O RESULTADO QUE RETORNOU DO SPRING */
			if (data.codigo == 1) {

				/* MENSAGEM DE SUCESSO */
				$window.alert(data.mensagem);

				/* REDIRECIONA APÓS ALTERARMOS O REGISTRO */
				window.location.href = "../consultar.html";

			} else {

				/* MOSTRA O ERRO TRATO PELO SPRING (OBJETO ResultadoModel) */
				$window.alert(data.mensagem);

			}
		});

		response.error(function(data, status, headers, config) {
			/* SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM */
			$window.alert(data);

		});

	};

});