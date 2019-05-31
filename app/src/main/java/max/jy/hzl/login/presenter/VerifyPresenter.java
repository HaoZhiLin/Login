package max.jy.hzl.login.presenter;

import max.jy.hzl.login.contract.VerifyContract;
import max.jy.hzl.login.model.VerifyModel;

/**
 * Created by asus on 2019/5/30.
 */

public class VerifyPresenter implements VerifyContract.Presenter {
    private final VerifyModel verifyModel;
    private VerifyContract.View view;

    public VerifyPresenter(VerifyContract.View view) {
        this.view = view;
        verifyModel = new VerifyModel();
    }

    @Override
    public void getVerify() {
        if(verifyModel!=null){
            verifyModel.getVerify(new VerifyContract.ICall() {
                @Override
                public void getVerify(String result) {
                    view.getVerify(result);
                }
            });
        }

    }
}
