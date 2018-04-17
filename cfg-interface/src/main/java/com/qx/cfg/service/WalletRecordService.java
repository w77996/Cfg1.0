package com.qx.cfg.service;

import com.qx.cfg.pojo.WalletRecord;

public interface WalletRecordService {
    int deleteByPrimaryKey(Integer id);

    int insert(WalletRecord record);

    int insertSelective(WalletRecord record);

    WalletRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletRecord record);

    int updateByPrimaryKey(WalletRecord record);
}