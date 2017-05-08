
package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model Class
 */
public class Geo {

    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    /**
     * Getter
     * @return lat :lat
     */
    public String getLat() {
        return lat;
    }
    /**
     * Setter
     * @param  lat : latitude
     */
    public void setLat(final String lat) {
        this.lat = lat;
    }

    /**
     * Getter
     * @return lng : lng
     */
    public String getLng() {
        return lng;
    }
    /**
     * Setter
     * @param  lng : lng
     */
    public void setLng(final String lng) {
        this.lng = lng;
    }

}
