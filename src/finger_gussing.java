import java.util.*;
import java.util.Scanner;
import java.util.Random;
public class finger_gussing {
    public static void main(String[] args) {//程序入口
        while (true) {
            Scanner input = new Scanner(System.in);//人机交互方法
            System.out.println("——————猜拳游戏——————\n\t\t游戏规则：\n玩家输入数字0代表出剪刀；\n玩家输入数字1代表出石头；\n玩家输入数字2代表出布.");
            System.out.println("请出拳（0剪刀；1石头；2布；）：");
            int box = input.nextInt();//人出拳
            Random computer = new Random();//随机数方法
            int com = computer.nextInt(3);//产生0到2的随机数，即电脑出拳
            /*由数字判断人出拳情况 */
            if (box == 0 || box == 1 || box == 2) {
                switch (com) {
                    case 0:
                        System.out.println("电脑出剪刀。");
                        break;
                    case 1:
                        System.out.println("电脑出石头。");
                        break;
                    case 2:
                        System.out.println("电脑出布。");
                        break;
                    default:
                        System.out.println("出拳错误！请按照规则重新出拳！");
                }
                switch (box) {
                    case 0:
                        System.out.println("你出剪刀。");
                        break;
                    case 1:
                        System.out.println("你出石头。");
                        break;
                    case 2:
                        System.out.println("你出布。");
                        break;
                    default:
                        System.out.println("出拳错误！请按照规则重新出拳！");//这是人输入的数字可能发生
                /*设置容错次数为100次，如果一直输入不正确,
                则一直输入,直到正确输入，
                如果次数超过100次跳出循环
                */
                }
            } else {
                for (int i = 0; i < 100; i++) {
                    System.out.println("出拳错误！请按照规则重新出拳！");
                    box = input.nextInt();//人出拳
                    if (!(box == 0 || box == 1 || box == 2)) {
                        continue;
                    } else {
                        switch (box) {//判断正确输入后的人出拳情况
                            case 0:
                                System.out.println("你出剪刀。");
                                break;
                            case 1:
                                System.out.println("你出石头。");
                                break;
                            case 2:
                                System.out.println("你出布。");
                                break;
                            default:
                                System.out.println("出拳错误！请按照规则重新出拳！");
                        }
                        /*由数字判断电脑出拳情况 */
                        switch (com) {
                            case 0:
                                System.out.println("电脑出剪刀。");
                                break;
                            case 1:
                                System.out.println("电脑出石头。");
                                break;
                            case 2:
                                System.out.println("电脑出布。");
                                break;
                            default:
                                System.out.println("出拳错误！请按照规则重新出拳！");
                        }
                    }
                    break;
                }
            }
            /*判断输赢情况*/
            if (box == 0 || box == 1 || box == 2) {//判断人是否正确出拳
                //平局
                if ((box == 0 && com == 0) || (box == 1 && com == 1) || (box == 2 && com == 2)) {
                    System.out.println("---平局！");
                    //人输
                } else if ((box == 0 && com == 1) || (box == 1 && com == 2) || (box == 2 && com == 0)) {
                    System.out.println("-_-你输了！");
                    //人赢
                } else {
                    System.out.println("^_^你赢了！");
                }
                //错误次数超过100次，进行游戏重启
            } else {
                System.out.println("出拳错误！请按照规则出拳,请重新启动,仔细阅读规则！");
            }
        }
    }
}
