import java.util.concurrent.Executors;

public class test_muti_threads extends Thread{  //继承Thread类实现多线程
    private int count=10;

    public void run(){  //重写run（）方法
        while(true){
            System.out.println("线程1："+count--);
//           Thread t= new Thread(new my_thread());
            try{
                Thread.sleep(100);  //线程休眠态
//                t.join();  //加入新线程，先完成再执行本来的线程，和sleep方法一样可能有interruptedexception异常
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(count<0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        new test_muti_threads().start();  //调用Thread类的start（）方法启动线程
        new Thread(new my_thread()).start();  //使用Thread类带有Runnable实列的构造方法，调用Thread类的start（）方法启动线程
        my_thread1 mt1 = new my_thread1();
        Thread t=new Thread(mt1);
        t.start();
        mt1.setIscontinue();  //结束线程3,只执行一次

       // 多线程优先级
        new test_priority();
        my_thread[] my_t = {new my_thread(),new my_thread(),new my_thread(),new my_thread()};
        new test_priority(my_t);

        //多线程安全问题，线程同步（安全问题来源于多线程存取同一对象的数据）,不安全线程
        my_thread m_t = new my_thread();  // 同一对象,最后的输出出现负值
        m_t.setname("线程1");
        Thread t1 = new Thread(m_t);
        Thread t2 = new Thread(m_t);
        Thread t3 = new Thread(m_t);
        Thread t4 = new Thread(m_t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //同步块实现同步线程
        my_thread4 m_t1 = new my_thread4();  // 同一对象,最后的输出不会出现负值
        m_t1.setname("线程2");
        Thread t5 = new Thread(m_t1);
        Thread t6 = new Thread(m_t1);
        Thread t7 = new Thread(m_t1);
        Thread t8 = new Thread(m_t1);
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        //同步方法实现同步线程
        my_thread5 m_t2 = new my_thread5();  // 同一对象,最后的输出不会出现负值
        m_t2.setname("线程3");
        Thread t9 = new Thread(m_t2);
        Thread t10 = new Thread(m_t2);
        Thread t11 = new Thread(m_t2);
        Thread t12 = new Thread(m_t2);
        t9.start();
        t10.start();
        t11.start();
        t12.start();

        //多线程简单使用多线程同步计算1~100的和
        sum100 s = new sum100();
        Thread t13 = new Thread(s);  //创建4个线程并行计算1~100的和
        Thread t14 = new Thread(s);
        Thread t15 = new Thread(s);
        Thread t16 = new Thread(s);
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        

    }
}


class my_thread implements Runnable{  //实现Runnable接口实现多线程，如果类继承别的类时只能通过这种方法实现多线程
    private int count=10;
    private Thread t = new Thread(this);
    public void run(){  //实现run（）方法
        while(true){  //通常写为全真循环，用条件来控制退出
            if(count>=0) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(t.getName() + ":" + count--);
            }else{
                return;
            }
        }
    }

    public void setname(String name){  //给当前线程设置名字
        t.setName(name);
    }
}

/** 由于jdk5以后线程停止方法stop（）方法弃用，
 * 可以用控制全真循环的方法来控制线程的结束，实现如下：
 * iscontinue控制是否结束线程
 * */
class my_thread1 implements Runnable{
    private boolean iscontinue=true;
    private int count=10;
    public void run(){
        while(true){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("线程3："+count--);
            if(!iscontinue){
                return ;
            }
        }
    }

    public void setIscontinue(){  //关闭线程的方法
        this.iscontinue=false;
    }
}

/**线程优先级测试1~10之间以及
 * 用interrupt方法结束线程*/
class my_thread3 implements Runnable{
    private int count=10;
    private Thread t = new Thread(this);
    public void run(){
        while(true){
            System.out.println(t.getName()+":"+count--);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("当前线程被中断！");
                break;  //结束线程
            }
        }
    }

    public void setname(String name){  //给当前线程设置名字
        t.setName(name);
    }
}

class test_priority{
    public test_priority(){
        my_thread3 mt1=new my_thread3();
        Thread t1 = new Thread( mt1);
        my_thread3 mt2=new my_thread3();
        Thread t2 = new Thread( mt2);
        my_thread3 mt3=new my_thread3();
        Thread t3 = new Thread(mt3);
        my_thread3 mt4=new my_thread3();
        Thread t4= new Thread( mt4);
        mt1.setname("线程1");
        mt2.setname("线程2");
        mt3.setname("线程3");
        mt4.setname("线程4");
        t1.setPriority(5);  //为四个线程设定不同优先级
        t2.setPriority(5);
        t3.setPriority(4);
        t4.setPriority(2);
        t3.start();  //由输出结果可以得到虽然线程1，2后启动，但是优先执行
        t4.start();
        t1.start();
        t2.start();
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();  //产生中断用来结束线程4
    }

    public test_priority(my_thread[] mt){
        mt[0].setname("线程1");
        Thread t1 = new Thread(mt[0]);
        mt[1].setname("线程2");
        Thread t2 = new Thread(mt[1]);
        mt[2].setname("线程3");
        Thread t3 = new Thread(mt[2]);
        mt[3].setname("线程4");
        Thread t4 = new Thread(mt[3]);
        t1.setPriority(5);  //为四个线程设定不同优先级
        t2.setPriority(5);
        t3.setPriority(4);
        t4.setPriority(3);
        t3.start();  //由输出结果可以得到虽然线程1，2后启动，但是优先执行,4和三是由于3有睡眠状态
        t4.start();
        t1.start();
        t2.start();
    }
}

class my_thread4 implements Runnable{  //用同步块实现线程同步
    private int count=10;
    private Thread t = new Thread(this);

    public void run(){
        while(true){
            synchronized ("") {  //同步块实现线程同步，括号内可以为任意对象这里用空串
                if(count>=0) {
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(t.getName() + ":" + count--);
                }else{
                    return;
                }
            }
        }
    }

    public void setname(String name){
        t.setName(name);
    }
}

class my_thread5 implements Runnable{  //用同步方法实现线程同步
    private int count=10;
    private Thread t = new Thread(this);

    public void run(){
        while(true){
            doit();
            if(count<0){return;}
        }
    }

    public synchronized void doit(){  //定义同步方法
            if(count>=0) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(t.getName() + ":" + count--);
            }
        }

    public void setname(String name){
        t.setName(name);

    }
}

class sum100 extends Thread{
    private int sum=0;
    private int i=0;
    private Thread t = new Thread(this);
    public void run() {
        while (true) {
            synchronized ("") {
                if (i < 100) {
                    i++;
                    sum += i;
                    System.out.println(t.getName()+":"+i+":"+sum);
                }else{
                    return;
                }
            }
        }
    }
    }
