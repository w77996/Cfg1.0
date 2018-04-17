package com.qx.cfg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.Blog;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@RequestMapping("/question")
	public HttpBaseBean blogQuestion(@RequestParam String open_id,@RequestParam String token,@RequestParam Blog blog){
		if(StringUtils.isAnyEmpty(open_id,token)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}
	
	@RequestMapping("/update")
	public HttpBaseBean blogUpdate(@RequestParam String open_id,@RequestParam String token,@RequestParam Blog blog){
		if(StringUtils.isAnyEmpty(open_id,token)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}
	
	@RequestMapping("/delete")
	public HttpBaseBean blogDelete(@RequestParam String open_id,@RequestParam String token,@RequestParam int blog_id){
		if(StringUtils.isAnyEmpty(open_id,token)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}
	
	@RequestMapping("/list")
	public HttpBaseBean blogList(@RequestParam String open_id,@RequestParam String token,@RequestParam int page,@RequestParam int size){
		if(StringUtils.isAnyEmpty(open_id,token)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}
	
	@RequestMapping("/detail")
	public HttpBaseBean blogDetail(@RequestParam String open_id,@RequestParam String token,@RequestParam int blog_id){
		if(StringUtils.isAnyEmpty(open_id,token)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}

}
