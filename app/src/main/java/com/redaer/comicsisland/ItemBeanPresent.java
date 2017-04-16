package com.redaer.comicsisland;

import android.util.Log;

import com.redaer.comicsisland.init.Init;

import org.jsoup.nodes.Element;

import java.lang.reflect.Field;

/**
 * Created by asdf on 2017/4/16.
 */

public class ItemBeanPresent {
    public static void toBean(Element element, Class<?> tClass){
            for(Field f : tClass.getDeclaredFields()){
                Init init = f.getAnnotation(Init.class);
                if(init == null) continue;
                f.setAccessible(true);
                if(init.type() == Init.Type.ATTR){
                    Log.e("test",f.getName() + ":" + element.select(init.elem()).attr(init.attr()));
                }else{
                    Log.e("test",f.getName() + ":" + element.select(init.elem()).text());
                }
            }
    }
}
