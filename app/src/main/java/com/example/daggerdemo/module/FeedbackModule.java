package com.example.daggerdemo.module;

import com.example.daggerdemo.bean.FeedbackInfo;
import com.example.daggerdemo.qualifier.FeedQualifier1;
import com.example.daggerdemo.qualifier.FeedQualifier2;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedbackModule {

    // @Named("FeedbackInfo1")
    @FeedQualifier1
    @Provides
    public FeedbackInfo provideFeedbackInfo() {
        return new FeedbackInfo();
    }

    // @Named("FeedbackInfo2")
    @FeedQualifier2
    @Provides
    public FeedbackInfo provideFeedbackInfo2(){
        return new FeedbackInfo("FeedbackInfo2");
    }

}
