package com.qx.cfg.dao;

import com.qx.cfg.pojo.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
    /**
     * 添加更新token
     * @Title:           updateTokenByOpenId
     * @Description:     TODO
     * @param:           @param record
     * @param:           @return   
     * @return:          int   
     * @throws
     */
    int updateTokenByOpenId(Token record);
}