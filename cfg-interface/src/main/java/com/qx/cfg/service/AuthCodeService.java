package com.qx.cfg.service;

import com.qx.cfg.pojo.AuthCode;

public interface AuthCodeService {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthCode record);

    int insertSelective(AuthCode record);

    AuthCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthCode record);

    int updateByPrimaryKey(AuthCode record);
}