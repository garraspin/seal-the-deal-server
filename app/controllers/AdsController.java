package controllers;

import models.AdsService;
import play.mvc.Controller;
import play.mvc.Result;

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
        return ok();
    }

//    (Deserialization)
//    Type collectionType = new TypeToken<Collection<Integer>>(){}.getType();
//    Collection<Integer> ints2 = gson.fromJson(json, collectionType);
}
