package world.twz.dubbo.protocol;


/**
 * -------------------------------------------
 * File Name   :     ProtocolFactory
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
public class ProtocolFactory {

    /**
     * 只模拟的http，所以这边直接返回了
     */
    public static Protocol getProtocol(){
        return new HttpProtocol();
    }
}
