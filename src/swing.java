import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class swing extends JFrame {
    public void creatJFrame(String title){
        JFrame jf =new JFrame(title);//实例化一个JFrame对象
        Container con =jf.getContentPane();//获取一个容器，这一句很关键
        JLabel jl= new JLabel("窗体");//创建标签
        jl.setHorizontalAlignment(SwingConstants.CENTER);//设置字体居中
        con.add(jl);//给窗体加标签
        con.setBackground(Color.WHITE);//设置窗体背景色为白
//        jf.add(jl);  这两句这样写是不起作用的，如果没有获取容器的话
//        jf.setBackground(Color.BLACK);
        jf.setVisible(true);//窗体可视化
        jf.setSize(700,650);//窗体大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗体退出方式
    }
    public static void main(String args[]){
        new swing().creatJFrame("创建窗体");
    }
}
