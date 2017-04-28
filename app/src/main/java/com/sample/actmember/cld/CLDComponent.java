package com.sample.actmember.cld;


import com.sample.actmember.cld.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules=DaggerModule.class)
public interface CLDComponent {
    void inject(MainActivity mainActivity);
}
