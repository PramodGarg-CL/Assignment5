package com.skeleton.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darknight on 4/5/17.
 */

public class Posts {

    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;

    /**
     * Getter
     *
     * @return : userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Setter
     *
     * @param userId : userId
     */
    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

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
     * @return : title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter
     *
     * @param title : title
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Getter
     *
     * @return : body
     */
    public String getBody() {
        return body;
    }

    /**
     * Setter
     *
     * @param body : body
     */
    public void setBody(final String body) {
        this.body = body;
    }

}

