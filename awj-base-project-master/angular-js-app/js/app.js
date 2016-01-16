var app = angular.module('blog', []);
var persoane = [];

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!!';

}]);




//______________________PERSON______________________//

app.controller('PersoanaNgController', ['$scope', '$http', function ($scope, $http) {
    $scope.url = 'http://localhost:8080/persoana';
    $scope.persoane = persoane;
    $scope.persoaneKeys = persoane.keys();
    $scope.keys = [];

    $scope.person = {};
    $scope.editPerson = {};


    $http.get($scope.url).then(
        function successCallback(response) {
            $scope.persoane = response.data;
            console.log($scope.persoane);
        });


    $scope.getPersoana = function(id){
        $http.get($scope.url + "/" + id).then(
            function successCallback(response) {
                alert("ID : " + response.data.id + " Nume : " + response.data.name);
            });
    };


    $scope.addPersoana = function (persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);

        $http.post($scope.url, persoana)
            .then(function successCallback(response) {
                console.log(response);
                $scope.persoane.push(persoana);
            },
            function () {
                $scope.persoane.push(persoana);
            });
    };

    $scope.setUpdatePerson = function (person) {
        $scope.editPerson = person;
    };

    $scope.updatePerson = function () {
        $http({
            method: "PUT",
            url: $scope.url + '/' + $scope.editPerson.id + '/' + $scope.editPerson.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });

    };

    $scope.deletePersoana = function (id) {
        $scope.persoane.splice(id - 1, 1);
        $http({
            method: 'DELETE',
            url: $scope.url + '/' + id,
            data: {}
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
            $scope.persoane = $scope.persoane.filter(function (obj) {
                return obj.id !== id;

            });
        });
    };
}]);



//______________________ANGAJAT______________________//

app.controller('AngajatNgController', ['$scope', '$http', function ($scope, $http) {

    $scope.url = 'http://localhost:8080/angajat';
    $scope.persoane = persoane;
    $scope.persoaneKeys = persoane.keys();
    $scope.keys = [];

    $scope.person = {};
    $scope.editPerson = {};


    $http.get($scope.url).then(
        function successCallback(response) {
            $scope.persoane = response.data;
            console.log($scope.persoane);
        });


    $scope.getPersoana = function(id){
        $http.get($scope.url + "/" + id).then(
            function successCallback(response) {
                alert("ID : " + response.data.id + " Nume : " + response.data.name);
            });
    };


    $scope.addPersoana = function (persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);

        $http.post($scope.url, persoana)
            .then(function successCallback(response) {
                console.log(response);
                $scope.persoane.push(persoana);
            },
            function () {
                $scope.persoane.push(persoana);
            });
    };

    $scope.setUpdatePerson = function (person) {
        $scope.editPerson = person;
    };

    $scope.updatePerson = function () {
        $http({
            method: "PUT",
            url: $scope.url + '/' + $scope.editPerson.id + '/' + $scope.editPerson.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });

    };


    $scope.deletePersoana = function (id) {
        $scope.persoane.splice(id - 1, 1);
        $http({
            method: 'DELETE',
            url: $scope.url + '/' + id,
            data: {}
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
            $scope.persoane = $scope.persoane.filter(function (obj) {
                return obj.id !== id;

            });
        });
    };

}]);





//______________________PRODUS______________________//

app.controller('ProdusNgController', ['$scope', '$http', function ($scope, $http) {
    $scope.url = 'http://localhost:8080/produs';
    $scope.persoane = persoane;
    $scope.persoaneKeys = persoane.keys();
    $scope.keys = [];

    $scope.person = {};
    $scope.editPerson = {};


    $http.get($scope.url).then(
        function successCallback(response) {
            $scope.persoane = response.data;
            console.log($scope.persoane);
        });


    $scope.getPersoana = function(id){
        $http.get($scope.url + "/" + id).then(
            function successCallback(response) {
                alert("ID : " + response.data.id + " Nume : " + response.data.name);
            });
    };


    $scope.addPersoana = function (persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);

        $http.post($scope.url, persoana)
            .then(function successCallback(response) {
                console.log(response);
                $scope.persoane.push(persoana);
            },
            function () {
                $scope.persoane.push(persoana);
            });
    };

    $scope.setUpdatePerson = function (person) {
        $scope.editPerson = person;
    };

    $scope.updatePerson = function () {
        $http({
            method: "PUT",
            url: $scope.url + '/' + $scope.editPerson.id + '/' + $scope.editPerson.name
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
        });

    };

    $scope.deletePersoana = function (id) {
        $scope.persoane.splice(id - 1, 1);
        $http({
            method: 'DELETE',
            url: $scope.url + '/' + id,
            data: {}
        }).then(function successCallback(response) {
        }, function errorCallback(response) {
            $scope.persoane = $scope.persoane.filter(function (obj) {
                return obj.id !== id;

            });
        });
    };
}]);



