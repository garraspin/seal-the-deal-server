package controllers;

import models.AdsService;
import models.Datastore;
import models.GcmService;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;

public class AdsController extends Controller {

    public static Result getSellerAds(int sellerId) {
        response().setContentType("application/json");
        String result = new AdsService().getAdsForSeller(sellerId);
        return ok(result);
    }

    public static Result addSellerAd(int sellerId, int adId) {
        new AdsService().addSellerAd(sellerId, adId);
        return ok();
    }

    public static Result removeSellerAd(int sellerId, int adId) {
        new AdsService().removeSellerAd(sellerId, adId);
        try {
            String regId = Datastore.getRegId(String.valueOf(sellerId));
            GcmService.sendMessage(regId, String.valueOf(adId));
        } catch (IOException e) {
            new AdsService().addSellerAd(sellerId, adId);
            Logger.error("Error sending GCM message to seller: " + sellerId, e);
            return internalServerError();
        }
        return ok();
    }

//    (Deserialization)
//    Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
//    Collection<Integer> ints2 = gson.fromJson(json, collectionType);
}
