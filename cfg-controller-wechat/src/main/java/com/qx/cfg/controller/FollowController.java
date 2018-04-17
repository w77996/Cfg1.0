package com.qx.cfg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Controller
@RequestMapping("/follow")
public class FollowController {
	/**
	 * 关注用户
	 * @Title:           followUser
	 * @Description:     TODO
	 * @param:           @param open_id
	 * @param:           @param token
	 * @param:           @param follow_id
	 * @param:           @return   
	 * @return:          HttpBaseBean   
	 * @throws
	 */
	@RequestMapping("/user")
	public HttpBaseBean followUser(@RequestParam String open_id,@RequestParam String token,@RequestParam String follow_id){
		if(StringUtils.isAnyEmpty(open_id,token,follow_id)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		//关注用户
		return new HttpBaseBean();
	}
	/**
	 * 取消关注
	 * @Title:           cancelFollow
	 * @Description:     TODO
	 * @param:           @param open_id
	 * @param:           @param token
	 * @param:           @param follow_id
	 * @param:           @return   
	 * @return:          HttpBaseBean   
	 * @throws
	 */
	@RequestMapping("/cancel")
	public HttpBaseBean followCancel(@RequestParam String open_id,@RequestParam String token,@RequestParam String follow_id){
		if(StringUtils.isAnyEmpty(open_id,token,follow_id)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}
	/**
	 * 显示关注列表
	 * @Title:           listFollow
	 * @Description:     TODO
	 * @param:           @param open_id
	 * @param:           @param token
	 * @param:           @param page
	 * @param:           @param size
	 * @param:           @return   
	 * @return:          HttpBaseBean   
	 * @throws
	 */
	@RequestMapping("/list")
	public HttpBaseBean followList(@RequestParam String open_id,@RequestParam String token,@RequestParam String page,@RequestParam String size){
		if(StringUtils.isAnyEmpty(open_id,token,page,size)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}

}
