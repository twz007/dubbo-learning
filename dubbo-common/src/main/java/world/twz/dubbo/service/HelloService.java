package world.twz.dubbo.service;

import java.util.Collection;

/**
 * -------------------------------------------
 * File Name   :     helloService
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
public interface HelloService {
    void sayHello();
    void sayHello(String name);
    String getName();
    Collection<String> getNames();
}
