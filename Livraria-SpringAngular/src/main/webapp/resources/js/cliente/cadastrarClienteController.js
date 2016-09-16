var cadastrarClienteApp = angular.module("cadastrarClienteApp", []);

cadastrarClienteApp.controller("cadastrarClienteController", function($scope, $window, $http) {

	$scope.noCliente = null;
	$scope.nuCpf = null;
	$scope.dtNascimento = null;
	$scope.deLogradouro = null;
	$scope.deBairro = null;
	$scope.deCidade = null;
	$scope.sgUf = null;
	$scope.nuLogradouro = null;
	$scope.nuCep = null;
	$scope.nuTelefone = null;
	$scope.nuCelular = null;

	$scope.buscarCep = function() {

		var response = $http.get("viacep.com.br/ws/" + $scope.nuCep.replace(".", "").replace("-", "") + "/json/").then(function(response) {
			$scope.deLogradouro = response.data;
		});

	}

})