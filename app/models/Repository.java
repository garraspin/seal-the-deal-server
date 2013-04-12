package models;

import java.util.List;

public interface Repository {
    List<Integer> getAdsForSeller(int sellerId);
    void removeAdForSeller(int sellerId, int adId);
    void addAdForSeller(int sellerId, int adId);
}
