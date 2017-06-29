

app.controller('httpCtrl',function($scope, $http){

  $http.get('http://localhost:8080/blog/all').then(function success(response){
    $scope.blogs = response.data;
  }, function error(response) {
    $scope.blog = response.statusText;
  });
  $http.get('https://api.github.com/users/ishoshani/events/public').then(function success(response){
    var data = response.data;
    var finalList = [];
    for (var event in data) {
        var evType = data[event].type;
        var evComment = "";
        if(evType.localeCompare("PushEvent")==0){
          evType = "Pushed to";
          if(data[event].payload.commits.length>0){
            evComment = data[event].payload.commits[0].message
          }
        }
        if(evType.localeCompare("CreateEvent")==0){
          evType = "Created";
        }
        if(evType.localeCompare("ForkEvent")==0){
          evType = "Forked";
        }
        if(evType.localeCompare("GistEvent")==0){
          evType = "Wrote Gist";
        }
        finalList.push({eventType:evType,repo:data[event].repo.name, comment:evComment});
    }
    $scope.github = finalList;
  }, function error(response){
    $scope.github = response.statusText;
  });
});
