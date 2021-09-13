import java.lang.Object;
public class testExtends {
    protected  testExtends(){  //注意构造方法是不能加返回值类型的
        System.out.println("这是父类的构造方法！");
    }

    public void getclass(){
        System.out.println(getClass().getName());  //object类的重要方法，获取类的名称
    }

}

 class subtestExtends extends testExtends{
    public subtestExtends(){  //注意构造方法是不能加返回值类型的，权限修饰只能变大
        System.out.println("这是子类的构造方法！");
        super.getclass();  //均是获取当前运行类的实列的类名称
    }
}

class subsubtestExtends extends subtestExtends{
    public  subsubtestExtends(){  //注意构造方法是不能加返回值类型的，权限修饰只能变大
        System.out.println("这是子子类的构造方法！");
        super.getclass();  //均是获取当前运行类的实列的类名称
    }

    public String toString(){  //通常重写object类的toString方法，输出自己的格式
        return "对象的重写toString方法";
    }

//    public boolean equals(){  //重写object类equals（）方法实现判断内容而不是对象是否相同
//
//    }

    public static void main(String[] args){
        subsubtestExtends ssb=new subsubtestExtends();  //输出了三个构造方法的结果，说明子类创建时自动实例化父类对象，自动调用
                                                        //父类的无参构造方法，有参构造方法要用super.method（pram）调用
        System.out.println(ssb);  ////重写，默认返回类名加地址

        subtestExtends ssb1= new subsubtestExtends();  //对象类型的转换，向上转型，将子类对象视为父类对象的实列，实列化方法
                                                        //父类  名称标识 = new 子类（）；总是安全的

        subsubtestExtends ssb2=(subsubtestExtends)ssb1;  //向下转型，将父类对象视作子类对象的实列，是不安全的，必须在满足条件时
                                                            //进行强制类型转换，指明子类，类似基本类型数据的强制转换，可使用instanceof操作符
                                                            //来判断一个父类对象是否为子类对象的实列
        boolean flag=ssb1 instanceof subtestExtends;  //判断ssb1对象是否为subtestExtends类的对象，显然为真
        System.out.println(flag);

    }
}
