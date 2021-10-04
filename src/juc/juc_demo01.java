package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class juc_demo01 {
    public static void main(String[] args) {
        ticket t = new ticket();//公共资源

        //开启两个消费线程，一个生产线程
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                t.sale();
            }
        },"消费线程t1").start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                t.sale();
            }
        },"消费线程t2").start();

        new Thread(()->{
            for(int i=0;i< 10;i++) {
                t.increment();
            }
        },"生产线程").start();

    }
}

class ticket{  //资源类
    private int tickets = 100;    //总票数
    private Lock lock = new ReentrantLock();  //可重入锁
    private Condition condition = lock.newCondition();  //监视对象

    public void sale(){  //消费
        lock.lock();  //加锁
        try {
            while(tickets==0){  //没有票了等待生产票
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票,余票为" + tickets);
            condition.signalAll();  //通知其它消费者消费或者通知生产者生产
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁
        }

    }

    public void increment(){  //生产
        lock.lock();  //加锁
        try {
            while(tickets!=0){  //还有票生产线程等待
//                TimeUnit.SECONDS.timedWait(condition,1);
                condition.await();
            }
            tickets += 10;
            System.out.println(Thread.currentThread().getName() + "产生了" + 1 + "张票，总票数为" + tickets);
            condition.signalAll();  //通知消费者消费
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  //释放锁
        }
    }
}