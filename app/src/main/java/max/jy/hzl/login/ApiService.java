package max.jy.hzl.login;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

/**
 * Created by asus on 2019/5/30.
 */

public interface ApiService {


//    验证码接口：http://yun918.cn/study/public/index.php/verify
//    get  无参   返回结果：{"code":200,"ret":"success","data":"qosb"}
    String verifyUrl="http://yun918.cn/";

    @GET("study/public/index.php/verify")
    Observable<ResponseBody>  getVerify();

//
//
//    登录接口：http://yun918.cn/study/public/index.php/login
//    post 参数（String username,String password） 注：username可以是注册的用户名或手机号


    String loginUrl="http://yun918.cn/";
    @FormUrlEncoded
    @POST("study/public/index.php/login")
    Observable<ResponseBody> getLoginData(@Field("username") String username,@Field("password")String password);


//    注册接口：http://yun918.cn/study/public/index.php/register
//    post  参数（String username,String password,String phone,String verify）
    String registerUrl="http://yun918.cn/";
    @FormUrlEncoded
    @POST("study/public/index.php/register")
    Observable<ResponseBody>  getRegister(@Field("username") String username,
                                          @Field("password")String password,
                                          @Field("phone")String phone,
                                          @Field("verify")String verify);


}
