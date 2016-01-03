//package org.framework.demo.init;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 项目初始化的一些参数
// * 跟随spring容器一起启动
// * @author junhui.ji
// *
// */
//public class SystemInit implements HttpSessionListener, ServletContextListener{
//	//log4j 日志
//	private final Logger log = LoggerFactory.getLogger(SystemInit.class);
//	@Override
//	public void contextDestroyed(ServletContextEvent arg0) {
//		log.info("servlet 容器开始销毁");
//
//	}
//
//	@Override
//	public void contextInitialized(ServletContextEvent arg0) {
//		log.info("servlet 容器开始初始化");
//
//	}
//
//	@Override
//	public void sessionCreated(HttpSessionEvent event) {
//		log.info("session 开始创建。。。。");
//		HttpSession session = event.getSession();
//		//获取项目根路径
//		String path = session.getServletContext().getContextPath();
//		//把app地址赋给AppPath
//		session.setAttribute("AppPath", path);
//		log.info("项目的根目录是：" + path);
//	}
//
//	@Override
//	public void sessionDestroyed(HttpSessionEvent arg0) {
//		log.info("session 开始销毁。。。。");
//
//	}
//
//}
