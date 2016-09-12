var editarLivroControllerApp = angular.module("editarLivroControllerApp", []);

editarLivroControllerApp.controller("editarLivroController", function($scope,
		$window, $http) {

	/* DEFININDO O MODELO PARA O NOSSO FORMULÁRIO */
	$scope.deTitulo = null;
	$scope.aaPublicacao = null;
	$scope.deAutor = null;
	$scope.deEditora = null;
	$scope.deEdicao = null;
	$scope.icAtivo = null;

	$scope.updateForm = function() {
		$scope.submited = false;
	};

	$scope.init = function() {
		var url = window.location.href;
		var id = url.substring(url.lastIndexOf("/") + 1);
		$http.get("../editarLivro.html/" + id).then(function(response) {
			$scope.nuLivro = id;
			$scope.deTitulo = response.data.deTitulo;
			$scope.aaPublicacao = response.data.aaPublicacao;
			$scope.deAutor = response.data.deAutor;
			$scope.deEditora = response.data.deEditora;
			$scope.deEdicao = response.data.deEdicao;
			$scope.icAtivo = response.data.ativo;
		});
	};

	$scope.alterarLivro = function() {

		$scope.submited = true;

		if (!$scope.form.$valid) {
			return false;
		}

		/* DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS */
		var livro = new Object();
		livro.nuLivro = $scope.nuLivro, livro.deTitulo = $scope.deTitulo,
				livro.aaPublicacao = $scope.aaPublicacao,
				livro.deAutor = $scope.deAutor,
				livro.deEditora = $scope.deEditora,
				livro.deEdicao = $scope.deEdicao, livro.ativo = null == $scope.icAtivo ? false : $scope.icAtivo;

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