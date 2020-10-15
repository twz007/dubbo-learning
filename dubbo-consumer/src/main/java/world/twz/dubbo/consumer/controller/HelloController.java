package world.twz.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.twz.dubbo.factory.ProxyFactory;
import world.twz.dubbo.service.HelloService;

import java.util.Collection;

/**
 * -------------------------------------------
 * File Name   :     HelloController
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final HelloService helloService = ProxyFactory.getProxy(HelloService.class);

    @GetMapping("/sayHello1")
    public void sayHello1(){
        helloService.sayHello();
    }
    @GetMapping("/sayHello2")
    public void sayHello2(){
        helloService.sayHello("zhangsan");
    }
    @GetMapping("/getName")
    public String getName(){
        return helloService.getName();
    }
    @GetMapping("/getNames")
    public Collection<String> getNames(){
        return helloService.getNames();
    }
}
