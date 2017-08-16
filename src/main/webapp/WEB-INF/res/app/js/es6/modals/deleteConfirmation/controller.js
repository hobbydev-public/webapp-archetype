export default class DeleteConfirmationModalController {
    constructor() {}

    dismiss() {
        this.modalInstance.dismiss();
    }

    delete() {
        this.modalInstance.close();
    }

}