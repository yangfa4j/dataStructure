package locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Date 2019/10/24
 * @Author YF
 * @Description
 */
public class SaleTiketDemo5 {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();

        // 五个 写线程
        for (int i = 0; i < 5; i++) {
            final int TempInt = i;
            new Thread(() -> {
                myCache.put(TempInt+"",TempInt+"");
            },"写入线程").start();
        }

        // 五个 读线程
        for (int i = 0; i < 5; i++) {
            final int TempInt = i;
            new Thread(() -> {
                myCache.get(TempInt+"");
            },"读取线程").start();
        }




    }
}

class MyCache{ // 资源类
    private volatile Map<String,Object> map = new HashMap<>(); // 使用线程不安全的Map测试多线程读写
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // 读写锁

    // 写操作
    public void put(String key, Object value){
        readWriteLock.writeLock().lock(); // 添加写锁
        try {
            // 操作
            System.out.println(Thread.currentThread().getName()+"\t 开始写入");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入成功");
        }catch (Exception e){ e.printStackTrace(); }
        finally {
            // 释放锁
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
        readWriteLock.readLock().lock(); // 添加读锁
        try {
            // 操作
            System.out.println(Thread.currentThread().getName()+"\t 开始读取");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取成功，值为："+o.toString());
        }catch (Exception e){ e.printStackTrace(); }
        finally {
            // 释放读锁
            readWriteLock.readLock().unlock();
        }
    }
}




