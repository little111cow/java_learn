public class test_enum {
    enum ConstantC{  //还可以在类的内部定义枚举类型
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
    }

    public static void getday(ConstantC c){
        switch (c){
            case Monday:System.out.println("星期一");break;
            case Tuesday:System.out.println("星期二");break;
            case Wednesday:System.out.println("星期三");break;
            case Thursday:System.out.println("星期四");break;
            case Friday:System.out.println("星期五");break;
            case Saturday:System.out.println("星期六");break;
            case Sunday:System.out.println("星期日");break;
            default:System.out.println("不存在");break;
        }
    }

    public static void main(String[] args) {
        System.out.println("接口定义常量的引用方法:"+ConstantA.id);
        System.out.println("接口定义常量的引用方法:"+ConstantA.name);
        System.out.println("接口定义常量的引用方法:"+ConstantA.school);

        //枚举常量的用法
        ConstantB[] Cb=ConstantB.values();  //values（）方法以数组形式返回常量值
        for(ConstantB cb:Cb){
            System.out.println(cb+"对应的索引为："+cb.ordinal());  //ordinal()方法返回对应的索引
        }
        System.out.println("枚举定义常量的用法:"+ConstantB.ID);
        System.out.println("枚举定义常量的用法:"+ConstantB.NAME);
        System.out.println("枚举定义常量的用法:"+ConstantB.SCHOOL);

        ConstantB.valueOf("ID");  //valueOf（）方法将字符串类型转换为枚举类型
        for(ConstantB cb:Cb){
            System.out.println(cb+"对应的索引为："+cb.ordinal());  //ordinal()方法返回对应的索引
        }

        //调用方法
        System.out.println("调用方法："+ConstantB.NAME.getname());
        System.out.println("调用方法："+ConstantB.NAME.getid());
        System.out.println("调用方法："+ConstantB.ID.getname());
        System.out.println("调用方法："+ConstantB.ID.getid());
        System.out.println("调用方法："+ConstantB.SCHOOL.getname());
        System.out.println("调用方法："+ConstantB.SCHOOL.getid());

        System.out.println(ConstantC.Sunday.compareTo(ConstantC.Friday));  //compareTo()比较两个枚举的索引，返回正值、负值或者0，即索引差
        getday(ConstantC.Friday);

        //调用方法
        System.out.println("调用方法："+ConstantD.NAME.getname());
        System.out.println("调用方法："+ConstantD.NAME.getid());
        System.out.println("调用方法："+ConstantD.ID.getname());
        System.out.println("调用方法："+ConstantD.ID.getid());
        System.out.println("调用方法："+ConstantD.SCHOOL.getname());
        System.out.println("调用方法："+ConstantD.SCHOOL.getid());
    }
}

//用接口定义常量，可以赋值
interface ConstantA{
     int id=2020211025;
     String name="liu jian";
     String school="IT";
}

//用枚举定义常量
enum ConstantB{
    ID(2020211025),NAME("liu jian") ,SCHOOL("IT"); //必须有构造方法，否则不能赋值，一般数据类型相同，这里定义了不同的
    private int id;
    private String name;
    ConstantB(){  //无参构造方法
    }

    ConstantB(int id ){  //有参构造方法，构造方法和字段均是private修饰的，相应的枚举要调用构造方法
        this.id=id;
    }

    ConstantB(String name){  //有参构造方法，相应的枚举要调用构造方法
        this.name=name;
    }

    public int getid(){  //定义方法
        return id;
    }

    public String getname(){  //定义方法
        return name;
    }
}

interface method{
    int getid();
    String getname();
}

enum ConstantD implements method{  //通过枚举实现接口来实现方法，每个枚举均要实现接口的所有方法,和上边的枚举ConstantB实现一样的功能
    ID{
        public String getname(){
            return null;
        }

        public int getid(){
            return 2020211025;
        }
    },NAME{
        public String getname(){
            return "liu jian";
        }

        public int getid(){
            return 0;
        }
    },SCHOOL{
        public String getname(){
            return "IT";
        }

        public int getid(){
            return 0;
        }
    }

}