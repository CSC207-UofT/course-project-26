package Usecase;

import Entity.Listing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListingManager {
    private Map<String, Listing> listingIdToListing = new HashMap<>();

    /**
     * Creates an instance of ListingManager with a list of Listing and a list of listings
     */
    public ListingManager(List<Listing> allListing) {
        for (Listing listing: allListing) {
            this.listingIdToListing.put(listing.getListingId(), listing);
        }
    }

    /**
     * Gets the Map of all listing IDs with the Listing entity
     * @return Map<String, Listing> of listing IDs and Listing
     */
    public Map<String, Listing> getListingIdToListing() {
        return this.listingIdToListing;
    }

    /** TODO: Taylan
     * Adds an listing to the system
     * @param
     * @param
     */
    public void addListing() {

    }
}
