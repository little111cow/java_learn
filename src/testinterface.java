interface myinterface1{
    void method2();  //父类抽象方法定义为接口，若果接口内有多个抽象方法，则在实现接口时所有方法均要被实现
}

interface myinterface2{
    void method3();  //父类抽象方法定义为接口
}

interface myinterface3 extends myinterface1{  //接口也可以继承，自动包含父接口的抽象方法，即该接口存在两个抽象方法method2
                                                //method4
    void method4();
}
public class testinterface {
     testinterface(){//不要忘记了构造方法不加返回值类型
        System.out.println("父类构造方法");
    }

    public void method1(){
        System.out.println("父类方法一");
    }

}

class sub extends testinterface implements myinterface1{
     sub(){//不要忘记了构造方法不加返回值类型
        System.out.println("子类1构造方法！");
    }
    @Override
    public void method2() {
        System.out.println("子类1继承父类并实现接口1");
    }
}

class sub1 extends testinterface implements myinterface1,myinterface2{  //使用接口可以多重继承
     sub1(){  //不要忘记了构造方法不加返回值类型
        System.out.println("子类2构造方法！");
    }
    @Override
    public void method2() {
        System.out.println("子类2继承父类并实现接口1");
    }

    public void method3(){
        System.out.println("子类2继承父类并实现接口2！");
    }

    public static void main(String[] args){
        testinterface mt=new testinterface();
        mt.method1();

        sub ms=new sub();
        ms.method2();

        sub1 ms1=new sub1();
        ms1.method2();
        ms1.method3();

        myinterface1 interf=new sub1();  //接口也是可以进行向上转型的,将对象转为实现的接口对象，即也可以实现多态技术
        interf.method2();  //会自动调用覆盖的实现方法

        my m=new my1();  //向上转型后调用重写父类方法后的方法依然会调用重写的方法而不会调用原来父类的方法，这和接口的转型类似
        m.method2();

    }
}

class my implements myinterface3{
    @Override
    public void method2() {
        System.out.println("接口继承");
    }

    @Override
    public void method4(){
        System.out.println("接口继承");
    }

}

class my1 extends my{
    public void method2(){
        System.out.println("接口继承1");
    }
}