package com.danicc.sendmessage;

import android.app.Application;

import com.danicc.sendmessage.data.User;

import java.util.logging.Logger;

public class SendMessageAplication extends Application {

    //usuario que ha iniciado la app. DATO GLOBAL por que siempre
    //se accedera a el mediante el metodo getApplication.getUser()
    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("Dani cc","dcasadocarvajal@gmail.com");
    }
    public User getUser() {
        return user;
    }
}
