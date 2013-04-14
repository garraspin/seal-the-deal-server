package models;

import java.util.List;

public interface AdRepository {
    List<Integer> getAdsForSeller(int sellerId);
    void removeAdForSeller(int sellerId, int adId);
    void addAdForSeller(int sellerId, int adId);
}
