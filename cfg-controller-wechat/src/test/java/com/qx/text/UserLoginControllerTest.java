package com.qx.text;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.qx.cfg.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)  //此处调用Spring单元测试类  
@WebAppConfiguration    //调用javaWEB的组件，比如自动注入ServletContext Bean等等  
@ContextConfiguration("classpath:spring-mvc.xml")//加载Spring配置文件  
public class UserLoginControllerTest {
	
	/*@Autowired
	UserController userController;
	@Autowired
	 WebApplicationContext wac;
	MockMvc mockMvc;  
	@Before  
	public void setup(){  
		 mockMvc = MockMvcBuilders.standaloneSetup(wac).build();  
	  
	}  
	 @Test  
	    public void getArticleListTest() throws Exception{  
		 ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/login"));
	        MvcResult mvcResult = resultActions.andReturn();
	        String result = mvcResult.getResponse().getContentAsString();
	        System.out.println("=====客户端获得反馈数据:" + result); 
	          
	    }  */
	
	

}
