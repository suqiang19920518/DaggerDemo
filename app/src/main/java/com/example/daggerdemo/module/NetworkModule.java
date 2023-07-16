package com.example.daggerdemo.module;

import com.example.daggerdemo.LoginRetrofitService;
import com.example.daggerdemo.bean.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    //告知dagger可以通过该方法来获取到要注入对象的实例
    @Singleton
    @Provides
    public LoginRetrofitService provideLoginRetrofitService() {
        return new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(LoginRetrofitService.class);
    }

    //告知dagger可以通过该方法来获取到要注入对象的实例
    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .build();
    }

    //此处的retrofit就是provideRetrofit()提供的，它会优先在当前的module中查找已经存在的实例，然后使用
//    @Singleton
//    @Provides
//    public LoginRetrofitService provideLoginRetrofitService(Retrofit retrofit){
//        return retrofit.create(LoginRetrofitService.class);
//    }

}
