package com.jun.mvpdemo01;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jun.mvpdemo01.prestener.UserPrestener;
import com.jun.mvpdemo01.prestener.UserPrestenerImpl;
import com.jun.mvpdemo01.view.LoginView;


public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    /**
     * 用户名
     */
    private EditText et_user ;
    /**
     * 密码
     */
    private EditText et_pass ;

    /**
     * 登录和清除按键
     */

    private Button login_button ,cancel_button ;


    /**
     * 用户的presenter类  持有View和Model的引用 把它们组合起来
     */

    private UserPrestener userPrestener ;

    private ProgressDialog progressBar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView() ;

        userPrestener = new UserPrestenerImpl(this) ;



    }

    private void initView() {

        et_user = (EditText) this.findViewById(R.id.et_user) ;
        et_pass = (EditText) this.findViewById(R.id.et_pass) ;

        login_button = (Button) this.findViewById(R.id.login_button) ;
        cancel_button = (Button) this.findViewById(R.id.cancel_button) ;


        login_button.setOnClickListener(this);
        cancel_button.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return et_user.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_pass.getText().toString();
    }

    @Override
    public void clearUserName() {
        if(!TextUtils.isEmpty(et_user.getText().toString().trim())){
            et_user.setText("");
        }
    }

    @Override
    public void clearPassWord() {
        if(!TextUtils.isEmpty(et_pass.getText().toString().trim())){
            et_pass.setText("");
        }

    }

    @Override
    public void showProgress() {

        progressBar = new ProgressDialog(this) ;
        progressBar.setMessage("加载中......");
        progressBar.show();

    }

    @Override
    public void hideProgress() {
        new Handler().postDelayed(new Runnable() {
            @Override
                public void run() {

                    progressBar.dismiss();

            }
        }, 2000) ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                String userName_content = et_user.getText().toString().trim() ;
                String userPass_content = et_pass.getText().toString().trim() ;
                if(TextUtils.isEmpty(userName_content) || TextUtils.isEmpty(userPass_content)){
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空!",Toast.LENGTH_SHORT).show();
                    return ;
                }
                userPrestener.login();
                break ;
            case R.id.cancel_button:
                userPrestener.clear();
                break ;
        }
    }
}
