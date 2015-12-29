package com.jun.mvpdemo01.listener;

import com.jun.mvpdemo01.model.User;

/**
 * Created by chenjunjun on 15/12/15.
 * 登录的事件类
 */
public interface OnLoginListener {

    void onSuccess(User user) ;
    void onError() ;
}
