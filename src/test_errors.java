public class test_errors {
    public static void main(String[] args){
        student stu=new student();
        try{
        double s=stu.speak(10000,10);
        System.out.println(s);
        }catch (myException e){   //捕获自定义异常
//            System.out.println("myException:"+e.getMessage());
            e.printStackTrace();
        }catch (ArithmeticException e){  //捕获算数异常
            e.printStackTrace();
        } finally {  /*不管是否发生异常均会执行，除了四种情况1.finally块发生异常
        2.前边代码块执行了System.exit()3.程序所在的线程死亡4.关闭cpu*/
            System.out.println("程序结束！");
        }

    }
}

class myException extends Exception{  //继承Exxeption类自定义异常类
    String errmessage;  //自定义错误消息
    public myException(String err){  //构造方法
        errmessage=err;
//        super(err);
    }

    @Override
    public String getMessage() {  //重写父类getMessage方法
        return errmessage;
    }
}

class student{
    public double speak(int m,int n) throws myException,ArithmeticException{  //用throws向上抛出异常,可以有多个
        if(m>1000||n>1000){
            throw new myException("数组不能大于1000！");  //throw关键字抛出异常
        }else if(n==0){
            throw new ArithmeticException("除数不能为零！");
        }
        return m/n;
    }

}