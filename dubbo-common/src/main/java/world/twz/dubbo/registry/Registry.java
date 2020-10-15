package world.twz.dubbo.registry;

import world.twz.dubbo.entity.Url;

import java.util.Set;

public interface Registry {
    boolean register(String interfaceName, Url url) throws Exception;
    Set<Url> get(String interfaceName) throws Exception;
}
