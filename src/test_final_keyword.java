import java.util.Random;

public class test_final_keyword {
    //1.定义为final类型的对象不能被更改来指向别的对象
    //2.定义为final的方法不能被重写
    //3.定义为final的类不能被继承
    //4.定义为static final的对象引用和值均不可改变
    private  final double PI = 3.14159;
    private static final int I= new Random().nextInt(10);
    //若要使得值和对象引用均不可变，用static final修饰符
    static final int[] FINAL_INT = new int[]{1, 2, 3, 4, 5};  //一般声明为全局变量

    final double getPI() {
        return this.PI;
    }

    //试图为FINAL_INT赋值，可以赋值
    void setval(int val) {
        FINAL_INT[0] = val;
    }

    //定义一个final内部类
    final class test_final_inner {  //final类中的方法全是final的，但成员变量可以不是final的
        test_final_inner() {
            System.out.println("这个类不能被继承；");
        }
    }

    //不能继承
//    class sub_test_final_inner extends test_final_inner{
//        sub_test_final_inner(){
//            System.out.println("不能继承！");
//        }
//    }

    public static void main(String[] args) {
        test_final_keyword tfk = new test_final_keyword();
        //试图改变final变量PI,不能改变
//        tfk.PI++;
        final int[] intarr = new int[]{1, 2, 3, 4, 5};
        intarr[0] = 10;  //本身的变量值可以改变
        int[] intarr1 = new int[]{5, 4, 3, 2, 1};
//        intarr=intarr1;  //不能改变变量对象的引用

        for (int i : tfk.FINAL_INT) {
            System.out.println(i);
        }
        tfk.setval(10);  //修改了第一个值
        for (int i : tfk.FINAL_INT) {
            System.out.println(i);
        }
         System.out.println(tfk.I);  //虽然使用随机数方法，但是I的值是相同的，说明static final值不可变
        test_final_keyword tfk1=new test_final_keyword();
        for(int i:tfk1.FINAL_INT){
            System.out.println(i);
        }
        System.out.println(tfk1.I);  //虽然使用随机数方法，但是I的值是相同的，说明static final值不可变
    }
}
class sub_test extends test_final_keyword{
    //试图重写getPI方法，不能重写
//    double getPI(){
//        return super.PI;
//    }

}
