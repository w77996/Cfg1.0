
项目说明：
	
	技术选型：Spring+Spring MVC+Mybatis+Dubbo
	开发工具：MyEclipse
	JDK版本：1.7

使用说明：

	1.导入t_user至数据库

	2.修改cfg-service-webchat下的jdbc.properties中数据库用户名和密码

	3.导入cfg-service-wechat至tomcat1,导入cfg-controller-wechat至tomcat2

	4.启动tomcat1,再启动tomcat2

	5.访问http://localhost:8080/cfg-controller-wechat/user/showUser，显示结果