package petmongrels.play.spring;

import org.springframework.stereotype.Component;

@Component
public class AnnotationBasedBean {
    public static boolean isCalled;

    public AnnotationBasedBean() {
        isCalled = true;
    }
}