export default class ChangeUserPasswordModalController {
    constructor(user) {
        'ngInject';

        this.user = user;
    }

    doChange() {
        let _ctrl = this;
        this.user.changePassword(
            {}, // some params
            {
                oldPass:_ctrl.oldPass,
                newPass:_ctrl.newPass
            },
            function (id) {
                _ctrl.modalInstance.close();
            },
            function (httpResp) {

            });
    }

    dismiss() {
        this.modalInstance.dismiss();
    }

}