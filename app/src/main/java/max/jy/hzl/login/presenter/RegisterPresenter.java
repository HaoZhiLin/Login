package max.jy.hzl.login.presenter;

import max.jy.hzl.login.contract.RegisterContract;
import max.jy.hzl.login.model.RegisterModel;

/**
 * Created by asus on 2019/5/30.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private final RegisterModel registerModel;
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        registerModel = new RegisterModel();
    }

    @Override
    public void getData(String username, String password, String phone, String verify) {
        if(registerModel!=null){
            registerModel.getData(username, password, phone, verify, new RegisterContract.ICall() {
                @Override
                public void getData(String resutlt) {
                    view.getData(resutlt);
                }
            });
        }
    }
}
