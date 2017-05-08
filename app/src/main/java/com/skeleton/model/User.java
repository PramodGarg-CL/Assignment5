
package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Model Class
 */
public class User implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("company")
    @Expose
    private Company company;

    /**
     * Getter
     *
     * @return : id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id : id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return :  name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name : name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return :  username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     *
     * @param username : username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Getter
     *
     * @return :  email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     *
     * @param email : email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Getter
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter
     *
     * @param address : address
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * Getter
     *
     * @return :  phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter
     *
     * @param phone : phone
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Getter
     *
     * @return :  website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Setter
     *
     * @param website : website
     */
    public void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * Getter
     *
     * @return :  company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Setter
     *
     * @param company : company
     */
    public void setCompany(final Company company) {
        this.company = company;
    }

}
