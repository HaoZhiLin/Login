package max.jy.hzl.login.contract;

/**
 * Created by asus on 2019/5/30.
 */

public interface RegisterContract {
    interface Model {
        void  getData(String username,String password,String phone,String verify,ICall iCall);
    }

    interface View {
        void  getData(String resutlt);
    }

    interface Presenter {
        void  getData(String username,String password,String phone,String verify);
    }

    interface ICall {
        void  getData(String resutlt);
    }
}
