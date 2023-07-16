package com.example.daggerdemo.module;

import com.example.daggerdemo.component.LoginComponent;
import com.example.daggerdemo.component.UserComponent;

import dagger.Module;

@Module(subcomponents = {LoginComponent.class, UserComponent.class})
public class SubComponentsModule {

}
