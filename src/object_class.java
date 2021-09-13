public class object_class {
    private int id=10;

    public void setval(int id){
        this.id=id;
    }

    public int getval(){
        return this.id;
    }
}

class object_class1 extends object_class{
    public object_class1(){
        super();  //调用父类构造方法
    }
    public static void main(String[] args) {
        object_class1 oc = new object_class1();
        System.out.println(oc.getval());
//        System.out.println(oc.id);  由于private权限控制，无法访问

        oc.setval(15);
        System.out.println(oc.getval());

        trangle mytr=new trangle();
        System.out.println(mytr.area());

        for(int i=0;i<args.length;i++){
            System.out.println(i);
        }
    }
}

class trangle{  //2矩形面积求解方法
    double len;
    double width;
    public trangle(){
        this.len=10.2;
        this.width=3.7;
    }

    public double area(){
        return this.len*this.width;
    }
}
