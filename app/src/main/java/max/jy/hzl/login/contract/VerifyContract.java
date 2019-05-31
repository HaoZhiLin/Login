package max.jy.hzl.login.contract;

/**
 * Created by asus on 2019/5/30.
 */

public interface VerifyContract {
    interface Model {
        void getVerify(ICall iCall);
    }

    interface View {
        void getVerify(String result);
    }

    interface Presenter {
        void getVerify();
    }

    interface ICall {
        void getVerify(String result);
    }

}
