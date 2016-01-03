package org.framework.core.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常用的工具类
 * 
 * @author junhui.ji
 * 
 */
public class CommonUtil {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

//	/**
//	 * 判断一个对象是否为null true is null flase is not null
//	 * 
//	 * @param obj
//	 * @return
//	 */
//	public static boolean isNull(Object obj) {
//		boolean flag = true;
//		if (null != obj) {// 判断是否为null
//			if (obj instanceof String) {// 判断是否是字符串
//				String str = (String) obj;
//				if (!str.equals("") && str.length() > 0) {
//					flag = false;
//				}
//			} else if (obj instanceof List) {// 判断是否是List
//				List<T> list = (List<T>) obj;
//				if (list.size() > 0) {
//					flag = false;
//				}
//			} else if (obj instanceof Map) {// 判断是否为map
//				@SuppressWarnings("unchecked")
//				Map<Object, Object> map = (Map<Object, Object>) obj;
//				if (map.size() > 0) {
//					flag = false;
//				}
//			}else if(obj instanceof Integer || obj instanceof Long || obj instanceof Double){
//				flag = false;
//			}
//		}
//		return flag;
//	}

	/**
	 * 获取UUID
	 */
	public static synchronized String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 将一个对象复制给另一个对象 根据名字
	 * 
	 * @param des
	 * @param raw
	 * @return
	 */
	public static void objectConvertObject(Object dest, Object source) {
		try {
			// 获取属性
			BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
			PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();
			BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
			PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
			for (int i = 0; i < sourceProperty.length; i++) {
				for (int j = 0; j < destProperty.length; j++) {
					if (sourceProperty[i].getName().equals(destProperty[j].getName())) {
						// 调用source的getter方法和dest的setter方法
						destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
