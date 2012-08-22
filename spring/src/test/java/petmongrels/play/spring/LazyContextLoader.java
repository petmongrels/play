package petmongrels.play.spring;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.w3c.dom.Element;

public class LazyContextLoader extends GenericXmlContextLoader {
    protected BeanDefinitionReader createBeanDefinitionReader(GenericApplicationContext context) {
        XmlBeanDefinitionReader r = (XmlBeanDefinitionReader) super.createBeanDefinitionReader(context);
        r.setDocumentReaderClass(LazyInitByDefaultBeanDefinitionDocumentReader.class);
        return r;
    }

    public static class LazyInitByDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {
        @Override
        protected BeanDefinitionParserDelegate createHelper(XmlReaderContext readerContext, Element root, BeanDefinitionParserDelegate parentDelegate) {
            if (!root.getAttributeNode(BeanDefinitionParserDelegate.DEFAULT_LAZY_INIT_ATTRIBUTE).getSpecified()) {
                root.setAttribute(BeanDefinitionParserDelegate.DEFAULT_LAZY_INIT_ATTRIBUTE, "true");
            }
            return super.createHelper(readerContext, root, parentDelegate);
        }
    }
}