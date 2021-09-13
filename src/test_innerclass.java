public class test_innerclass {
    //内部类可以随意使用所在外部类的私有成员和方法，外部类不可以直接访问内部类的成员和方法，要通过实列访问
    //内部类对象的实例化必须在外部类或者外部类的非静态方法中实现
    test_innerclass_inner in=new test_innerclass_inner();  //在外部类中实例化内部类对象
    private int y=10;  //和内部类重名的外部类属性

    public test_innerclass(){
        System.out.println("这是外部类构造方法！");
    }

    private class test_innerclass_inner{
        int y=1;  //和外部类重名的内部类属性
        public test_innerclass_inner(){  //内部类构造方法
            System.out.println("这是内部类构造方法！");
        }
        private int gety(){  //内部类成员方法
            return this.y;
        }

        public void comparey(int y) {  //用this关键字在内部类中操作重名的属性，获得内部类和外部类的一个引用
            y++;  //形参
            this.y = 2*y;  //将形参加一的值赋给内部类的属性y
            test_innerclass.this.y = 8*this.y;  //将内部类的属性y的值赋值给外部类的属性y
            System.out.println("形参y的值为：" + y);
            System.out.println("内部类的属性y的值为：" + this.y);
            System.out.println("外部类的属性y的值为：" + test_innerclass.this.y);
        }

    }

    public test_innerclass_inner getob(int y){  //在外部类非静态方法创建内部类对象
        in.y=y;    //还可以通过对象调用内部类的方法
        return new test_innerclass_inner();
    }

    public class inner1 implements inner_interface{  //定义内部类实现接口
       public inner1(){
            System.out.println("内部类一的构造方法！");
        }

        public void f(){  //实现接口的f方法
           System.out.println("这是对接口f方法的第一种实现！");
        }
    }

    public inner_interface getinner1ob(){  //将内部类向上转型为接口，在外部类向外提供访问内部类方法f的接口
        return new inner1();
    }

    public class inner2 implements inner_interface{
        public inner2(){
            System.out.println("内部类二的构造方法！");
        }

        public void f(){
            System.out.println("接口的第二种实现！");
        }
    }

    public inner_interface getinner2ob(){  //对外提供内部类接口
        return new inner2();
    }



    public static void main(String[] args){
        //成员内部类测试
        test_innerclass testout=new test_innerclass();  //实例化外部类对象，内部类会被绑定在外部类上
        test_innerclass.test_innerclass_inner testin=testout.getob(1);  //通过外部类的方法创建内部类对象
        test_innerclass.test_innerclass_inner testin2=testout.new test_innerclass_inner();  //通过new关键字创建内部类对象,必须提供外部类的引用，而不能是外部类名称
        System.out.println(testin.gety());  //或者用this关键字
        System.out.println(testout.y);
        testin.comparey(2);

        inner_interface myinterface=testout.getinner1ob();  //获取内部类1的引用，向上转型为接口
        myinterface.f();   //通过接口调用f方法

        inner_interface myinterface2=testout.getinner2ob();  //获取内部类2的引用，向上转型为接口
        myinterface2.f();  //通过接口调用f方法

        //局部内部类测试
        test_local_innner_class testlocal=new test_local_innner_class();
        inner_interface myinterface3=testlocal.getloacalclass("局部内部类！");  //调用方法获得局部内部类转型为接口的对象引用
        myinterface3.f();  //通过接口调用f方法

        //匿名内部类测试
        test_niming_innerclass tniming=new test_niming_innerclass();
        inner_interface myinterface4=tniming.func();
        myinterface4.f();

        //内部类的继承测试
        innerclassextend myextend=new innerclassextend(testout);  //必须提供外部类的对象构造参数
        myextend.f();

        //静态内部类测试，注意和上边非静态内部类对比
        staticinnerclass mystatic=new staticinnerclass();
        staticinnerclass.staticinner myinner=new staticinnerclass.staticinner();  //不需要外部类对象mystatic
    }
}

interface inner_interface{  //定义一个外部接口，在外部类中定义多个内部类以不同的方式实现接口，就可以在一个类中实现多种事件的响应
    public void f();
}

class test_local_innner_class{

    public inner_interface getloacalclass(String s){
        int x=19;
        class localclass implements inner_interface{  //在方法体内部定义内部类实现接口

            public void f(){
                System.out.println(s+x);
            }
        }
        return new localclass();
    }
}

class test_niming_innerclass{
      public inner_interface func(){
          return new inner_interface() {  //没有名称，只是返回接口
              @Override
              public void f() {
                  System.out.println("匿名内部类！");
              }
          };
      }
}

class innerclassextend extends test_innerclass.inner2{  //内部类的继承
    public innerclassextend(test_innerclass a){  //必须提供一个有参构造方法，参数为内部类所在的外部类的对象引用
        a.super();  //外部类成员方法访问
    }

}


class staticinnerclass{
    int x=10;
    static class staticinner{  //静态内部类1.不能从静态内部类的对象中调用非静态外部类的对象 2.创建静态内部类的对象不需要外部类的对象
        staticinner(){
//            System.out.println(x);  //不能调用非静态成员变量x
            System.out.println("静态内部类！");
        }
    }
}