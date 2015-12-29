package com.jun.mvpdemo01.model;

import com.jun.mvpdemo01.listener.OnLoginListener;

/**
 * Created by chenjunjun on 15/12/15.
 * 这是一个User的MOdel接口
 * 接口一般里面体现的是"做什么",至于"怎么做"，那是实现的事情了。
 */
public interface UserModel {

    void Login(String userName,String passWord,OnLoginListener loginListener) ;
}
