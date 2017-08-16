export default function routing($routeProvider, $locationProvider) {
	'ngInject';

	$locationProvider.hashPrefix('!');
	$routeProvider
		.when('/', {
			redirectTo: '/dashboard'
		})
		.when('/dashboard', {
			redirectTo: '/profile'
		})
		.otherwise('/404');
}