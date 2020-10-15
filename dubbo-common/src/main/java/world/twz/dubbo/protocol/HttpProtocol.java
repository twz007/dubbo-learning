package world.twz.dubbo.protocol;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import world.twz.dubbo.entity.Invocation;
import world.twz.dubbo.entity.Url;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * -------------------------------------------
 * File Name   :     HttpProtocol
 * Description :
 * Author      :     Administrator
 * Date        :     2020/10/14
 * -------------------------------------------
 **/
public class HttpProtocol implements Protocol{

    @Override
    public Object send(Url url, Invocation invocation) throws Exception {
        URL url1 = new URL("http", url.getHost(), url.getPort(), "/getProxy");
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url1.openConnection();
        httpUrlConnection.setRequestMethod("POST");
        httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");
        httpUrlConnection.setDoOutput(true);
        OutputStream outputStream = httpUrlConnection.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(invocation);
        oos.flush();
        oos.close();
        InputStream inputStream = httpUrlConnection.getInputStream();
        return new ObjectInputStream(inputStream).readObject();
    }
}
