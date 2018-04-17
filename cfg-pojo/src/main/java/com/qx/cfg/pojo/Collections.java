package com.qx.cfg.pojo;

public class Collections {
    private Integer id;

    private String openId;

    private Integer blogId;

    private Integer collectionCreateTime;

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

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getCollectionCreateTime() {
        return collectionCreateTime;
    }

    public void setCollectionCreateTime(Integer collectionCreateTime) {
        this.collectionCreateTime = collectionCreateTime;
    }
}