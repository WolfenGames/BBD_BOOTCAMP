angular.module('h2n').factory('CarResource', function($resource){
    var resource = $resource('rest/cars/:CarId',{CarId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});