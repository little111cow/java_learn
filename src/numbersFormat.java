import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Random;

public class numbersFormat {
    public static void main(String[] args){
        numbersFormat numformat= new numbersFormat();
        numformat.simpleformat("###.####",123.123);  //指定位有数字显示反之不显示
        numformat.simpleformat("000.0000",123.123);  //匹配到指定维数，不够补零

        numformat.useapplypatternformat("##,##,##.####",123456.1234567);  //四舍五入到指定位数
        numformat.useapplypatternformat("##.##%",12.34);  //格式化为百分数

        numformat.useapplypatternformat("##\u2030",0.01);  //格式化为千分数

        //Math类常用方法
        System.out.println("四舍五入："+Math.round(3.5));  //四舍五入方法
        System.out.println("返回与数最接近的整数，若距离相同返回偶整数："+Math.rint(2.5));
        System.out.println("向下取整"+Math.floor(2.6));
        System.out.println("向上取整"+Math.ceil(2.6));

        //Math类的random方法，返回0到1之间的随机数
        System.out.println(Math.random());
        System.out.println(numformat.getrandnum(0,10));
        System.out.println(numformat.getrandnum(2.5,3.9));
        System.out.println(numformat.getrandchar('a','j'));

        //Random类
        Random rd=new Random(2021);
        System.out.println(rd.nextInt(100));  //返回大于等于0小于n的随机整数数
        System.out.println(rd.ints().toString());

        //大数处理类
        BigInteger bigint=new BigInteger("100");  //以数值字符串形式创建
        System.out.println(bigint.add(new BigInteger("105")));  //提供各种方法加减乘除
        System.out.println("除法的商为："+bigint.divideAndRemainder(new BigInteger("3"))[0]);  //除法商和余数
        System.out.println("除法的余数为："+bigint.divideAndRemainder(new BigInteger("3"))[1]);  //余数
        System.out.println("余数为："+bigint.remainder(new BigInteger("3")));

        //指数
        System.out.println(bigint.pow(2));

        //左右移
        System.out.println(bigint.shiftLeft(2));

        //最大最小
        System.out.println(bigint.max(new BigInteger("120")));

        //比较
        System.out.println(bigint.equals(new BigInteger("100")));  //比较值是否相同返回boolean值
        System.out.println(bigint.compareTo(new BigInteger("10")));  //小于返回-1，大于返回+1，等于返回0

        //BigDecimal类
        BigDecimal bigdec=new BigDecimal(100);  //两种构造方法
        BigDecimal bigdec1=new BigDecimal("3");

        //加减乘除方法，主要注意乘法各种精度处理模式,其它方法和BigInteger大致相似
        System.out.println(bigdec.divide(bigdec1,20,BigDecimal.ROUND_HALF_UP));

        //练习测试1
        int sum=0;
        System.out.println("2~32之间的六个偶数为：");
        for(int i=0;i<6;i++){
            int t=numformat.getrandnum(2,32);
            while(t%2!=0){
                t=numformat.getrandnum(2,32);
            }
            System.out.print(t+" ");
            sum+=t;
        }
        System.out.println();
        System.out.println("2~32之间的6个偶数之和为："+sum);

        //练习测试2
        double area=numformat.circlearea(2.2);
        System.out.println("半径为2.2的圆面积为："+area);

    }

    private double circlearea(double r){
        double area=Math.PI*Math.pow(r,2);
        DecimalFormat df=new DecimalFormat(".#####");  //数值格式化
        BigDecimal bd=new BigDecimal(df.format(area));  //用BigDecimal类将String转换为double
        return bd.doubleValue();  //将string转换为double
    }
    private void useapplypatternformat(String pattern,double val){
        DecimalFormat mydf=new DecimalFormat();
        mydf.applyPattern(pattern);
        mydf.setGroupingSize(4);  //设置分组大小
        mydf.setGroupingUsed(true);  //设置是否允许分租
        System.out.println(val+"格式化的数值为："+mydf.format(val));
    }

    private void simpleformat(String pattern,double val){
        DecimalFormat mydf=new DecimalFormat(pattern);
        mydf.setGroupingSize(4);  //设置分组大小
        mydf.setGroupingUsed(false);  //设置是否允许分租
        System.out.println(val+"格式化的数值为："+mydf.format(val));
    }

    private double getrandnum(double m,double n){  //返回指定范围的double随机数
        return m+Math.random()*(n-m);
    }

    private int getrandnum(int m,int n){  //返回指定范围的int随机，强制类型转换
        return (int)(m+Math.random()*(n-m));
    }

    private char getrandchar(char m,char n){  //返回指定字符范围的随机字符，强制类型转换
        return (char)(m+Math.random()*(n-m+1));
    }
}
