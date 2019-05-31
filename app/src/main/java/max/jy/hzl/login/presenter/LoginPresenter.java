package max.jy.hzl.login.presenter;

import java.security.interfaces.RSAKey;

import max.jy.hzl.login.contract.LoginContract;
import max.jy.hzl.login.model.LoginModel;

/**
 * Created by asus on 2019/5/30.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginModel loginModel;
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginData(String username, String password) {
        if(loginModel!=null){
            loginModel.getLoginData(username, password, new LoginContract.ICallBack() {
                @Override
                public void getLoginData(String result) {
                    view.getLoginData(result);
                }
            });
        }
    }
}
