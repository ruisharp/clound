package com.example.control;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.service.UserSevice;

/**
 * 
 * 
 * 关键字@RestController代表这个类是用Restful风格来访问的，如果是普通的WEB页面访问跳转时，我们通常会使用@Controller
value = "/users/{username}" 代表访问的URL是"http://host:PORT/users/实际的用户名"
method = RequestMethod.GET 代表这个HTTP请求必须是以GET方式访问
consumes="application/json" 代表数据传输格式是json
@PathVariable将某个动态参数放到URL请求路径中
@RequestParam指定了请求参数名称
 * 
 * 
 * 
 * */
//@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserControl {
	@Autowired
	private UserSevice userSevice;
	
	@RequestMapping(value="/get/{id}" , method = RequestMethod.GET )  
    @ResponseBody
	private User getOneUser(@PathVariable long id){
		User user = userSevice.findByID(id);
		return user;
		
	}

	public UserSevice getUserSevice() {
		return userSevice;
	}

	public void setUserSevice(UserSevice userSevice) {
		this.userSevice = userSevice;
	}

	
}
