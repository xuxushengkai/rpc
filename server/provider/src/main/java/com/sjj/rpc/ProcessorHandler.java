package com.sjj.rpc;

import org.springframework.util.StringUtils;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @ClassName ProcessorHandler
 * @Description TODO
 * Author shengjunjie
 * Date 2019/7/3 20:10
 **/
public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Map<String, Object> handlerMap;

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            //写入对象
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);

            //回显数据
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String serviceName = rpcRequest.getClassName();
        String version = rpcRequest.getVersion();
        //通过版本号判断
        if (!StringUtils.isEmpty(version)) {
            serviceName += "-" + version;
        }

        Object service = handlerMap.get(serviceName);
        if (service == null) {
            //判断是否有方法进入
            throw new RuntimeException("service not found:" + serviceName);
        }

        Object[] args = rpcRequest.getParameters();
        Method method = null;

        if (null != args) {
            Class<?>[] types = new Class[args.length];
            for(int i =0;i<args.length;i++){
                //反射参数
                types[i] = args[i].getClass();
            }
            //获取对象
            Class clazz =Class.forName(rpcRequest.getClassName());
            //获取方法
            method = clazz.getMethod(rpcRequest.getMethodName(),types);
        }else{
            Class clazz  = Class.forName(rpcRequest.getClassName());
            method = clazz.getMethod(rpcRequest.getMethodName());
        }

        Object result = method.invoke(service,args);
        return result;
    }
}
