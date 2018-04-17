package com.qx.cfg.pojo;

public class UserFollow {
    private Integer id;

    private String openId;

    private Integer followOpenId;

    private Integer followTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getFollowOpenId() {
        return followOpenId;
    }

    public void setFollowOpenId(Integer followOpenId) {
        this.followOpenId = followOpenId;
    }

    public Integer getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Integer followTime) {
        this.followTime = followTime;
    }
}