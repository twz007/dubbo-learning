package world.twz.dubbo.registry;

import world.twz.dubbo.entity.Url;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * -------------------------------------------
 * File Name   :     LocalRegistry
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
public class LocalRegistry {

    /**
     * 本地缓存，注册中心挂了就靠这了
     */
    private final static Map<String, Set<Url>> PROVIDERS_MAP = new ConcurrentHashMap<>();

    public static void register(String interfaceName, Url url, Registry registry){
        Set<Url> urls = PROVIDERS_MAP.getOrDefault(interfaceName, new HashSet<>());
        urls.add(url);
        PROVIDERS_MAP.put(interfaceName,urls);
        try {
            registry.register(interfaceName, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<Url> get(String interfaceName, Registry registry){
        Set<Url> urls;
        try {
            urls = registry.get(interfaceName);
            PROVIDERS_MAP.put(interfaceName, urls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PROVIDERS_MAP.getOrDefault(interfaceName, new HashSet<>());
    }
}
