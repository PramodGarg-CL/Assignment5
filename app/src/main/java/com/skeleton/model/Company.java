
package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model Class
 */
public class Company {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    /**
     * Getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name : name
     */

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return catchPhrase
     */

    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * Setter
     * @param catchPhrase : catchPhrase
     */
    public void setCatchPhrase(final String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * Getter
     *
     * @return bs
     */
    public String getBs() {
        return bs;
    }
    /**
     * Setter
     * @param bs : bs
     */
    public void setBs(final String bs) {
        this.bs = bs;
    }

}
