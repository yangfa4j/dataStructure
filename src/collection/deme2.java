package collection;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Date 2019/10/28
 * @Author YF
 * @Description
 */
public class deme2 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();

        SetNotSafe();
    }

    private static void SetNotSafe() {
        Set<String> strings = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30 ; i++) {
            new Thread(() -> {
                strings.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strings);
            },String.valueOf(i)).start();
        }
    }
}
