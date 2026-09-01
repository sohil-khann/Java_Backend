package org.example.springbootdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "org.example")
public class SpringBootDemo2Application {

    public static void main(String[] args) {
     ApplicationContext context= SpringApplication.run(SpringBootDemo2Application.class, args);

     context.getBean(PaymentService.class).pay();


    }
//    @Bean
//    public UserService userService(){
//        return new UserService();
//    }

}
