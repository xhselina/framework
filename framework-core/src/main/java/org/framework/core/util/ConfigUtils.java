package org.framework.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 配置工具类
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/1/12 18:27.
 */
public class ConfigUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);
    /**
     * Java 语言提供了一种稍弱的同步机制,即 volatile 变量.
     * 用来确保将变量的更新操作通知到其他线程,保证了新值能立即同步到主内存,以及每次使用前立即从主内存刷新.
     * 当把变量声明为volatile类型后,编译器与运行时都会注意到这个变量是共享的.
     */
    private static volatile Properties properties = new Properties();
    /**
     * transient 用关键词 transient修饰以后  改属性不会被 序列化，生命周期 只在内存中
     */
    private static transient volatile List<String> defaultScanPatterns = new ArrayList();

    /**
     * 默认的构造器
     */
    public ConfigUtils(){}
}
