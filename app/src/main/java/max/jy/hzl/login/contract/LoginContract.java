package max.jy.hzl.login.contract;

import android.telecom.Call;

/**
 * Created by asus on 2019/5/30.
 */

public interface LoginContract {
    interface Model {
        void getLoginData(String username,String password,ICallBack iCallBack);
    }

    interface View {
        void getLoginData(String result);
    }

    interface Presenter {
        void getLoginData(String username,String password);
    }

    interface ICallBack {
        void getLoginData(String result);
    }


}
