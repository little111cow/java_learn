import java.util.*;

public class test_setclass {

    private List<Integer> testList(){
        List<Integer> l=new LinkedList<>();
        for(int i=1;i<=100;i++){
            l.add(i);
        }
        return l;
    }

    private void printout(List<Integer> l){
        Iterator<Integer> it=l.iterator();
        System.out.println("List集合中的元素为：");
        while(it.hasNext()){
            System.out.print((int)it.next()+" ");
        }
        System.out.println();
    }

    private void test_ListSet(){
        Set<String> set=new HashSet<>();
        set.add("A");
        set.add("a");
        set.add("c");
        set.add("C");
        set.add("a");  //不会报错但是最终的值只有一个
        Iterator<String> its=set.iterator();   //迭代器遍历
        System.out.println("集合中的元素为：");
        while (its.hasNext()){
            System.out.println(its.next());
        }
        List<String> l=new ArrayList<>();
        l.add("A");
        l.add("a");
        l.add("c");
        l.add("C");
        l.add("a");
        System.out.println("List中的元素为：");
        Iterator<String> itl=l.iterator();  //迭代器遍历
        while(itl.hasNext()){
            System.out.println(itl.next());
        }

    }

    private void test_map() {
        Emp e1 = new Emp("015", "liu jian");
        Emp e2 = new Emp("017", "la la");
        Emp e3 = new Emp("000", "go go");
        Map<String, Emp> mymap = new HashMap<>();
        mymap.put(e1.getid(), e1);
        mymap.put(e2.getid(), e2);  //添加键值对，值为Emp对象
        mymap.put(e3.getid(), e3);
        //遍历
        Iterator<String> itk = mymap.keySet().iterator();
        System.out.println("map的键值对为:");
        while (itk.hasNext()) {  //遍历
            String str = itk.next();
            Emp e = mymap.get(str);
            System.out.println(str + " " + e.getname());  //取出对象并获取name属性
        }
            mymap.remove("015");
            System.out.println(mymap.size());
            Iterator<String> itk1 = mymap.keySet().iterator();  //创建新的迭代器，改变后的map必须创建新的迭代器才能遍历
            System.out.println("map的键值对为:");
            while (itk1.hasNext()) {
                String s=itk1.next();
                Emp er=mymap.get(s);
                System.out.println(s + " " + er.getname());
              }
        }

    public static void main(String[] args){
        test_setclass tsc=new test_setclass();  //实列化对象
        List<Integer> l=tsc.testList();
        tsc.printout(l);
        l.remove(10);
        tsc.printout(l);

        tsc.test_ListSet();
        tsc.test_map();
    }
}

class Emp{  //创建Emp对象
    private String id;
    private String name;
    public Emp(String id,String name){  //构造方法
        this.id=id;
        this.name=name;
    }
    public String getid(){  //获取private id属性
        return this.id;
    }

    public String getname(){  //获取private name属性
        return this.name;
    }
        }