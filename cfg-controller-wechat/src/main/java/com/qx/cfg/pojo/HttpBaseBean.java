package com.qx.cfg.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







@com.fasterxml.jackson.databind.annotation.JsonSerialize
public class HttpBaseBean {

	
	private static Logger logger = LoggerFactory.getLogger(HttpBaseBean.class);
	
	protected int code;
	protected String message;
	protected Object data;

	public HttpBaseBean() {
		this.code = RespCode.SYS_OK.getCode();
		this.message = RespCode.SYS_OK.getMsg();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		logger.info(message+" "+" "+code);
		return super.toString();
		
	}
	/*public void setPageData(Pagination pagination, Object data) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("count", pagination.getTotalRows());
		dataMap.put("currentPage", pagination.getCurrentPage());
		dataMap.put("numsPerPage", pagination.getPageSize());
		dataMap.put("totalPages", pagination.getTotalPages());
		dataMap.put("data", data);
		this.data = dataMap;
	}*/
}
