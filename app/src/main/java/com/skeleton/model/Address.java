
package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model Class
 */
public class Address {

    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("suite")
    @Expose
    private String suite;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    /**
     * Getter
     * @return street
     */
    public String getStreet() {
        return street;
    }
    /**
     * Setter
     * @param street : street
     */

    public void setStreet(final String street) {
        this.street = street;
    }

    /**
     * Getter
     * @return suite
     */

    public String getSuite() {
        return suite;
    }
    /**
     * Setter
     * @param suite : suite
     */
    public void setSuite(final String suite) {
        this.suite = suite;
    }

    /**
     * Getter
     * @return city
     */

    public String getCity() {
        return city;
    }


    /**
     * Setter
     * @param city : city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Getter
     * @return zipcode
     */

    public String getZipcode() {
        return zipcode;
    }

    /**
     * Setter
     * @param zipcode : zipcode
     */

    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Getter
     * @return Geo
     */

    public Geo getGeo() {
        return geo;
    }

    /**
     * Setter
     * @param geo : geo
     */
    public void setGeo(final Geo geo) {
        this.geo = geo;
    }

}
