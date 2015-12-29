package com.jun.mvpdemo01.model.impl;

import com.jun.mvpdemo01.listener.OnLoginListener;
import com.jun.mvpdemo01.model.User;
import com.jun.mvpdemo01.model.UserModel;

/**
 * Created by chenjunjun
 * 用户MOdel的实现类
 */
public class UserImpl implements UserModel {


    @Override
    public void Login(String userName, String passWord, OnLoginListener loginListener) {
        if(userName.equals("chen") && passWord.equals("123")){
            User user = new User() ;
            user.setFirstName(userName);
            user.setPassWord(passWord);
            loginListener.onSuccess(user);
        }else{
            loginListener.onError();
        }
    }
}
