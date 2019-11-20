package java8;

/**
 * @Date 2019/10/31
 * @Author yangfa
 * @Description
 */
public class TestStreamDeme1 {
    public static void main(String[] args) {
        System.out.println(Object.class.getClassLoader());
        System.out.println(TestStreamDeme1.class.getClassLoader());
        System.out.println(TestStreamDeme1.class.getClassLoader().getParent());
        System.out.println(TestStreamDeme1.class.getClassLoader().getParent().getParent());
    }

}
