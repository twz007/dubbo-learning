package world.twz.dubbo.registry;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import world.twz.dubbo.entity.Url;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * -------------------------------------------
 * File Name   :     RedisRegistry
 * Description :     直接用Spring的就没写原生的jedis代码了
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisRegistry implements Registry, InitializingBean {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean register(String interfaceName, Url url) {
        return stringRedisTemplate.opsForSet().add(interfaceName, url.getHost()+":"+url.getPort()) > 0;
    }

    @Override
    public Set<Url> get(String interfaceName) {
        Set<String> stringSet = stringRedisTemplate.opsForSet().members(interfaceName);
        return stringSet != null ? stringSet.stream().map(s -> {
            String[] strings = s.split(":");
            return new Url(strings[0], Integer.parseInt(strings[1]));
        }).collect(Collectors.toSet()) : new HashSet<>();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RegistryFactory.register("redisRegistry", this);
    }
}
