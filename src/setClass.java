import java.math.BigDecimal;
import java.util.*;

public class setClass {  //集合类
    public static void main(String[] args){
        setClass mysetclass=new setClass();

        //Collecttion接口
        Collection<String> list=new ArrayList<>();  //创建String类数组列表集合类
        list.add("liu jian");
        list.add("haha");
        list.add("wanyurou");
//        mysetclass.printout(list);

        //List接口
        List l=new ArrayList<>();  //数组实现，不指定类型则可以添加任何类型的值
//        List<String> l=new LinkedList<>();  //链表实现
        for(int i=0;i<10;i++){
            l.add(i);
        }
        mysetclass.printout(l);
        System.out.println(l.get(2));  //获取指定索引处的值
        l.set(2,"afd");  //设置指定索引的值
        System.out.println(l.get(2));  //获取指定索引处的值
        System.out.println(l.size());  //获取大小
        System.out.println(l.isEmpty());  //判断是否为空
        l.remove(3);  //删除指定索引的值 还可以l.remove("4");删除指定值
        System.out.println(l.contains("4"));  //判断是否包含指定值
        l.toArray();  //转换为数组
//        for(int s:l){
//            System.out.println(s);  //不转换为数值好像也可以这么遍历
//        }
        mysetclass.printout(l.subList(0,2));  //从索引0到2的子列表,不包括2


    }

//    private void printout(Collection<String> list){  //传入一个集合类对象作为参数，创建迭代求打印输出
//        Iterator<String> it=list.iterator();  //创建一个迭代器
//        while (it.hasNext()){  //判断有无内容
//            System.out.println(it.next());  //输出值
//        }
//    }

    private void printout(List list){  //传入一个集合类对象作为参数，创建迭代求打印输出
        Iterator it=list.iterator();  //创建一个迭代器
        while (it.hasNext()){  //判断有无内容
            System.out.println(it.next());  //输出值
        }
    }

}
