package com.ray.entity;

public class Css {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column css.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column css.res_link_id
     *
     * @mbggenerated
     */
    private Integer resLinkId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column css.csslink
     *
     * @mbggenerated
     */
    private String csslink;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column css.androidlink
     *
     * @mbggenerated
     */
    private String androidlink;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column css.id
     *
     * @return the value of css.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column css.id
     *
     * @param id the value for css.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column css.res_link_id
     *
     * @return the value of css.res_link_id
     *
     * @mbggenerated
     */
    public Integer getResLinkId() {
        return resLinkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column css.res_link_id
     *
     * @param resLinkId the value for css.res_link_id
     *
     * @mbggenerated
     */
    public void setResLinkId(Integer resLinkId) {
        this.resLinkId = resLinkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column css.csslink
     *
     * @return the value of css.csslink
     *
     * @mbggenerated
     */
    public String getCsslink() {
        return csslink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column css.csslink
     *
     * @param csslink the value for css.csslink
     *
     * @mbggenerated
     */
    public void setCsslink(String csslink) {
        this.csslink = csslink == null ? null : csslink.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column css.androidlink
     *
     * @return the value of css.androidlink
     *
     * @mbggenerated
     */
    public String getAndroidlink() {
        return androidlink;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column css.androidlink
     *
     * @param androidlink the value for css.androidlink
     *
     * @mbggenerated
     */
    public void setAndroidlink(String androidlink) {
        this.androidlink = androidlink == null ? null : androidlink.trim();
    }
}