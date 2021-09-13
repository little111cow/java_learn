import java.util.Date;
import java.util.Locale;
import java.lang.StringBuilder;

public class string {
    public static void  main(String[] args){
        char [] mychar={'l','i','u',' ','j','i','a','n'};
        String mystring=new String(mychar);
        System.out.println(mystring);

        String mystring3=new String(mychar,2,4);
        System.out.println(mystring3);

        String mystring1=new String("good!");
        System.out.println(mystring1);

        String mystring2;
        mystring2="nice!";
        System.out.println(mystring2);

        mystring=mystring.concat("bbb");  //会创建新的对象，所以要赋值才会有输出，否则被忽略
        System.out.println(mystring);

        //连接字符串用+号
        String s=mystring+" "+mystring1+" "+mystring2+" "+mystring3;
        System.out.println(s);
        //或者用String类的concat方法
        String s1=mystring.concat(" ").concat(mystring1.concat(" ")).concat(mystring2.concat(" ")).concat(mystring3);
        System.out.println(s1);

        //可以用连接符换行书写字符串
        System.out.println("abcdef" +
                "dfdifjif");

        //与其它类型数据连接会自动调用toString方法
        String mystr="liu jian";
        int a=10;
        boolean b=false;
        float c=1.12f;
        double d=1.23;
        System.out.println(mystr+a);
        System.out.println(mystr+b);
        System.out.println(mystr+c);
        System.out.println(mystr+d);
        System.out.println(mystr+(c+d));  //此处又有隐式数据类型转换，将float型转为double型

        //常用方法测试
        System.out.println("索引为4的字符为："+mystr.charAt(4));  //获取指定索引的字符
        System.out.println("字符串的长度为："+mystr.length());  //获取字符串长度
        System.out.println("字符i首次出现的索引为:"+mystr.indexOf("i"));  //获取字符或者字符串首次出现的位置，没有放回-1
        System.out.println("字符i最后一次出现的索引为:"+mystr.lastIndexOf("i"));  //获取字符或者字符串最后一次出现的位置，没有放回-1

        //获取子字符串
        String str1=mystr.substring(1,5);  //索引从1到4的字符串，注意不包含5
        System.out.println(str1);
        System.out.println(mystr.substring(5));  //如果不指定endindex，默认到结尾所以的字符串

        //去除左右空格trim()
        String str="  liu jian  ";
        System.out.println(str.trim());
        System.out.println("原字符串的长度为："+str.length());
        System.out.println("去除空格的字符串长度为："+str.trim().length());

        //字符串的替换
        System.out.println(str.replace("liu","xiao"));  //将原来的部分字符串或者字符替换为新的串

        //判断开始与结束字符串是否是指定的字符串返回bool值
        System.out.println("字符串以空格开始？"+str.startsWith(" "));
        System.out.println("字符串以\"jian  \"结束？"+str.endsWith("jian  "));

        //字符串的浅相等和深相等==和equals()区分大小写或者equalsIgnoreCase（）忽略大小写的比较方法的区别
        String s0=new String("liu jian");
        String S0=new String("liu jian");

        System.out.println("字符串s0和S0是同一个对象？"+(s0==S0));  //这里若采用对象引用的方法赋值，两者对象内存相同
        System.out.println("字符串s0和S0的内容相同？"+s0.equals(S0));

        //按照字典序比较字符串，str.compareTo(str1)、str.compareToIgnoreCase(str1)方法，在str1之前则返回负值，之后返回正值，相等返回0
        System.out.println("a".compareTo("b"));  //返回unicode编码差值
        System.out.println("liu jian".compareTo("Liu Jian"));  //返回unicode编码差值
        System.out.println("liu jian".compareToIgnoreCase("Liu Jian"));

        //大小写转换
        System.out.println("a 123".toUpperCase());  //数字和非字符不受影响
        System.out.println("JIAN 健健123？".toLowerCase());

        //字符串分割split（str sign）方法,按照指定字符或者符号或者字符串进行分割，返回字符串数组
        String mys="liu,jian,wan,yu,rou,wu,jiao,yi";
        String [] mystrarr;
        mystrarr=mys.split(",");
        for(String ms:mystrarr){
            System.out.println(ms);
        }

        String[] mystrarr1;
        mystrarr1=mys.split(",",4); //限制分割为4部分即只分割3次,可以使用正则表达式
        for(String ms:mystrarr1){
            System.out.println(ms);
        }

        //字符串转化为字符数组toCharArray()方法
        char[] chararr=mys.toCharArray();
        for(char myc:chararr){
            System.out.println(myc);
        }

        //String类静态方法format，格式化日期、时间常用
        System.out.println("字符串的散列值是："+String.format("%h",mys));  //格式化字符串，%h为格式字符，表示散列值
        System.out.println("50/3的整数部分为："+String.format("%d",50/3));
        System.out.println("50>3?："+String.format("%b",50>3));

        Date mydate=new Date();
        String year=String.format(Locale.CHINA,"%tY",mydate);
        String month=String .format(Locale.CHINA,"%tm",mydate);
        String day=String .format(Locale.CHINA,"%td",mydate);
        System.out.println("今天是："+year+"年"+month+"月"+day+"日");

        String hour=String .format(Locale.CHINA,"%tH",mydate);
        String minute=String .format(Locale.CHINA,"%tM",mydate);
        String second=String .format(Locale.CHINA,"%tS",mydate);
        System.out.println("现在是："+hour+"时"+minute+"分"+second+"秒");

        System.out.println(String .format(Locale.CHINA,"%tc",mydate));  //全部的日期和时间，转换符%tc

        //可变字符串类StringBuilder类,操作时不会创建新的对象
        StringBuilder sb=new StringBuilder("liu jian");

        sb.append(" hello");  //追加方法
        System.out.println(sb.length());  //长度，String类的方法属性仍然可用
        System.out.println(sb.toString());  //输出需要使用toString()方法

        sb.insert(0,"ni hao! ");
        System.out.println(sb.charAt(0));  //指定索引处的字符
        System.out.println(sb.toString());

        sb.delete(0,3);  //删除字符索引为0，1，2的字符
        System.out.println(sb.toString());
        sb.deleteCharAt(2);  //删除指定索引的字符
        System.out.println(sb.toString());

        sb.reverse(); //反转字符串
        System.out.println(sb.toString());

        //还有substring（）、replace（）、indexof（）、lastindexof（）等常用方法

        char r='1';
        System.out.println((int)r);
    }
}
