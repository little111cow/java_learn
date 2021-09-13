public class packageClass {
    public static void main(String[] args) {
        Integer testint = new Integer("12345");  //数值类包装类均匀两种构造方法，若不是数的字符串会抛出异常
        Integer testint1 = new Integer(12345);

        //测试包装类的常用方法
        System.out.println(testint);
        String s="23452";
        System.out.println(Integer.parseInt(s));  //返回字符串对应的整数值parseInt（str）

        System.out.println(testint.compareTo(testint1));  //比较对应的值是否相同，相等为0，不等大于输出正值，小于输出负值

        System.out.println(Integer.valueOf(s));  //返回字符串对应的Integer对象

        System.out.println(Integer.toString(9863));  //返回整数对应的Integer对象

        int cons=Integer.MAX_VALUE;  //可取的最大值、还有MIN_VALUE、SIZE、TYPE
        System.out.println(Integer.toString(cons));  //还有toBinaryString、toHexString、toOctalString

        Boolean b=testint.equals(testint1);  //比较对象的内容是否相同
        System.out.println(b);

        Integer my=new Integer("12");
        System.out.println(my.intValue());  //非静态方法，要通过对象访问

        Character c=new Character('a');
        Character c1=new Character('A');
        System.out.println(c.equals(c1));

        System.out.println(c.equals(Character.toLowerCase(c1)));

        Boolean bol=new Boolean("true");
        System.out.println(bol.toString());
    }
}
