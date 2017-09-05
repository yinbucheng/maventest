package cn.yinchong.test;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class PeopleNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
