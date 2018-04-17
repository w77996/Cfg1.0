package com.qx.cfg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Controller
public class CollectionController {
	/**
	 * 收藏
	 * @Title:           followUser
	 * @Description:     TODO
	 * @param:           @param open_id
	 * @param:           @param token
	 * @param:           @param blog_id
	 * @param:           @return   
	 * @return:          HttpBaseBean   
	 * @throws
	 */
	@RequestMapping("/collection")
	public HttpBaseBean collectionBlog(@RequestParam String open_id,@RequestParam String token,@RequestParam String blog_id){
		if(StringUtils.isAnyEmpty(open_id,token,blog_id)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		//关注用户
		return new HttpBaseBean();
	}
	/**
	 * 取消收藏
	 * @Title:           collectionCancel
	 * @Description:     TODO
	 * @param:           @param open_id
	 * @param:           @param token
	 * @param:           @param blog_id
	 * @param:           @return   
	 * @return:          HttpBaseBean   
	 * @throws
	 */
	@RequestMapping("/collection/cancel")
	public HttpBaseBean collectionCancel(@RequestParam String open_id,@RequestParam String token,@RequestParam String blog_id){
		if(StringUtils.isAnyEmpty(open_id,token,blog_id)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		//关注用户
		return new HttpBaseBean();
	}
	
	@RequestMapping("/collection/list")
	public HttpBaseBean collectionList(@RequestParam String open_id,@RequestParam String token,@RequestParam String blog_id){
		if(StringUtils.isAnyEmpty(open_id,token,blog_id)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		//关注用户
		return new HttpBaseBean();
	}

}
