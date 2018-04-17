package com.qx.cfg.dao;

import com.qx.cfg.pojo.WalletLog;

public interface WalletLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WalletLog record);

    int insertSelective(WalletLog record);

    WalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletLog record);

    int updateByPrimaryKey(WalletLog record);
}