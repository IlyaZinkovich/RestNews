(function() {
    //'use strict';

    angular.module('newsApp',['ui.router', 'ui.bootstrap','ngResource','newsApp.controllers','newsApp.services']);

    angular.module('newsApp').config(function($stateProvider, $urlRouterProvider){
        $urlRouterProvider.otherwise('/news');
        $stateProvider.state('news',{
            url:'/news',
            templateUrl:'partials/news.html',
            controller:'NewsListController'
        }).state('viewNews',{
           url:'/news/:id/view',
           templateUrl:'partials/news-view.html',
           controller:'NewsViewController'
        }).state('newNews',{
            url:'/news/new',
            templateUrl:'partials/news-save.html',
            controller:'NewsCreateController'
        }).state('editNews',{
            url:'/news/:id/edit',
            templateUrl:'partials/news-save.html',
            controller:'NewsEditController'
        }).state('authors',{
            url:'/authors',
            templateUrl:'partials/authors.html',
            controller:'AuthorsListController'
        }).state('newAuthor',{
            url:'/authors/new',
            templateUrl:'partials/author-save.html',
            controller:'AuthorsCreateController'
        }).state('editAuthor',{
            url:'/authors/:id/edit',
            templateUrl:'partials/author-save.html',
            controller:'AuthorsEditController'
        });
    });

})();