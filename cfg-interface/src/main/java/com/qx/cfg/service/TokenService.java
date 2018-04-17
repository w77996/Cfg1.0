package com.qx.cfg.service;

import com.qx.cfg.pojo.Token;

public interface TokenService {
    int deleteByPrimaryKey(Integer id);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
    
    String genToken(String open_id);
}