package locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2019/10/24
 * @Author YF
 * @Description
 */
public class SaleTiketDemo4 {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3); // 三个个停车场
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 得到许可后，信号量减一
                    System.out.println(Thread.currentThread().getName()+"\t抢占到了车位！");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release(); // 释放许可证，信号量加一
                }
            },String.valueOf(i)).start();
        }


    }

    private static void CountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t完成工作！");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("主线程必须等别的线程结束后才能结束！");
    }

}




