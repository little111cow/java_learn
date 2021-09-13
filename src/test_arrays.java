import java.util.Arrays;
import java.util.Random;

public class test_arrays {
    public static void main(String[] args){
        Random rd = new Random();
        int[] arr1=new int[10];
        int[] arr2;

        for(int i=0;i<10;i++){
            arr1[i]=rd.nextInt(100);
        }

        arr2= Arrays.copyOfRange(arr1,0,4);  //1.复制数组

        test_arrays mt=new test_arrays();
        mt.showarr(arr1);  //非静态方法只能通过实列访问
        mt.showarr(arr2);

        int min=mt.getmin(arr1);
        System.out.println("数组arr1的最小值为："+min);

        String[] mystr=new String[]{"liu","jian","cdma","noma","ofdm","modulation","dowmlink"};
        mt.showarr(mystr);

        mystr[2]="bb";  //替换
        mt.showarr(mystr);

//        StringBuffer mb=new StringBuffer();  //操作字符串的重要的类和StringBuilder类一样重要
//        for(String s:mystr){
//            mb.append(s);
//        }
//        mb.replace(2,3,"bb");  //将索引为2的值替换
//        System.out.println(mb.toString());

        int[][] arr2demension=new int[5][5];  //4.矩阵转置与输出
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr2demension[i][j]=rd.nextInt(10);
            }
        }
        mt.printout(arr2demension);
        mt.turn(arr2demension);
        mt.printout(arr2demension);
    }

    private void  showarr(int[] arr){  //打印数组
        System.out.println("数组内容为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private void  showarr(String[] arr){  //打印字符串数组
        System.out.println("数组内容为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private int getmin(int [] arr){  //2.获取数组最小值
        int min=arr[0];
        for(int a:arr){
            if(a<min){
                min=a;
            }
        }
        return min;
    }

    private void turn(int[][] arr){  //3.矩阵转置，行列数相同
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i>j){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }
    }

    private void printout(int[] [] arr){  //按照矩阵格式打印
        System.out.println("二维数组的元素为：");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}

