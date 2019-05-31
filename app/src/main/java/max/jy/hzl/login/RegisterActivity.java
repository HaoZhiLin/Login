package max.jy.hzl.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import max.jy.hzl.login.contract.RegisterContract;
import max.jy.hzl.login.contract.VerifyContract;
import max.jy.hzl.login.presenter.RegisterPresenter;
import max.jy.hzl.login.presenter.VerifyPresenter;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, VerifyContract.View, RegisterContract.View {

    /**
     * 请输入账号
     */
    private EditText mEdName;
    /**
     * 请输入密码
     */
    private EditText mEdPsw;
    /**
     * 请重复密码
     */
    private EditText mEdRePsw;
    /**
     * 手机号
     */
    private EditText mEdPhone;
    /**
     * 验证码
     */
    private EditText mEdYan;
    /**
     * 注册
     */
    private Button mRegister;
    private String name;
    private String psw;
    private String phone;
    private String verify;
    private String rePsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

    }



    private void initView() {
        mEdName = (EditText) findViewById(R.id.edName);
        mEdPsw = (EditText) findViewById(R.id.edPsw);
        mEdRePsw = (EditText) findViewById(R.id.edRePsw);
        mEdPhone = (EditText) findViewById(R.id.edPhone);
        mEdYan = (EditText) findViewById(R.id.edYan);
        mRegister = (Button) findViewById(R.id.register);
        new VerifyPresenter(this).getVerify();
        mRegister.setOnClickListener(this);
        mEdYan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.register:
                name = mEdName.getText().toString();
                psw = mEdPsw.getText().toString();
                phone = mEdPhone.getText().toString();
                verify = mEdYan.getText().toString();
                rePsw = mEdRePsw.getText().toString();
                if(psw.equals(rePsw)){
                    new RegisterPresenter(this).getData(name, psw, phone, verify);
                }

                break;

            case R.id.edYan:


                break;
        }
    }

    @Override
    public void getVerify(String result) {
        try {
            JSONObject object = new JSONObject(result);
            String data = object.getString("data");
            mEdYan.setText(data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static final String TAG = "RegisterActivity";
    @Override
    public void getData(String resutlt) {
        Log.e(TAG, "getData: "+resutlt );
        try {
            JSONObject object = new JSONObject(resutlt);
            int code = object.getInt("code");
            if(code==200){
                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("psw",psw);
                setResult(2,intent);
                finish();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
