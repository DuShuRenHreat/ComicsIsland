package com.redaer.comicsisland;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.redaer.comicsisland.utils.Spider;

public class MainActivity extends Activity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          //  HTTPAnalysis.getClassification((String)msg.obj); //主页面分类
        //    HTTPAnalysis.getClassItem((String)msg.obj);
        //    HTTPAnalysis.getDetails((String)msg.obj);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  //      HTTPRequest.request("http://www.manhuatai.com/",handler,100); //主页面分类
    //    HTTPRequest.request("http://m.manhuatai.com/zhiyinmanke.html",handler,100); //分类的item
      //  HTTPRequest.request("http://m.manhuatai.com/jueshitangmen/",handler,100); //详情
        Spider spider = new Spider();
        spider.book("http://m.manhuatai.com/zhiyinmanke.html");


    }
}
