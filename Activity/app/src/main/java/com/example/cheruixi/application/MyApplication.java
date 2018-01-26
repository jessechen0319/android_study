package com.example.cheruixi.application;

import android.app.Application;

import com.example.cheruixi.POJO.User;

/**
 * Created by cheruixi on 2018/1/26.
 */

public class MyApplication extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
