package com.qx.cfg.service;

import com.qx.cfg.pojo.Collections;

public interface CollectionsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}