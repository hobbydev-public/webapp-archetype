export default class MyProfileController {
    constructor(user, $uibModal, $scope) {
        'ngInject';

        this.user = user;
        this.modal = $uibModal;

        this.vm = $scope;

        this._initData();
    }

    openPasswordChangeModal(){
        let modal = this.modal.open({
            component: 'changeUserPasswordModal'
        });

        modal.result.then(
            function () {
                // on close
            },
            function () {
                // on dismiss
            }
        );
    }

    _initData() {
        let _ctrl = this;
        this.vm.user = this.user.get({id:-1}, function (user) {

            let rolesString = '';
            for(let i = 0; i < _ctrl.vm.user.authorities.length; i++) {
                rolesString += _ctrl.vm.user.authorities[i].authority;
                if(i != _ctrl.vm.user.authorities.length - 1) {
                    rolesString += ', ';
                }
            }

            _ctrl.vm.user.authorities = rolesString;
        });
    }
}