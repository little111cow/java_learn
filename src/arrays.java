import java.util.Arrays;
import java.util.Random;


public class arrays {
    public static void main(String[] args){
        //创建数组的两种方法
        //1.创建并分配内存,编程时常使用这种方式
        int[] arrs =new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        //2.先创建再分配内存
        //int arrs[];或者int[] arrs;
        //arrs=new int[10];
        for(int i=1;i<=12;i++){
            System.out.println(i+"月有"+arrs[i-1]+"天。");
        }

        //Arrays类fill方法
        System.out.println();
        Arrays.fill(arrs,1,4,9);
        for(int i=1;i<=12;i++){
            System.out.println(i+"月有"+arrs[i-1]+"天。");
        }

        //Arrays类copyof方法和copyofRange方法
        int[] arrs3=Arrays.copyOf(arrs,15);
        System.out.println("数组中的元素是：");
        showarray(arrs3);
        int[] arrs4=Arrays.copyOfRange(arrs,3,7);
        System.out.println("数组中的元素是：");
        for(int i=0;i<arrs4.length;i++){
            System.out.println(arrs4[i]);
        }
        //Array类的binarySearch索引方法
        int[] arrs5 =new int[]{4,2,31,8,1,98,331,309,332,780,3891};
        Arrays.sort(arrs5);//使用binarysearch方法需要排序，否则输出结果不确定
        int index=Arrays.binarySearch(arrs5,98);
        int index1=Arrays.binarySearch(arrs5,2,7,8);
        System.out.println("98的索引为："+index);
        System.out.println("8的索引为："+index1);
        //二维数组的创建 1.先创建再分配内存
        int[][] arrs1;
        arrs1=new int[][]{{1},{1,2},{1,2,3},{1,2,3,4}};
        //2.创建并分配内存 int arrs1=new int[4][5];
        //嵌套for循环遍历二维数组
        System.out.println();
        for (int j=0;j<arrs1.length;j++) {
            for (int k=0;k<arrs1[j].length;k++) {
                System.out.print(arrs1[j][k]);
            }
            System.out.println();
        }
        //foreach语句遍历二维数组
        int[][] arrs2=new int[][]{{1,1},{1,2,3,4},{3,4,5,6},{0,9,8,7,6}};
        System.out.println();
        System.out.println("数组中的元素是：");
        showarray(arrs2);

        //产生随机数数组
        Random rd=new Random();
        int[] myarr=new int[100];
        for(int i=0;i<100;i++) {
            myarr[i] = rd.nextInt(100);
        }

        Arrays.sort(myarr);
        showarray(myarr);

    }

    public static void showarray(double[] arr){
        for(double a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void showarray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void showarray(String[] arr){
        for(String a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void showarray(int[][] arr){
        for(int[] a:arr){
            for(int ai:a) {
                System.out.print(ai+" ");
            }
        }
        System.out.println();
    }

    public static void showarray(double[][] arr){
        for(double[] a:arr){
            for(double ai:a) {
                System.out.print(ai+" ");
            }
        }
        System.out.println();
    }

    public static void showarray(String[][] arr){
        for(String[] a:arr){
            for(String ai:a) {
                System.out.println(ai+" ");
            }
        }
        System.out.println();
    }
}
