import myProfileCtrl from './controllers/MyProfileController';

export default function routing($routeProvider) {
	'ngInject';

	$routeProvider
		.when('/profile', {
			template: require('./templates/myProfile.html'),
			controller: myProfileCtrl,
			controllerAs: '$ctrl'
		});
}