package com.jun.mvpdemo01.view;

/**
 * Created by chenjunjun on 15/12/15.
 *
 * 对于View的接口  要观察功能上的操作，然后考虑
 *
 * 1、该操作需要什么？
 * 2、操作该结果，对应的反馈
 * 3、该操作过程中对应友好的交互
 *
 *
 * 一般情况下，一个view对应一个model，
 */
public interface LoginView  {


    /**
     * 取得用户名
     * @return
     */
    String getUserName() ;

    /**
     * 取得用户密码
     * @return
     */
    String getPassword() ;


    /***
     * 清除用户名字
     */
    void clearUserName() ;

    /**
     * 清除用户密码
     */
    void clearPassWord() ;


    /**
     * 显示进度条
     */
    void showProgress() ;

    /**
     * 隐藏进度条
     */
    void hideProgress() ;






}
