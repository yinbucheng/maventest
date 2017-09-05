package cn.yinchong.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcServiceBeanProxy implements InvocationHandler {
    private Class targetClass;
    private Object target;

    public RpcServiceBeanProxy(Class targetClass) {
        this.targetClass = targetClass;
        try {
            target = targetClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begian");
        Object result = method.invoke(target, args);
        System.out.println("end");
        return result;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
