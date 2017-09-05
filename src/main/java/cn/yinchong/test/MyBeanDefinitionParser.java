package cn.yinchong.test;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class MyBeanDefinitionParser implements BeanDefinitionParser {
    private final Class<?> beanClass;

    public MyBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(beanClass);
        String id = element.getAttribute("id");
        parserContext.getRegistry().registerBeanDefinition(id, rootBeanDefinition);
        if (beanClass.equals(MyConsumer.class)) {
            String ref = element.getAttribute("interface");
            rootBeanDefinition.getPropertyValues().addPropertyValue("ref", ref);
        }
        return rootBeanDefinition;
    }
}
