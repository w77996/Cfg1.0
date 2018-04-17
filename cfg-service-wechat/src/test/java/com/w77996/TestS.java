package com.w77996;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.qx.cfg.dao.CommentMapper;
import com.qx.cfg.dao.UserMapper;
import com.qx.cfg.pojo.Comment;
import com.qx.cfg.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestS {

	/*@Autowired
	private UserService userService;
	@Autowired
	private TestBookService testBookService;*/
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testAdd() throws Exception {
		
	/*	List<User> users = userService.getAllUser();
		System.out.println(users.size());
		TestBook testBook = testBookService.findById("1000");
		System.out.println(testBook.getBookName());*/
		/*Comment comments = commentMapper.selectByPrimaryKey(5);
		System.out.println(comments.getContent());*/
		
		User user = userMapper.selectUserByOpenId("2");
		System.out.println(user.getAddress());
		
	}
	
	@Test
    public void testPageHelper() {
        // 创建一个spring容器
       // ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*");
        // 从spring容器中获取mapper代理对象
       // TbItemMapper mapper = context.getBean(TbItemMapper.class);
        // 执行查询并分页,TbItemExample是逆向工程自动生成的，用来进行条件查询，这里不设置则表示无条件
      //  TbItemExample example = new TbItemExample();
        //分页处理，显示第一页的10条数据c
		 //PageHelper.startPage(1, 1);
	/*	 PageHelper.startPage(1, 10, "create_time DESC");
		List<User> users = userService.getAllUser();
       
        //List<TbItem> list = mapper.selectByExample(example);//查询
        // 取商品列表
        for(User item : users) {
            System.out.println(users.toString());
        }
        // 取分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        long total = pageInfo.getTotal(); //获取总记录数
        Map<String,Object> map = new HashMap<>();
        map.put("code", pageInfo);
        System.out.println("共有商品信息：" + JSONObject.toJSONString(map)+"\n");*/
        
    }
}
