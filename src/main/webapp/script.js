var app = angular.module("myCatalogueApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
           templateUrl : "Catalogue.htm",
           controller :  "CatalogueCtrl"
         })
        .when("/computers", {
            templateUrl : "computers.html",
            controller : "computersCtrl"
        })
        .when("/entertainment", {
            templateUrl : "entertainment.html",
            controller : "entertainmentCtrl"
        })
        .when("/history", {
            templateUrl: "history.html",
            controller: "historyCtrl"
        })
        .when("/biograpghy", {
            templateUrl: "biograpghy.html",
            controller: "biograpghyCtrl"
        });



});
app.controller("computersCtrl", function ($scope) {
    $scope.msg = "Prologue Library has Computer Books in Shelf 1";
});
app.controller("entertainmentCtrl", function ($scope) {
    $scope.msg = "Prologue Library has Entertainment Books in Shelf 2";
});
app.controller("historyCtrl", function ($scope) {
    $scope.msg = "Prologue Library has History Books in Shelf 3";
});
app.controller("biograpghyCtrl", function ($scope) {
    $scope.msg = "Prologue Library has Biograpghy Books in Shelf 4";
});
