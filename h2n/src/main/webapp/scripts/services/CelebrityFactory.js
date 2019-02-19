angular.module('h2n').factory('CelebrityResource', function($resource){
    var resource = $resource('rest/celebrities/:CelebrityId',{CelebrityId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});