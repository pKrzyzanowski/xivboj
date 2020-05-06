var scheduleApp = angular.module('scheduleApp', []);
scheduleApp.controller('roomCtrl', function ($scope, $http) {
    // $scope.refreshRooms = function() {
    //
    //     $http.get('/rest/room/getAll')
    //         .success(function(data){
    //             console.log(data);
    //         });
    // };
    //
    // $scope.initRooms = function() {
    //     $scope.refreshRooms($scope.rooms);
    // };

    //tu gdzies trzeba dac promisa
    $scope.clearRooms = function (roomId) {

        $http.put('/rest/room/remove/' + roomId)
            .success();

    };

})
    .controller('courseCtrl', function ($scope, $http) {
        console.log("e");

        $scope.clearCourses = function (courseId) {

            $http.put('/rest/course/remove/' + courseId)
                .success();

        };

    })
    .controller('instructorCtrl', function ($scope, $http) {
        $scope.clearInstructors = function (instructorId) {

            $http.put('/rest/instructor/remove/' + instructorId)
                .success();

        };
    })