package com.qx.cfg.service;

import com.qx.cfg.pojo.PrivateMessage;

public interface PrivateMessageService {
    int deleteByPrimaryKey(Long id);

    int insert(PrivateMessage record);

    int insertSelective(PrivateMessage record);

    PrivateMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PrivateMessage record);

    int updateByPrimaryKey(PrivateMessage record);
}