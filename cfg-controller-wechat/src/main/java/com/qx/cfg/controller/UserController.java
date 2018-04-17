package com.qx.cfg.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.cfg.exception.BizException;
import com.qx.cfg.pojo.HttpBaseBean;
import com.qx.cfg.pojo.RespCode;
import com.qx.cfg.pojo.User;
import com.qx.cfg.service.TokenService;
import com.qx.cfg.service.UserService;
import com.qx.cfg.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/showUser")
    public String showUser(Model model){
        log.info("查询所有用户信息");
        User userList = userService.selectByPrimaryKey(1);
        log.error(" "+userList.getUserName());
        model.addAttribute("userList",userList);
        return "showUser";
    }
    
    @RequestMapping("/index")
    public String showIndex(Model model){
       
        return "index";
    }
    
    @RequestMapping("/show")
    public void show(){
        log.info("查询所有用户信息");
        User userList = userService.selectByPrimaryKey(1);
        log.error(" "+userList.getUserName());
        System.out.println(userList.getUserName());
       // model.addAttribute("userList",userList);
      
    }
    
    @RequestMapping("/login")
    public HttpBaseBean login(HttpServletRequest request,@RequestParam String open_id,@RequestParam String code){
    	if (StringUtils.isAnyEmpty(open_id, code)) {
			throw new BizException(RespCode.NOTEXIST_PARAM);
    	}
    	//获取open_id和session_key
    	//String result = 
    	//生成token存入数据库
    	
    	//发送token和open_id值客户端
    	String token = tokenService.genToken(open_id);
    	return new HttpBaseBean();
    }
    
    @RequestMapping("/auth_code")
    public HttpBaseBean userAuthCode(@RequestParam String open_id,@RequestParam String token,@RequestParam String phone){
    	if (StringUtils.isAnyEmpty(open_id, token,phone)) {
			throw new BizException(RespCode.NOTEXIST_PARAM);
    	}
    
    	
    	return new HttpBaseBean();
    }
    
    @RequestMapping("/updateinfo")
    public HttpBaseBean userUpdate(@RequestParam String open_id,@RequestParam String token,@RequestParam User user){
    	if (StringUtils.isAnyEmpty(open_id, token)) {
			throw new BizException(RespCode.NOTEXIST_PARAM);
    	}
    	log.error(user.toString());
    	
    	return new HttpBaseBean();
    }
    
    @RequestMapping("/getinfo")
    public HttpBaseBean userGetInfo(@RequestParam String open_id,@RequestParam String token){
    	if (StringUtils.isAnyEmpty(open_id, token)) {
			throw new BizException(RespCode.NOTEXIST_PARAM);
    	}
    	
    	
    	return new HttpBaseBean();
    }
    
    @RequestMapping("/getinfo/detail")
    public HttpBaseBean userGetInfoDetail(@RequestParam String open_id,@RequestParam String token){
    	if (StringUtils.isAnyEmpty(open_id, token)) {
			throw new BizException(RespCode.NOTEXIST_PARAM);
    	}
    	User user = userService.selectUserbyOpenId(open_id);
    	HttpBaseBean result = new HttpBaseBean();
    	if(null != user){
    		result.setData(user);
    	}
    	return result;
    }
}