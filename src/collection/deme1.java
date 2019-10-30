package collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Date 2019/10/28
 * @Author YF
 * @Description
 */
public class deme1 {
    public static void main(String[] args) {
        List<String> strings = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 30 ; i++) {
            new Thread(() -> {
                strings.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strings);
            },String.valueOf(i)).start();
        }
    }
}
