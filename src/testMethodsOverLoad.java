public class testMethodsOverLoad {
    //构成方法重载的条件：
    // 1.参数类型不同
    //2.参数个数不同
    //3.参数顺序不同
    public int add(int a,int b){
        return a+b;
    }

    public int add(int a){
        return a;
    }

    public  double add(double a,double b){
        return a+b;
    }

    public double add(int a,double b){
        return a+b;
    }

    public double add(double a,int b){
        return a+b;
    }

    public  int add(int...a){  //不定长参数方法定义方式，也构成重载，满足参数个数不同
        int s=0;
        for(int i:a){  //实际把a看成数组
            s+=i;
        }
        return s;
    }

    public static void main(String[] args){
        testMethodsOverLoad tmovld=new testMethodsOverLoad();
        System.out.println("add(int,int)方法调用："+tmovld.add(2,3));
        System.out.println("add(int)方法调用："+tmovld.add(3));
        System.out.println("add(double,double)方法调用："+tmovld.add(2.3,3.2));
        System.out.println("add(int,double)方法调用："+tmovld.add(2,3.8));
        System.out.println("add(double,int)方法调用："+tmovld.add(2.9,3));
        System.out.println("add(int...)方法调用："+tmovld.add(2,3,8,9));
        System.out.println("add(int...)方法调用："+tmovld.add(2,3,8,9,98,20));
    }
}
