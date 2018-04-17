package com.qx.cfg.service;

import com.qx.cfg.pojo.WalletLog;

public interface WalletLogService {
    int deleteByPrimaryKey(Integer id);

    int insert(WalletLog record);

    int insertSelective(WalletLog record);

    WalletLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WalletLog record);

    int updateByPrimaryKey(WalletLog record);
}