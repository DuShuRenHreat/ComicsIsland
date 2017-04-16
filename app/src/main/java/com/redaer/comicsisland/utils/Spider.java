package com.redaer.comicsisland.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.redaer.comicsisland.net.HTTPAnalysis;
import com.redaer.comicsisland.net.HTTPRequest;

/**
 * Created by asdf on 2017/4/16.
 */

public class Spider {
    private Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 200:
                    HTTPAnalysis.getClassItem((String)msg.obj);
                    break;
            }
        }
    };
    public void book(String url){
        HTTPRequest.request(url,handler,200);
    }

}
