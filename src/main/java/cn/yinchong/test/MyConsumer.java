package cn.yinchong.test;

import javafx.fxml.Initializable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.net.URL;
import java.util.ResourceBundle;

public class MyConsumer implements Initializable, FactoryBean, ApplicationContextAware, BeanNameAware, DisposableBean {
    private String id;
    private String ref;
    private Class objectType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setBeanName(String s) {

    }

    public void destroy() throws Exception {

    }

    public Object getObject() throws Exception {
        objectType = Class.forName(ref);
        RpcServiceBeanProxy proxy = new RpcServiceBeanProxy(objectType);
        return proxy.getProxyObject();
    }

    public Class<?> getObjectType() {
        try {
            Class<?> clazz = Class.forName(ref);
            if (clazz.getInterfaces() != null) {
                objectType = clazz;
                return clazz;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setObjectType(Class objectType) {
        this.objectType = objectType;
    }

    public boolean isSingleton() {
        return false;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
