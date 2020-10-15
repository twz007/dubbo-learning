package world.twz.dubbo.provider.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import world.twz.dubbo.entity.Url;
import world.twz.dubbo.provider.service.registry.ServiceRegistry;
import world.twz.dubbo.registry.LocalRegistry;
import world.twz.dubbo.registry.RegistryFactory;
import world.twz.dubbo.service.HelloService;

import java.util.Arrays;
import java.util.Collection;

/**
 * -------------------------------------------
 * File Name   :     HelloServiceImpl
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
@Service
public class HelloServiceImpl implements HelloService, InitializingBean {

    @Value("${dubbo.provider.host:127.0.0.1}")
    private String host;
    @Value("${dubbo.provider.port:8001}")
    private String port;


    @Override
    public void sayHello() {
        System.out.println("hello world！");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    @Override
    public String getName() {
        return "zhangsan";
    }

    @Override
    public Collection<String> getNames() {
        return Arrays.asList("zhangsan", "lisi", "wangwu");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //注册到本地服务列表
        ServiceRegistry.register(HelloService.class.getName(), HelloServiceImpl.class);
        //将当前生产者注册到远程服务中心
        LocalRegistry.register(HelloService.class.getName(), new Url(host, Integer.parseInt(port)), RegistryFactory.getRegistry());
    }
}
