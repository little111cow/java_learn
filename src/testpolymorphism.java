public class testpolymorphism {
    /*多态机制，将子类对象作为父类对象，对于每个子类中，相同的方法，只需要在父类进行
    维护，根据不同的子类对象执行不同的操作，而方法本身的调用没什么不同**/
    public testpolymorphism(){  //父类构造方法
        System.out.println("这是父类的构造方法");
    }

    public void method(testpolymorphism ob){  //使用父类对象作为参数
        System.out.println(ob.getClass().getName());  //输出对应类的名称
    }  //实现多态的父类函数

    public static void main(String[] args){
        testpolymorphism mytest=new testpolymorphism();
        mytest.method(mytest);
        mytest.method(new subclass1());  //多态
        mytest.method(new subclass2());  //多态
    }
}

class subclass1 extends testpolymorphism{  //子类一
    public subclass1(){
        System.out.println("这是子类1的构造方法");
    }
}

class subclass2 extends testpolymorphism{
    public subclass2(){
        System.out.println("这是子类2的构造方法");
    }
}
