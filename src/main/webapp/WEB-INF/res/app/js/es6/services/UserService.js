export default function UserService($resource) {
    'ngInject';

    return $resource('api/web/users/:id/', {id:'@id'}, {
            update: {
                method: 'PUT'
            },
            changePassword: {
                method:'PUT',
                url:'api/web/users/password'
            },
            resetPassword: {
                method:'DELETE',
                url:'api/web/users/:id/password'
            }
        });
}