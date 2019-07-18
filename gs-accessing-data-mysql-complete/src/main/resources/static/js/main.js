var app = angular.module('myApp', []);


app.controller('myCtrl', function($scope,$http) {
//	$scope.name = "hellow world";
//	$scope.user = {
//			name: "Israel Navarro",
//			edad: 22,
//			sexo: "H"
//	};
//	$scope.users = [
//		{
//			name: "Israel Navarro",
//			edad: 22,
//			sexo: "H"
//	},
//	{
//		name: "Israelito Navarro",
//		edad: 22,
//		sexo: "H"
//}
//	];
	
	$scope.accion = 0;
	$scope.users = [];
	$scope.user = {};
	$scope.consultarUsers= function (){
		$http({
			url:'/user',
			method: "GET"
		}).then(function (response){
			console.log("Datos recibidos: ", response.data);
			$scope.users = response.data;
		}, function(response){
			console.log(response)
		});
		
	}

	$scope.guardar = function (user) {
		$http({
			url:'/user',
			method: "POST",
			data: user
		}).then(function (response){
			swal("Exito","Se ha agregado correctamente","success")
			$scope.cambiarAccion(0);
			$scope.consultarUsers();
		}, function(response){
			console.log(response)
		});
	}

	$scope.actualizar = function (user) {
		$http({
			url:'/user',
			method: "PUT",
			data: user
		}).then(function (response){
			$scope.cambiarAccion(0);
			$scope.consultarUsers();
		}, function(response){
			console.log(response)
		});
	}
	$scope.eliminar = function (user) {
		swal({
			   title: "Quieres eliminar?",
			   text: "Si eliminas ya no vas a poder recuperar datos",
			   icon: "warning",
			   buttons: true,
			   dangerMode: true,
			 })
			 .then((willDelete) => {
			   if (willDelete) {
		$http({
			url : '/user',
			method : "DELETE",
			data:user
		}).then(function(response) {
			$scope.consultarUsers();
		}, function(response) {
			console.log(response);
		});
		   } else {
			   swal("Exito", "Se ha cancelado correctamente", "warning");
		   }
		});
	}
	$scope.editar = function(user){
		$scope.cambiarAccion(2);
		$scope.user = user;
	}
	
	$scope.verAccion = function (accion) {
		return $scope.accion === accion;
	}
	
	$scope.cambiarAccion = function (accion) {
		$scope.user= {};
		$scope.accion = accion;
	}
});

