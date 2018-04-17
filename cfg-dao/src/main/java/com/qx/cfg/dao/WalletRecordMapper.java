package com.qx.cfg.dao;

import com.qx.cfg.pojo.WalletRecord;

public interface WalletRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WalletRecord record);

    int insertSelective(WalletRecord record);

    WalletRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletRecord record);

    int updateByPrimaryKey(WalletRecord record);
}