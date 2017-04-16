package com.redaer.comicsisland.net;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asdf on 2017/4/16.
 */

public class HTTPAnalysis {
    /**
     *  分类的List集合
     * */
    public static void getClassification(String html){
        List<String> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select("#nav > div > ul > li");
        for(Element e : elements){
            Log.e("test","tag:" + e.select("a").text());
        }
    }
    /**
     * 返回 链接，标题，类型，图片URL，剧情简介
     * */
    public static void getClassItem(String html){
        Document document = Jsoup.parse(html);
        Elements elements = document.select(".sdiv");
        for(Element e : elements){
            Log.e("test","URL: http://m.manhuatai.com" + e.select("a").attr("href"));
            Log.e("test","Title: " + e.select("a").attr("title"));

            String z = e.select(".wrapright > ul > .type").html();
            String x = e.select(".wrapright > ul > .type > span").toString();
            String zz = z.replace(x,"");
            Log.e("test","Type: " + zz);

            Log.e("test","PicUrl: " + e.select("img").attr("data-url"));

            z = e.select(".wrapright > ul > .status").html();
            x = e.select(".wrapright > ul > .status > span").toString();
            zz = z.replace(x,"");
            Log.e("test","State: " + zz);

            z = e.select(".wrapright > ul > li").get(3).html();
            Document doc = Jsoup.parse(z);
            Log.e("test","剧情: " + z.replace(doc.select("span").toString(),"") + "\n  ");
        }
    }
    public static void getDetails(String html){
        Document document = Jsoup.parse(html);
        for(Element e : document.select(".mhlistbody > ul > li")){
            Log.e("test",e.toString());
        }

    }

}
