package org.framework.demo;

import org.framework.springboot.BaseSpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeffrey
 * @version v1.0
 * @date 16-1-7 下午10:53
 */
//@SpringBootApplication
//@ImportResource("classpath:spring/applicationContext.xml")
@RestController
public class Client extends BaseSpringBootApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World，你妹!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Client.class, args);
    }
}
