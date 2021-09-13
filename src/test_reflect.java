import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class test_reflect {
    public static void main(String[] args) {
        //测试通过反射访问构造方法
        Class c= example_constructor.class;  //获取类对象
        Constructor[] constructors=c.getDeclaredConstructors();  //获取所申明的构造方法，不包含继承来的方法getConstructors()包含
        for(Constructor c1:constructors){
            System.out.println(c1);
        }
        try {
            constructors[1].setAccessible(true);  //将private私有属性的构造方法设置为可访问
            Class[] exception= constructors[1].getExceptionTypes();  //获取异常的类型
            for(Class cl:exception){
                System.out.println("异常类型为"+cl);
            }
            Class[] types=constructors[1].getParameterTypes(); //获取参数类型
            for(Class t:types){
                System.out.println("参数类型为："+t);
            }
            String[] str={"100","200","300"};
            example_constructor obj=(example_constructor) constructors[1].newInstance(str[0],str[1],str[2]);  //运行时新建对象
            obj.print();
        } catch (Exception e){
            e.printStackTrace();
        }


        System.out.println();
        //测试通过反射访问成员变量
        example_field example=new example_field();  //创建实列
        Class exampleC=example.getClass();   //获得class对象
        Field[] declarefileds=exampleC.getDeclaredFields();  //获取所有非继承的成员变量
        System.out.println("所有成员变量为：");
        for(Field f:declarefileds){
            Field field=f;  //每个成员变量对应一个Field对象
            System.out.println("成员变量名称为："+field.getName());  //获得名称
            Class type=field.getType();  //获得类型
            System.out.println("成员变量的类型为："+type);
            boolean isTurn=true;
            while(isTurn){
                try {
                    isTurn=false;
                    System.out.println("修改前的值为："+field.get(example));  //获取成员变量值
                    //根据不同的类型使用不同的方法设置变量值
                    if(type.equals(int.class)){
                        System.out.println("利用setInt（）方法修改变量值");
                        field.setInt(example,100);  //根据类型修改值
                    }else if(type.equals(float.class)){
                        System.out.println("利用setFloat（）方法修改变量值");
                        field.setFloat(example,2.3f);
                    }else if(type.equals(boolean.class)){
                        System.out.println("利用setBoolean（）方法修改变量值");
                        field.setBoolean(example,true);
                    }else{
                        System.out.println("利用set（）方法修改变量值");
                        field.set(example,"liu jian");  //此方法可以设置任意类型的值
                    }
                    System.out.println("修改后的值为："+field.get(example));
                }catch (Exception e){
                    System.out.println("访问异常，用setAccessible()方法设置访问权限。");
                    field.setAccessible(true);  //设置私有变量可访问
                    isTurn=true;
                }
            }
            System.out.println();
        }


        //测试用java反射访问成员方法
        example_method example_m=new example_method();
        Class example_methodC=example_m.getClass();
        Method[] declaremethods=example_methodC.getDeclaredMethods();
        for(Method method:declaremethods){
            System.out.println("方法名称为："+method.getName());
            System.out.println("是否允许为可变参数："+method.isVarArgs());
            Class typ=method.getReturnType();
            System.out.println("返回值类型为："+typ);
            Class[] paramtype=method.getParameterTypes();
            System.out.println("入口参数的类型分别为：");
            for(Class cla:paramtype){
                System.out.println(cla);
            }
            Class[] exceptiontype=method.getExceptionTypes();
            System.out.println("返回异常类型分别为：");
            for(Class class1:exceptiontype){
                System.out.println(class1);
            }
            boolean isok=true;
            while(isok){
                try {
                    isok=false;
                    if("staticmethod".equals(method.getName())){
                        method.invoke(example_m);  //通过invoke（）方法调用方法
                    }else if("publicintmethod".equals(method.getName())){
                        System.out.println("返回值为："+method.invoke(example_m,10));
                    }else if("protectedmethod".equals(method.getName())){
                        System.out.println("返回值为："+method.invoke(example_m,"10",10));
                    }else{
//                        System.out.println("返回值为："+method.invoke(example_m,"liu"," ","jian!"));//注意后边的参数是object类型，这样写是不对的
                        Object[] param=new Object[]{new String[]{"liu"," ","jian!"}};
                        System.out.println("返回值为："+method.invoke(example_m,param));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("设置访问权限！");
                    method.setAccessible(true);
                    isok=true;
                }
            }
            System.out.println();
        }

    }

}

class  example_constructor{  //用java反射访问构造方法的示例类
    String s;
    int i,i1,i2;
    private example_constructor(){
    }

    protected example_constructor(String s,int i){
        this.s=s;
        this.i=i;
    }

    public example_constructor(String...strings) throws NumberFormatException{
        if(strings.length>0){
            i=Integer.valueOf(strings[0]);
        }
        if(strings.length>1){
            i1=Integer.valueOf(strings[1]);
        }
        if(strings.length>2){
            i2=Integer.valueOf(strings[2]);
        }
    }

    public void print(){
        System.out.println("s="+s);
        System.out.println("i="+i);
        System.out.println("i1="+i1);
        System.out.println("i2="+i2);
    }
}


class example_field{  //java反射访问成员变量的示例类
    int i;
    public float f;
    protected boolean b;
    private String s;
}


class example_method{
    static void staticmethod(){
        System.out.println("执行staticmethod（）方法。");
    }

    public int publicintmethod(int i){
        System.out.println("执行publicintmethod方法。");
        return i*100;
    }

    protected int protectedmethod(String s,int i) throws NumberFormatException{
        System.out.println("执行protected方法。");
        return Integer.valueOf(s)+i;
    }

    private String privatemethod(String...s){
        System.out.println("执行private方法");
        StringBuffer sb=new StringBuffer();
        for(String str:s){
            sb.append(str);
        }
        return sb.toString();
    }
}