package com.qx.cfg.service;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.cfg.dao.TokenMapper;
import com.qx.cfg.pojo.Token;
import com.qx.cfg.util.Utils;
@Service
public class TokenServiceImpl implements TokenService{
	
	@Autowired
	TokenMapper tokenMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return tokenMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Token record) {
		// TODO Auto-generated method stub
		return tokenMapper.insert(record);
	}

	@Override
	public int insertSelective(Token record) {
		// TODO Auto-generated method stub
		return tokenMapper.insertSelective(record);
	}

	@Override
	public Token selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return tokenMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Token record) {
		// TODO Auto-generated method stub
		return tokenMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Token record) {
		// TODO Auto-generated method stub
		return tokenMapper.updateByPrimaryKey(record);
	}

	@Override
	public String genToken(String open_id) {
		// TODO Auto-generated method stub
		long timestamp = System.currentTimeMillis();
		int randomCode = Utils.randomInt(10, 10000);
		String otoken = "U" + timestamp + open_id + "-" + randomCode;
		// md5 签名
		String token = Utils.getMD5(otoken);

		// save to db
		/*Timestamp now = Utils.getCurrentTimestamp();
		jdbcTemplate.update("replace into token_info (token, user_id, createtime) values (?,?,?)",
				new Object[] { token, userId, now }, new int[] { Types.VARCHAR, Types.INTEGER, Types.TIMESTAMP });
*/		
		Token tokenBean = new Token();
		tokenBean.setCreateTime(Integer.parseInt(timestamp+""));
		tokenBean.setToken(token);
		tokenBean.setOpenId(open_id);
		tokenMapper.updateByPrimaryKey(tokenBean);
		return token;
	}

}
