var consultarRegistrosControllerApp = angular.module("consultarRegistrosControllerApp",[]);

angular.module('consultarRegistrosControllerApp', ['angularUtils.directives.dirPagination']);

consultarRegistrosControllerApp.controller("consultarLivrosController",function($scope, $window, $http){
	
	/* CRIANDO UM ARRAY PARA OS REGISTROS QUE VÃO SER RETORNADOS PELO SPRING */
	 $scope.livros = new Array();
	 $scope.nuLivro = null;
	 
	 $scope.reverse = false;
	 $scope.sort = '';
	 
	 $scope.sortBy = function(sort){
		 $scope.sort = sort;
		 $scope.reverse = $scope.reverse ? false : true; 
	 };
	 
	 $scope.init = function(){
	
		 /*
			 * CHAMA O METODO consultarTodos DO CONTROLLER GERENCIADO PELO
			 * SPRING
			 */
		 var response = $http.get("consultarTodos");
		 
		 response.success(function(data, status, headers, config) {
			
			 /*
				 * SETA OS REGISTROS QUE FORAM RETORNADOS DO CONTROLLER DO
				 * SPRING, ESSE REGISTROS VÃO PREENCHER OS CAMPOS DA TABELA DA
				 * PÁGINA consultarRegistros.jsp ATAVÉS DO ng-repeat do
				 * AngularJS
				 */
			 $scope.livros = data;
			 
		 });
		 
		 response.error(function(data, status, headers, config) {
			 /* SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM */
			 $window.alert(data);
			
		 });
	 }
	 
	 $scope.selecionarLivro = function(livro) {
		$scope.nuLivro =  livro.nuLivro;
		$scope.deTituloSelecionado =  livro.deTitulo;
	 };
	 
	 /* FUNÇÃO PARA EXCLUIR UM REGISTRO */	 
	 $scope.excluirLivro = function(){
		 
			 /* CHAMA O MÉTODO DO SPRING PARA EXCLUIR UM REGISTRO */
			 var response = $http.delete("excluirRegistro/" + $scope.nuLivro);
			 
			 response.success(function(data, status, headers, config) {
			
				 /* RECARREGANDO OS REGISTROS CADASTRADOS */
				 $scope.init();
				 Materialize.toast('Livro exclu&iacutedo com sucesso!', 4000)
			 });
			 
			 response.error(function(data, status, headers, config) {
				 /* SE OCORRER ERRO NÃO TRATADO IREMOS MOSTRA EM MENSAGEM */
				 $window.alert(data);
				 
			 });
	 }
	 
});