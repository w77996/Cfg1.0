package com.qx.cfg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@RequestMapping("/list")
	public HttpBaseBean followList(@RequestParam String open_id,@RequestParam String token,@RequestParam String page,@RequestParam String size){
		if(StringUtils.isAnyEmpty(open_id,token,page,size)){
			throw new BizException(RespCode.NOTEXIST_PARAM);
		}
		return new HttpBaseBean();
	}

}
