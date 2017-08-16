/* Modules */
import angular from 'angular';
import resource from 'angular-resource';
import animate from 'angular-animate';
import uibootstrap from 'angular-ui-bootstrap';

/* Modals */
import changePassword from './changeUserPassword';
import deleteConfirmation from './deleteConfirmation';

/* Services */
import user from '../services/UserService';

export default angular.module('app.modals',
    [
        resource, animate, uibootstrap
    ])
    .component('changeUserPasswordModal', changePassword)
    .component('deleteConfirmationModal', deleteConfirmation)
    .factory('user', user)
    .name