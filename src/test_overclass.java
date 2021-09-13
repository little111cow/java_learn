import javax.swing.plaf.synth.SynthLabelUI;
import java.util.*;

public class test_overclass <T> implements overinterface<T>{  //定义泛型类，可以是多个类别<T,E>并实现泛型接口
    private T t;
    private T m;
    private T[] arr;  //可以定义泛型数组，但是不能实列化数组

    public test_overclass(){  //默认构造函数
    }

    public test_overclass(T t,T m){
        this.t=t;
        this.m=m;
    }

    @Override
    public void sett(T t) {
        this.t=t;
    }

    public T  gett(){  //实现接口定义泛型方法
        return t;
    }

    public void setm(T m){
        this.m=m;
    }

    public T getm(){  //实现接口定义泛型方法
        return m;
    }

    @Override
    public T[] getarr() {
        return arr;
    }

    @Override
    public void setarr(T[] arr) {
        this.arr=arr;
    }

    public static void main(String[] args) {
        test_overclass<Integer> to=new test_overclass<Integer>(10,2);  //实例化泛型类的一个对象，只能用包装类型
        //或者其它的类类型，不能是基本类型
        Integer[] arr = new Integer[]{1,2,3};
        to.setarr(arr);
        System.out.println("m="+to.getm());
        System.out.println("t="+to.gett());
        to.setm(20);
        to.sett(12);
        System.out.println("m="+to.getm());
        System.out.println("t="+to.gett());
        Integer[] arrback=to.getarr();
        System.out.println("实列泛型数组的值为：");
        for(int a:arrback){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}

class overclass_sub1<T extends test_overclass,E> extends test_overclass<T>{  //继承泛型类并限制泛型类可用类型,可以为extends，super，？通配符
    public E e;
}



interface overinterface<T>{  //定义泛型接口
    void sett(T t);
    T gett();
    void setm(T m);
    T getm();
    T[] getarr();
    void setarr(T[] arr);
}
