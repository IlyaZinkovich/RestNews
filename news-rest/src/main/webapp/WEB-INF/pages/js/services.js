(function() {
    angular.module('newsApp.services', [])
    .factory('News', ['$resource', function($resource) {
        return $resource('http://localhost:8080/news-rest/news/:id',
        {
            id:'@id'
        },
        {
            update: {
                method: 'PUT'
            }
        });
    }]).factory('Author', ['$resource', function($resource) {
        return $resource('http://localhost:8080/news-rest/authors/:id',
        {
            id:'@id'
        },
        {
            update: {
                method: 'PUT'
            }
        });
    }]).service('popupService', ['$window', function($window) {
        this.showPopup = function(message) {
            return $window.confirm(message);
        }
    }]);
})();
