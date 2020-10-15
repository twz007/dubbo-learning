package world.twz.dubbo.factory;

import world.twz.dubbo.entity.Invocation;
import world.twz.dubbo.entity.Url;
import world.twz.dubbo.protocol.LoadBalance;
import world.twz.dubbo.protocol.ProtocolFactory;
import world.twz.dubbo.registry.LocalRegistry;
import world.twz.dubbo.registry.Registry;
import world.twz.dubbo.registry.RegistryFactory;

import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * -------------------------------------------
 * File Name   :     ProxyFactory
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
public class ProxyFactory {

    public static <T> T getProxy(final Class<T> interfaces, String version){
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, (proxy, method, args) -> {
            Invocation invocation = new Invocation(interfaces.getName(), method.getName(), args, method.getParameterTypes(), version);
            Registry registry = RegistryFactory.getRegistry();
            Set<Url> urls = LocalRegistry.get(interfaces.getName(), registry);
            Url url = LoadBalance.random(urls);
            return ProtocolFactory.getProtocol().send(url, invocation);
        });
    }

    public static <T> T getProxy(final Class<T> interfaces){
        return getProxy(interfaces, "");
    }
}
