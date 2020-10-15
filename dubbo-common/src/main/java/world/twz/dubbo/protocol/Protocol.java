package world.twz.dubbo.protocol;

import world.twz.dubbo.entity.Invocation;
import world.twz.dubbo.entity.Url;


public interface Protocol {

    Object send(Url url, Invocation invocation) throws Exception;
}
