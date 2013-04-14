package models;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import java.util.ArrayList;
import java.util.List;

public class StaticAdRepository implements AdRepository {

    private Multimap<Integer, Integer> sellersAds =
            Multimaps.synchronizedListMultimap(ArrayListMultimap.<Integer, Integer>create());

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
        sellersAds.remove(sellerId, adId);
    }

    @Override
    public void addAdForSeller(int sellerId, int adId) {
        sellersAds.put(sellerId, adId);
    }

}
