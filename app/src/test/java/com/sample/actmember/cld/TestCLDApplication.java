package com.sample.actmember.cld;

public class TestCLDApplication extends CLDApplication {
    private TestCLDComponent cldComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        cldComponent = DaggerTestCLDComponent.builder().testDaggerModule(new TestDaggerModule(this)).build();
    }

    @Override
    public CLDComponent getComponent() {
        return cldComponent;
    }
}
