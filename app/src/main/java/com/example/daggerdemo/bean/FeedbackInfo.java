package com.example.daggerdemo.bean;

import javax.inject.Inject;

public class FeedbackInfo {
    private String content;

    public FeedbackInfo(){}

    public FeedbackInfo(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
