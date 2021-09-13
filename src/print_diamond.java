import java.util.Scanner;

public class print_diamond {
    public static void main(String[] args){
        int rows=0;
        Scanner in=new Scanner(System.in);
        System.out.println("输入菱形行数：");
        rows=in.nextInt();
        while(rows%2==0){
            System.out.println("菱形行数为奇数，请重新输入：");
            rows=in.nextInt();
        }
        int n=(rows+1)/2;
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("+");
            }
            System.out.print("\n");
        }
        for(int i=n-1;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-1;k++){
                System.out.print("+");
            }
            System.out.print("\n");
        }
    }
}
