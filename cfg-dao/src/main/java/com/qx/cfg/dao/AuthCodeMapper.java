package com.qx.cfg.dao;

import com.qx.cfg.pojo.AuthCode;

public interface AuthCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthCode record);

    int insertSelective(AuthCode record);

    AuthCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthCode record);

    int updateByPrimaryKey(AuthCode record);
}