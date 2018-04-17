package com.qx.cfg.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;

@Aspect
@Component
@Order(Integer.MAX_VALUE - 1)
public class HttpDataAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/*@Autowired
	IApilogService apilogService;
*/
	@SuppressWarnings("unchecked")
	@Around("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
	public Object requestMappingAspect(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) pjp;
		MethodSignature methodSign = (MethodSignature) methodJoinPoint.getSignature();
		String resp = "";
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			logger.error("[HTTP] process error:", e);
			if (methodSign.getReturnType().isAssignableFrom(HttpBaseBean.class)) {
				HttpBaseBean httpBaseBean = new HttpBaseBean();
				httpBaseBean.setCode(RespCode.SYS_ERR.getCode());
				httpBaseBean.setMessage(RespCode.SYS_ERR.getMsg());
				logger.info(httpBaseBean.toString());
				if (e instanceof BizException) {
					BizException bizException = (BizException) e;
					httpBaseBean.setCode(bizException.getCode());
					httpBaseBean.setMessage(bizException.getMessage());
				}
				result = httpBaseBean;
			}
		}
		//long time = System.currentTimeMillis() - startTime;
		resp = JSON.toJSONString(result);
		logger.info("resp : "+resp);
		return result;
	}
}
