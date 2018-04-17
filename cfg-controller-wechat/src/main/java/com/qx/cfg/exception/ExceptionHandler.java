package com.qx.cfg.exception;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

public class ExceptionHandler implements HandlerExceptionResolver {

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
				HttpBaseBean httpBaseBean = new HttpBaseBean();
				if (ex instanceof BizException) {
					BizException bizException = (BizException) ex;
					httpBaseBean.setCode(bizException.getCode());
					httpBaseBean.setMessage(bizException.getMessage());
				}
						
		return null;
	}

}
