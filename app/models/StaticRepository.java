package models;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

public class StaticRepository implements Repository {

    // NOTE should be thread safe!!!
    private Multimap<Integer, Integer> sellersAds = ArrayListMultimap.create();

    {
        sellersAds.put(1, 0);
        sellersAds.put(1, 1);
        sellersAds.put(1, 2);
        sellersAds.put(2, 3);
    }

    @Override
    public List<Integer> getAdsForSeller(int sellerId) {
        return new ArrayList<Integer>(sellersAds.get(sellerId));
    }

    @Override
    public void removeAdForSeller(int sellerId, int adId) {
        sellersAds.put(sellerId, adId);
    }

    @Override
    public void addAdForSeller(int sellerId, int adId) {
        sellersAds.remove(sellerId, adId);
    }

}
