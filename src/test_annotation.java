import com.sun.deploy.util.SyncAccess;

import java.io.File;
import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.CONSTRUCTOR)  //定义注解适用的程序元素种类,此处适用于构造方法
@Retention(RetentionPolicy.RUNTIME)  //定义编译时采取的行为,此处为运行时加载到JVM中

@interface test_annotation_constructor {  //定义注解类型
    String discribe() default "默认构造方法";  //没有默认类型的注解
    Class type() default void.class;  //具有默认类型的注解
}

@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})  //用于方法、参数和成员变量字段
@Retention(RetentionPolicy.RUNTIME)

@interface test_annotation_m_p_f{
    String describe();  //描述字段
    Class type() default void.class;  //类型字段
}

public class test_annotation{
    @test_annotation_m_p_f(describe = "编号",type=int.class)  //使用定义好的注解进行字段注释
    int id;
    @test_annotation_m_p_f(describe = "名字",type=String.class)
    String name;

    @test_annotation_constructor()  //使用默认注解注释默认构造方法
   public test_annotation(){
    }

    @test_annotation_constructor(discribe = "带参构造方法初始化")  //注释构造方法
    public  test_annotation(@test_annotation_m_p_f(describe = "编号",type = int.class)  //注解参数
                            int id,
                            @test_annotation_m_p_f(describe = "名字",type = String.class)  //注解参数
                            String name){
        this.id=id;
        this.name=name;
    }

    @test_annotation_m_p_f(describe = "设置编号")  //注释方法
    public void setid(@test_annotation_m_p_f(describe = "编号",type = int.class)  //注解参数
                      int id){
        this.id=id;
    }

    @test_annotation_m_p_f(describe = "获得编号",type=int.class)
    public int getid(){
        return this.id;
    }

    @test_annotation_m_p_f(describe = "设置名字")  //注释方法
    public void setname(@test_annotation_m_p_f(describe = "名字",type = String.class)  //注解参数
                              String name){
        this.name=name;
    }

    @test_annotation_m_p_f(describe = "获得名字",type=String.class)
    public String getname(){
        return this.name;
    }

    @test_annotation_m_p_f(describe = "获得构造方法的注解信息")
    public void get_constructor_annotation(){
        Class test_annotationC= test_annotation.class;
        Constructor[] tac=test_annotationC.getDeclaredConstructors();
        for(Constructor c:tac){
            if(c.isAnnotationPresent(test_annotation_constructor.class)){  //判断是否为指定类型注解
                test_annotation_constructor a_tac=(test_annotation_constructor)c.getAnnotation(test_annotation_constructor.class);  //强制类型转换，获得相应类型注解
                System.out.println(a_tac.discribe());  //获得注释信息
                System.out.println(a_tac.type());
                System.out.println();
            }
            Annotation[][] parameterannotation =c.getParameterAnnotations();  //获得参数的注解信息
            for(Annotation[] a:parameterannotation){
                int length=a.length;
                if(length==0){
                    System.out.println("未添加Annotation的参数！");
                }else{
                    for(Annotation aa:a){
                        test_annotation_m_p_f tampf=(test_annotation_m_p_f)aa;  //强制类型转换
                        System.out.println(tampf.describe());  //获得字段描述
                        System.out.println(tampf.type());  //获得字段描述
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }
    }

    @test_annotation_m_p_f(describe = "获得方法的注解信息")
    public void getannotation_method(){
        Class test_annotationC=test_annotation.class;
        Method[] tam=test_annotationC.getDeclaredMethods();
        for(Method m:tam){
            if(m.isAnnotationPresent(test_annotation_m_p_f.class)){
                test_annotation_m_p_f tampf=m.getAnnotation(test_annotation_m_p_f.class);
                System.out.println(tampf.describe());
                System.out.println(tampf.type());
            }
            Annotation[][] ma=m.getParameterAnnotations();  //以二维数组返回Annotation类型
            for(Annotation[] mm:ma){
                if(mm.length==0){
                    System.out.println("未添加Annotation的参数");
                }else{
                    for(Annotation mp:mm){
                        test_annotation_m_p_f t=(test_annotation_m_p_f)mp;  //强制类型转换
                        System.out.println(t.describe());
                        System.out.println(t.type());
                    }

                }
            }
            System.out.println();
        }
    }

    @test_annotation_m_p_f(describe = "获得成员变量的注解！")
    public void getannotation_field(){
        Class test_annotationC=test_annotation.class;
        Field[] field=test_annotationC.getDeclaredFields();
        for(Field f:field){
            if(f.isAnnotationPresent(test_annotation_m_p_f.class)){
                test_annotation_m_p_f tmpf=f.getAnnotation(test_annotation_m_p_f.class);
                System.out.println(tmpf.describe());
                System.out.println(tmpf.type());
            }
            System.out.println();
        }
    }

    @test_annotation_m_p_f(describe="递归打印磁盘文件！")
    public void printfile(File f){  //递归打印磁盘文件
        if(f.isFile()){
            System.out.println(f.getName());
        }else{
            try {
                for (File fi : f.listFiles()) {
                    printfile(fi);  //递归
                }
            }catch (Exception e){  //静默异常
            }
        }
    }

    @test_annotation_m_p_f(describe = "主方法：用java反射访问注解信息。")
    public static void main(String[] args) {
        test_annotation ta=new test_annotation();
        int id=10;
        String name="liu jian";
        ta.setid(id);
        ta.setname(name);
        System.out.println(ta.getid());
        System.out.println(ta.getname());
        System.out.println();
        ta.get_constructor_annotation();
        ta.getannotation_method();
        ta.getannotation_field();

        File f=new File("F:\\A辐射源识别项目\\code\\data_model");
        ta.printfile(f);
    }

}