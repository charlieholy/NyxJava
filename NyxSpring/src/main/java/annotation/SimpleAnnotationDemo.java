package annotation;

public class SimpleAnnotationDemo {
    public static void main(String[] args) {
        Desc desc = Bean.class.getAnnotation(Desc.class);
        System.out.println("bean desc: " + desc.value());
    }
}
