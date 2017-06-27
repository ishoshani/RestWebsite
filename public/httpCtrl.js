app.controller('httpCtrl',function($scope, $http){

  $http.get('http://localhost:8080/blog/all').then(function success(response){
    $scope.blogs = response.data;
  }, function error(response) {
    $scope.blog = response.statusText;
  });
});
