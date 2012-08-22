package petmongrels.play.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml", loader = LazyContextLoader.class)
public class HowSpringWorksTest {
    @Autowired
    private YetAnotherBeanDefinedInXml yetAnotherBeanDefinedInXml;
    @Autowired
    private AnnotationBasedBeanTakingXmlBasedBean annotationBasedBeanTakingXmlBasedBean;

    @Test
    public void beanDefinedInXmlIsNotLoadedWhenDefaultLazyInitIsTrue() {
        assertEquals(false, BeanWithNoDependentDefinedInXml.isCalled);
    }

    @Test
    public void annotationBasedBeansInheritDefaultLazyInitValue() {
        assertEquals(false, AnnotationBasedBean.isCalled);
    }

    @Test
    public void beanDefinedViaXmlInAnotherApplicationContextFileIsAlsoNotInitializedWhenDefaultLazyInitIsUsed() {
        assertEquals(false, AnotherBeanDefinedInXml.isCalled);
    }

    @Test
    public void accessedBeansAreLazilyInitialized() {
        assertEquals(true, YetAnotherBeanDefinedInXml.isCalled);
    }
}