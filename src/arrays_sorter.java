import java.util.Random;

public class arrays_sorter {
    static int id=100;
    public static void main(String[] args){
        int size=10;
        Random rd=new Random();
        int[] myarr=new int[size];
        for(int i=0;i<size;i++){
            myarr[i]=rd.nextInt(100);
        }

        arrays_sorter a1=new arrays_sorter();
        arrays_sorter a2=new arrays_sorter();
        a1.id++;
        System.out.println(a1.id);
        System.out.println(a2.id);//static 关键字定义的变量和方法会被改变？

        arrays_sorter.showarr(myarr);
        arrays_sorter.bubble_sort(myarr);
        arrays_sorter.showarr(myarr);

        arrays_sorter.select_sort(myarr);
        arrays_sorter.showarr(myarr);

        arrays_sorter.reverse(myarr);
        arrays_sorter.showarr(myarr);


    }

    private static void bubble_sort(int [] arr){  //冒泡排序
        int len=arr.length;
        for(int i=len-1;i>0;i--){  //排序轮数
            for(int j=0;j<i;j++){  //比较轮数
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];  //交换
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    private static void select_sort(int[] arr){  //选择排序
        int len=arr.length;
        for(int i=0;i<len-1;i++){  //选择轮数
            int minindex=i;
            for(int j=i+1;j<len;j++){  //找最小值所在索引
                if(arr[j]<arr[minindex]){
                    minindex=j;
                }
            }
            int temp=arr[minindex];  //交换
            arr[minindex]=arr[i];
            arr[i]=temp;
        }
    }

    private static void reverse(int[] arr){  //反转排序
        int len=arr.length;
        for(int i=0;i<len/2;i++){  //只进行长度的一半否则又回到原序
            int temp=arr[i];
            arr[i]=arr[len-i-1];
            arr[len-i-1]=temp;
        }
    }

    private static void showarr(int[] arr){
        System.out.println("数组内容为：");
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }


}
