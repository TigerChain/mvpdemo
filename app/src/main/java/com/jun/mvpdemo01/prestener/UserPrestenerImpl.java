package com.jun.mvpdemo01.prestener;



import android.util.Log;

import com.jun.mvpdemo01.listener.OnLoginListener;
import com.jun.mvpdemo01.model.User;
import com.jun.mvpdemo01.model.UserModel;
import com.jun.mvpdemo01.model.impl.UserImpl;
import com.jun.mvpdemo01.view.LoginView;

/**
 * Created by chenjunjun on 15/12/15.
 *
 * 这是一个Prestener 用来操作View和Model的
 * mvp中view不能直接操作Model
 */
public class UserPrestenerImpl implements UserPrestener {

    private UserModel userModel ;
    private LoginView loginView ;


    public UserPrestenerImpl(LoginView loginView){
        this.loginView = loginView ;
        userModel = new UserImpl() ;

    }

    /**
     * 登录的方法
     */
    public void login(){
        this.loginView.showProgress();
        userModel.Login(this.loginView.getUserName(), this.loginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(User user) {

                loginView.hideProgress();
                Log.e("====","登录成功!") ;
            }

            @Override
            public void onError() {

                loginView.hideProgress();

                Log.e("====","用户名或密码错误") ;
            }
        });
    }

    /**
     * 清除的方法
     */
    public void clear(){
        this.loginView.clearPassWord();
        this.loginView.clearUserName();
    }


}
