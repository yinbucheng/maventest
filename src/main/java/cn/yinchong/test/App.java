package cn.yinchong.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        People people = (People) context.getBean("test1");
        System.out.println(people.getName());
        UserService userService = (UserService) context.getBean("test2");
        userService.login("尹冲", "123");
    }
}
