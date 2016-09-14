var cadastrarControllerApp = angular.module("cadastrarControllerApp", []);

cadastrarControllerApp.controller("cadastrarController", function($scope,
		$window, $http) {

	/* DEFININDO O MODELO PARA O NOSSO FORMULÁRIO */
	$scope.deTitulo = null;
	$scope.aaPublicacao = null;
	$scope.deAutor = null;
	$scope.deEditora = null;
	$scope.deEdicao = null;
	$scope.ativo = null;

	$scope.salvarLivro = function() {

		if (!$scope.form.$valid) {
			return false;
		}

		/*
		 * DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS
		 */

		var livro = new Object();
		livro.deTitulo = $scope.deTitulo,
				livro.aaPublicacao = $scope.aaPublicacao,
				livro.deAutor = $scope.deAutor,
				livro.deEditora = $scope.deEditora,
				livro.deEdicao = $scope.deEdicao,
				livro.ativo = null == $scope.icAtivo ? false : $scope.icAtivo;

		/* EXECUTA O POST PARA SALVAR O REGISTRO */
		var response = $http.post("salvar", livro);

		response.success(function(data, status, headers, config) {

			/* MOSTRA O RESULTADO QUE RETORNOU DO SPRING */
			if (data.codigo == 1) {

				/* MENSAGEM DE SUCESSO */
				Materialize.toast(data.mensagem, 4000)

				/*
				 * LIMPA OS CAMPOS APÓS SALVAR O REGISTRO COM SUCESSO
				 */
				$scope.deTitulo = null;
				$scope.aaPublicacao = null;
				$scope.deAutor = null;
				$scope.deEditora = null;
				$scope.deEdicao = null;
				$scope.icAtivo = null;

				$scope.submited = false;
			} else {

				/*
				 * MOSTRA O ERRO TRATO PELO SPRING (OBJETO ResultadoModel)
				 */
				$window.alert(data.mensagem);

			}
		});

		response.error(function(data, status, headers, config) {
			/*
			 * SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM
			 */
			$window.alert(data);

		});

	};

});
