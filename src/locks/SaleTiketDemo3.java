package locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2019/10/28
 * @Author YF
 * @Description
 */
public class SaleTiketDemo3 {
    public static void main(String[] args) {

        Cake cake = new Cake();

        new Thread(() ->{ for (int i = 0; i < 100 ; i++) {
            try {
                cake.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"生产者1").start();

        new Thread(() ->{ for (int i = 0; i < 100 ; i++) {
            try {
                cake.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"消费者1").start();

        new Thread(() ->{ for (int i = 0; i < 100 ; i++) {
            try {
                cake.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"生产者2").start();

        new Thread(() ->{ for (int i = 0; i < 100 ; i++) {
            try {
                cake.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        },"消费者2").start();

    }
}

class Cake{
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition producer = lock.newCondition();
    private Condition customer = lock.newCondition();


    public void increment(){
        lock.lock();
        try {
            // 判断
            while (number != 0){
                producer.await();
            }
            // 操作
            number++;
            System.out.println(Thread.currentThread().getName()+"生产了一个蛋糕"+"目前总共有："+number+"个!");
            // 通知
            customer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number == 0){
                customer.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"购买了1个蛋糕，"+"还剩下"+number+"个！");
            producer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


