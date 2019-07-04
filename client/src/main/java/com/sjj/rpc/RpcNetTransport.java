package com.sjj.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName RpcNetTransport
 * @Description TODO
 * Author shengjunjie
 * Date 2019/7/4 11:01
 **/
public class RpcNetTransport {

    private String host;
    private Integer port;

    public RpcNetTransport(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request){
        Socket socket=null;
        Object result=null;
        ObjectOutputStream outputStream=null;
        ObjectInputStream inputStream=null;

        try {
            socket = new Socket(host,port);

            //写出结果
            outputStream  = new ObjectOutputStream(socket.getOutputStream());
            //序列化
            outputStream.writeObject(request);
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
            //读出结果
            result = inputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
