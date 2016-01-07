package org.china.framework.spring.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by junhuiji on 2016/1/6.
 */
public class Client {
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {

        System.setProperty("test.log4j.dir", "D://logs//");

        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");

        logger.warn("this is earn message");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
