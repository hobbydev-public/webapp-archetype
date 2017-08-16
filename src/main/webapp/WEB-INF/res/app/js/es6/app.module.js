import './grid.css';

import angular from 'angular';
import route from 'angular-route';

import components from './components';
import modals from './modals';

import usersModule from './modules/users';

import routesConfig from './app.module.routing';

let rootModule = angular.module('app',
	[
		route, 'angular-password',
		components, modals,
		usersModule
	])
	.config(routesConfig);