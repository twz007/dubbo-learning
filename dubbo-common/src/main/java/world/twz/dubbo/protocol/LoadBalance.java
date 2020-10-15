package world.twz.dubbo.protocol;

import world.twz.dubbo.entity.Url;

import java.util.Collection;
import java.util.Random;

/**
 * -------------------------------------------
 * File Name   :     LoadBalance
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
public class LoadBalance {

    public static Url random(Collection<Url> urls){
        return (Url) urls.toArray()[new Random().nextInt(urls.size())];
    }
}
