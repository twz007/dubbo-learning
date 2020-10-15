package world.twz.dubbo.provider.service.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import world.twz.dubbo.entity.Invocation;
import world.twz.dubbo.provider.service.registry.ServiceRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;

/**
 * -------------------------------------------
 * File Name   :     ProxyController
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
@RestController
public class ProxyController implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @PostMapping(value = "/getProxy")
    public void getProxy(HttpServletRequest request, HttpServletResponse response) throws Exception{
        InputStream inputStream = request.getInputStream();
        ObjectInputStream objInStream = new ObjectInputStream(inputStream);
        Invocation invocation = (Invocation) objInStream.readObject();
        Class<?> clazz = ServiceRegistry.get(invocation.getInterfaceName());
        Method method = clazz.getMethod(invocation.getMethodName(), invocation.getArgsTypes());
        //这里直接byType了，需要扩展再改
        Object o = method.invoke(applicationContext.getBean(clazz), invocation.getArgs());
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(response.getOutputStream())) {
            objectOutputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
