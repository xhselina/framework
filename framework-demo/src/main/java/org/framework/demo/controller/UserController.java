//package org.framework.demo.controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.framework.interfaces.UserService;
//import org.framework.model.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
///**
// * 用户控制层
// * @author junhui.ji
// *
// */
//@Controller
//@RequestMapping("/user/")
//public class UserController {
//	@Resource
//	private UserService userService;
//
//	/**
//	 * 打开user.jsp
//	 * @return
//	 */
//	@RequestMapping("getUserJsp.html")
//	public String index(){
//		return "user/user";
//	}
//
//	/**
//	 * 获取用户列表 分页
//	 * @param request
//	 * @param response
//	 * @param user 条件
//	 * @return
//	 */
//	@RequestMapping("getUserPage.html")
//	@ResponseBody
//	public Object getUserPage(HttpServletRequest request,HttpServletResponse response,User user,int page,int rows){
//		return userService.getUserMap((page - 1) * rows, rows, user);
//	}
//}
