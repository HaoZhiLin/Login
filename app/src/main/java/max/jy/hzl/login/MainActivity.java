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

import max.jy.hzl.login.contract.LoginContract;
import max.jy.hzl.login.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    /**
     * 请输入账号
     */
    private EditText mEdName;
    /**
     * 请输入密码
     */
    private EditText mEdPsw;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 注册
     */
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEdName = (EditText) findViewById(R.id.edName);
        mEdPsw = (EditText) findViewById(R.id.edPsw);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mRegister = (Button) findViewById(R.id.register);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                String name = mEdName.getText().toString();
                String psw = mEdPsw.getText().toString();
                new LoginPresenter(this).getLoginData(name,psw);


                break;
            case R.id.register:
                startActivityForResult(new Intent(MainActivity.this, RegisterActivity.class), 1);
                break;
        }
    }

    private static final String TAG = "MainActivity";

    @Override
    public void getLoginData(String result) {
        Log.e(TAG, "getLoginData: " + result);
        try {
            JSONObject object = new JSONObject(result);
            int code = object.getInt("code");
            if(code==200){

                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1&&resultCode==2) {
            String name = data.getStringExtra("name");
            String psw = data.getStringExtra("psw");

            mEdName.setText(name);
            mEdPsw.setText(psw);
        }


    }
}
