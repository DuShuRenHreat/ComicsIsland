package com.redaer.comicsisland.bean;

import com.redaer.comicsisland.init.Init;

/**
 * Created by asdf on 2017/4/16.
 */

public class ItemBean { ///返回 链接，标题，类型，图片URL，剧情简介
    @Init(elem = "a",type = Init.Type.ATTR,attr = "title")
    private String title;
    @Init(elem = "a",type = Init.Type.ATTR,attr = "href")
    private String url;
    @Init(elem = "img",type = Init.Type.ATTR,attr = "data-url")
    private String pic;

    @Init(elem = ".wrapright > ul > li:eq(3)")
    private String story;

    @Init(elem = ".wrapright > ul > .status")
    private String state;
    @Init(elem = ".wrapright > ul > .type")
    private String type;
}
