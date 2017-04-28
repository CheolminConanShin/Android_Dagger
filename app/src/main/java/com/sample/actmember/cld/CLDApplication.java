package com.sample.actmember.cld;

import android.app.Application;

public class CLDApplication extends Application {
    private CLDComponent cldComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        cldComponent = DaggerCLDComponent.builder().daggerModule(new DaggerModule(this)).build();
    }

    public CLDComponent getComponent() {
        return cldComponent;
    }
}
