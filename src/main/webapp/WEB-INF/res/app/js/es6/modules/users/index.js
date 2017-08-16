/* Modules */
import angular from 'angular';
import resource from 'angular-resource';
import animate from 'angular-animate';
import uibootstrap from 'angular-ui-bootstrap';

/* Services */
import user from '../../services/UserService';

/* Config */
import routing from './routing';

export default angular.module('app.users',
    [
        resource, uibootstrap, animate, 'angular-password'
    ])
    .factory('user', user)
    .config(routing)
    .name;