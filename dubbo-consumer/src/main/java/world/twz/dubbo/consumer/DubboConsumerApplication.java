package world.twz.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -------------------------------------------
 * File Name   :     DubboConsumerApplication
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
@SpringBootApplication(scanBasePackages = { "world.twz.dubbo.registry", "world.twz.dubbo.consumer"})
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
