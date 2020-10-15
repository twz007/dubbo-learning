package world.twz.dubbo.provider.service.registry;

import java.util.concurrent.ConcurrentHashMap;

/**
 * -------------------------------------------
 * File Name   :     ServiceRegistry
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
public class ServiceRegistry {
    private static final ConcurrentHashMap<String, Class<?>> SERVICE_MAP = new ConcurrentHashMap<>();

    public static void register(String interfaceName, Class<?> clazz){
        SERVICE_MAP.put(interfaceName, clazz);
    }

    public static Class<?> get(String interfaceName){
        return SERVICE_MAP.get(interfaceName);
    }

}
