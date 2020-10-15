package world.twz.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -------------------------------------------
 * File Name   :     Url
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/13
 * -------------------------------------------
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private String host;
    private int port;
}
