package org.framework.demo.controller;

import org.framework.demo.model.User;
import org.framework.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户控制层
 * @author junhui.ji
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hello")
	@ResponseBody
	public String  hello(){
		return  "hello";
	}

	/**
	 * 打开user.jsp
	 * @return
	 */
	@RequestMapping("getUserJsp.html")
	public String index(){
		return "user/user";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request,ModelMap modelMap){
		User user = new User();
		user.setName("111");
		int num = userService.add(user);
		return "成功保存" + num + "条记录";
	}

	/**
	 * 获取用户列表 分页
	 * @param request
	 * @param response
	 * @param user 条件
	 * @return
	 */
	@RequestMapping("getUserPage.html")
	@ResponseBody
	public Object getUserPage(HttpServletRequest request,HttpServletResponse response,User user,int page,int rows){
		return null;
	}
}
