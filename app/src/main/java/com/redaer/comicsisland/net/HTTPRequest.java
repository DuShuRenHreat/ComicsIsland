package com.redaer.comicsisland.net;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by asdf on 2017/4/16.
 */

public class HTTPRequest {
    public static String request(String url){
        StringBuilder sb  = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Content-Type","text/html;charset=UTF-8");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line  = null;
            while ((line =br.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void request(final String url,final  Handler handler,final  int what){
        new Thread(new Runnable() {
            @Override
            public void run() {StringBuilder sb  = new StringBuilder();
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    conn.setRequestProperty("Content-Type","text/html;charset=UTF-8");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line  = null;
                    while ((line =br.readLine()) != null){
                        sb.append(line).append("\n");
                    }
                    Message msg = new Message();
                    msg.what = what;
                    msg.obj = sb.toString();
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
