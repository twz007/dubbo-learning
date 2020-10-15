package world.twz.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * -------------------------------------------
 * File Name   :     Invocation
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] args;
    private Class[] argsTypes;
    private String version;
}
