package com.sample.actmember.cld.activity;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.sample.actmember.cld.activity.page.MainPage;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mbtest.javabank.Client;
import org.mbtest.javabank.fluent.ImposterBuilder;
import org.mbtest.javabank.http.imposters.Imposter;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.fail;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UITest {

    private static final String EMULATOR_HOST = "http://10.0.2.2";
    private static final int MOUNTEBANK_PORT = 2525;
    private static final int TEST_PORT = 3334;
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Client mountebankClient = new Client(EMULATOR_HOST + ":" + MOUNTEBANK_PORT);

    @Test
    public void mainActivityTest() throws Exception {

        stubAPIResponse();

        MainPage mainPage = new MainPage();
        mainPage.imageAButtonClick();
        mainPage.checkImageViewDisplay();
        mainPage.checkImageNameTextView("Beauty And The Beast");

        mainPage.imageBButtonClick();
        mainPage.checkImageViewDisplay();
        Thread.sleep(2000);
        mainPage.checkImageNameTextView("Hubert Shin");
    }

    @After
    public void deleteMountebankStub() {
        mountebankClient.deleteImposter(TEST_PORT);
    }


    public void stubAPIResponse() throws Exception {
        Imposter imposter = ImposterBuilder.anImposter()
                .onPort(TEST_PORT)
                .stub()
                .predicate()
                .equals()
                .method("GET")
                .path("/beautyandthebeast")
                .end()
                .end()
                .response()
                .is()
                .body(getResponseBody().toJSONString())
                .statusCode(200)
                .end()
                .end()
                .end()
                .stub()
                .predicate()
                .equals()
                .method("GET")
                .path("/aladin")
                .end()
                .end()
                .response()
                .is()
                .body(getFakeResponseBody().toJSONString())
                .statusCode(200)
                .end()
                .end()
                .end()
                .build();
        int statusCode = mountebankClient.createImposter(imposter);
        if (statusCode != 201) {
            fail("Failed to create imposter. Status code returned " + statusCode + ".");
        }
        Thread.sleep(1000);
    }

    private JSONObject getFakeResponseBody(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Hubert Shin");
        jsonObject.put("path", "hubert");

        return jsonObject;
    }

    private JSONObject getResponseBody(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Beauty And The Beast");
        jsonObject.put("path", "beautyandthebeast");

        return jsonObject;
    }
}
