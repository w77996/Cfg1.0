package com.qx.cfg.dao;

import com.qx.cfg.pojo.Collections;

public interface CollectionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}