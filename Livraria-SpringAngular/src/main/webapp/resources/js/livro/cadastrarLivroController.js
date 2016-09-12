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
	
	$scope.updateForm = function() {
		$scope.submited = false;
	};
	


	$scope.salvarLivro = function() {

		$scope.submited = true;

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
				livro.deEdicao = $scope.deEdicao, livro.ativo = null == $scope.ativo ? false : $scope.ativo;

		/* EXECUTA O POST PARA SALVAR O REGISTRO */
		var response = $http.post("salvar", livro);

		response.success(function(data, status, headers, config) {

			/* MOSTRA O RESULTADO QUE RETORNOU DO SPRING */
			if (data.codigo == 1) {

				/* MENSAGEM DE SUCESSO */
				$window.alert(data.mensagem);

				/*
				 * LIMPA OS CAMPOS APÓS SALVAR O REGISTRO COM SUCESSO
				 */
				$scope.deTitulo = null;
				$scope.aaPublicacao = null;
				$scope.deAutor = null;
				$scope.deEditora = null;
				$scope.deEdicao = null;
				
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
