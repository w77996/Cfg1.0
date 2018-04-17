package com.qx.cfg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Controller
@RequestMapping("/main")
public class PictureController {
	
	@RequestMapping("/picture")
	public HttpBaseBean getMainPicture(){
		
		return new HttpBaseBean();
	}

}
