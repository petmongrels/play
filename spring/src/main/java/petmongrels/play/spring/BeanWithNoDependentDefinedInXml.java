package petmongrels.play.spring;

public class BeanWithNoDependentDefinedInXml {
    public static boolean isCalled;

    public BeanWithNoDependentDefinedInXml() {
        isCalled = true;
    }
}