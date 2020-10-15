package world.twz.dubbo.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * -------------------------------------------
 * File Name   :     RegistryFactory
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
public class RegistryFactory {

    private static final Map<String, Registry> REGISTRY_MAP = new ConcurrentHashMap<>(16);
    /**
     * 只模拟一个
     * @return
     */
    public static void register(String name, Registry registry){
        REGISTRY_MAP.put(name, registry);
    }
    /**
     * 只模拟一个
     * @return
     */
    public static Registry getRegistry(){
        return getRegistry("redisRegistry");
    }
    /**
     * 只模拟一个
     * @return
     */
    public static Registry getRegistry(String name){
        if(!REGISTRY_MAP.containsKey(name))throw new NullPointerException("invaid registry type, it allows `redisRegistry`");
        return REGISTRY_MAP.get(name);
    }
}
