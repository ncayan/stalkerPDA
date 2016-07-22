package com.example.administrator.stalkerpda.model;

import com.example.administrator.stalkerpda.until.Tools;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SMS {
    String content;
    String title;
    Long headIcon;

    public SMS(){
        this.content = "content";
        this.title = "title";
        this.headIcon = 0l;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (Tools.isUsefulString(content)) {
            this.content = content;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (Tools.isUsefulString(title)) {
            this.title = title;
        }
    }

    public Long getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(Long headIcon) {
        this.headIcon = headIcon;
    }
}


