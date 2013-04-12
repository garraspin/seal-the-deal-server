package controllers;

import org.junit.Test;
import play.mvc.Result;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.*;

public class AdsControllerTest {

    @Test
    public void getSellerAds() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Result sellerAds = AdsController.getSellerAds(1);
                String result = sellerAds.toString();
                assertThat(result, is("result"));
            }
        });
    }
}
