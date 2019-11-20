package locks;

import java.util.concurrent.*;

/**
 * @Date 2019/10/24
 * @Author YF
 * @Description
 */
public class SaleTiketDemo6 {

    public static void main(String[] args) throws InterruptedException {


        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
                );

        try {
            // 模拟同时有100个请求过来
            for (int i = 1; i <= 10 ; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 抢占了线程");
                });
            }
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown(); // 关闭线程池
        }


    }

    private static void CachedThreadPool() {
        // 创建一个可扩容的线程池，线程数量随请求数量变化而变化
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            // 模拟同时有100个请求过来
            for (int i = 1; i <= 100 ; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 抢占了线程");
                });
            }
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown(); // 关闭线程池
        }
    }

    private static void SingleThreadPool() {
        // 创建只有1个线程的线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        try {
            // 模拟同时有10个请求过来
            for (int i = 1; i <= 10 ; i++) {
                // 执行业务逻辑
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 抢占了线程");
                });
            }
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown(); // 关闭线程池
        }
    }

    private static void FixedThreadPool() {
        // 定义一个线程池，里面有5个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try {
            // 模拟同时有10个请求过来
            for (int i = 1; i <= 10 ; i++) {
                threadPool.execute(() -> {
                    try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 抢占了线程");
                });
            }
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

}




