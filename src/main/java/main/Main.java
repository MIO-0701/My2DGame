package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();//创建窗口对象
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口时程序退出
//        window.setResizable(false);//设置窗口大小不可变
        window.setTitle("我的2D游戏");//设置窗口标题

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);//将游戏面板添加到窗口中
        window.pack();//设置窗口大小自适应组件大小

        window.setLocationRelativeTo(null);//设置窗口居中显示
        window.setVisible(true);//设置窗口可见

        gamePanel.setJiaoHuDuiXiang();
        gamePanel.startGameThread();
    }
}
