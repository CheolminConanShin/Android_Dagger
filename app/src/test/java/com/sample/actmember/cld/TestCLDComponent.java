package com.sample.actmember.cld;

import com.sample.actmember.cld.activity.MainActivityTest;
import com.sample.actmember.cld.contract.ImageApiContractTest;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules=TestDaggerModule.class)
public interface TestCLDComponent extends CLDComponent {
    void inject(MainActivityTest mainActivityTest);
    void inject(ImageApiContractTest imageControllerContractTest);
}
