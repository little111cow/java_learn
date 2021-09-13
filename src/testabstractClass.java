public abstract class testabstractClass {  //抽象类的定义，除了被继承之外没有任何意义，被继承后必须实现全部抽象方法，即便某个子类不需要这个方法
            abstract void method1();  //定义抽象方法，不提供实现，不存在方法体，只能定义在抽象类中，否则没有意义
            abstract int method2(int a);

            public void method3(){
                System.out.println("抽象类的非抽象方法！");
            }
}

class subclass extends testabstractClass{
    void method1(){
        System.out.println("这是对抽象方法一的实现");
    }

    int method2(int a){
        System.out.println("这是对抽象方法二的实现");
        return (int)Math.pow(a,2);
    }

    public static void main(String[] args){
        subclass mysub=new subclass();
        testabstractClass my=new testabstractClass(){
            @Override
            void method1() {
                System.out.println("必须重写抽象方法才能实例化！");
            }

            @Override
            int method2(int a) {
                return 0;
            }
        };
        my.method1();
        System.out.println(my.method2(0));
        my.method3();;
        mysub.method1();
        int a=mysub.method2(10);
        System.out.println(a);
        mysub.method3();
    }
}


