/* Modules */
import angular from 'angular';
import resource from 'angular-resource';
import animate from 'angular-animate';
import uibootstrap from 'angular-ui-bootstrap';

/* Components */
import topNavBar from './topNavBar';

/* Services */

export default angular.module('app.components',
    [
        resource, animate, uibootstrap
    ])
    .component('topNavBar', topNavBar)
    .name