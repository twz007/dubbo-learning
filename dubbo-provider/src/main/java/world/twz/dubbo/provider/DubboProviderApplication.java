package world.twz.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -------------------------------------------
 * File Name   :     DubboProviderApplication
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
@SpringBootApplication(scanBasePackages = { "world.twz.dubbo.registry", "world.twz.dubbo.provider"})
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
