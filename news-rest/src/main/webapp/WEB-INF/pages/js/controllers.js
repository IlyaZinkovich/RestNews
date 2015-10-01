(function() {
    angular.module('newsApp.controllers',[])
    .controller('NewsListController',['$scope', '$state', 'popupService', 'News',
        function($scope, $state, popupService, News) {

            $scope.newsList = News.query({page: 0, size: 100});

            $scope.deleteNews = function(news) {
                if(popupService.showPopup('Really delete this?')) {
                    news.$delete({id: news.id}, function() {
                        $scope.newsList = News.query({offset: 0, limit: 100});
                    });
                }
            }
    }])
    .controller('NewsViewController', ['$scope', '$stateParams', 'News', 'Author',
        function($scope, $stateParams, News, Author) {

            $scope.news = News.get({id:$stateParams.id});

    }]).controller('NewsCreateController', ['$scope', '$state', '$stateParams', 'News', 'Author',
        function($scope, $state, $stateParams, News, Author) {

            $scope.news = new News();
            $scope.authors = Author.query({expired : false});

            $scope.saveNews = function(news) {
                news.creationDate = new Date();
                news.$save();
                $state.go('news');
            }

    }]).controller('NewsEditController',['$scope', '$state', '$stateParams', 'News', 'Author',
        function($scope, $state, $stateParams, News, Author) {

            $scope.saveNews = function(news){
                news.modificationDate = new Date();
                news.$update({id: news.id}, function() {
                    $state.go('news');
                });
            };

            $scope.loadNews = function(){
                $scope.news = News.get({id : $stateParams.id});
                $scope.authors = Author.query({expired : false});
            };

            $scope.loadNews();

    }]).controller('AuthorsListController',['$scope', '$state', 'popupService', 'Author',
        function($scope, $state, popupService, Author){

            $scope.authorList = Author.query({offset: 0, limit: 100});
            $scope.author = new Author();

            $scope.expireAuthor = function(author){
                if(popupService.showPopup('Really expire this?')){
                    author.expired = new Date();
                    author.$update({id: author.id});
                }
            }

        }
    ]).controller('AuthorsCreateController',['$scope', '$state', 'Author',
          function($scope, $state, Author){

              $scope.author = new Author();

              $scope.saveAuthor = function(author){
                  author.$save(function() {
                      $state.go('authors');
                  });
              }

          }
    ]).controller('AuthorsEditController',['$scope', '$state', '$stateParams', 'Author',
        function($scope, $state, $stateParams, Author){

             $scope.saveAuthor = function(author){
                 author.$update({id: author.id}, function(){
                     $state.go('authors');
                 });
             };

             $scope.loadAuthor = function(){
                 $scope.author = Author.get({id : $stateParams.id});
             };

             $scope.loadAuthor();
        }
    ]);
})();