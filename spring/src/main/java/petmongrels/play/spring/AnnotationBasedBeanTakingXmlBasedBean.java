package petmongrels.play.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBasedBeanTakingXmlBasedBean {
    private BeanDefinedInXml beanDefinedInXml;

    @Autowired
    public AnnotationBasedBeanTakingXmlBasedBean(@Qualifier("beanDefinedInXml") BeanDefinedInXml beanDefinedInXml) {
        this.beanDefinedInXml = beanDefinedInXml;
    }
}