package main;

import JiaoHuDuiXiang.superJiaoHuDuiXiang;
import ShiTi.WanJia;
import beiJing.HuanJing;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {// 游戏屏幕
    final private int yuanShiXiangSu = 16;//原始像素,设置16像素
    final private int fangDaBeiShu = 3;//设置放大倍数


    final private int xiangSu = yuanShiXiangSu * fangDaBeiShu;//屏幕投影像素
    final private int maxKuan = 20;//最大素材宽度倍数
    final private int maxGao = 15;//最大素材高度倍数
    final private int kuan = maxKuan * xiangSu;//屏幕宽度像素   1920
    final private int gao = maxGao * xiangSu;//屏幕高度像素     1440

    final private int maxWorldKuan = 50;
    final private int maxWorldGao = 50;
    final private int worldKuan = xiangSu * maxWorldKuan;
    final private int worldGao = xiangSu * maxWorldGao;

    private final int fps =60;// 帧数


    public KeyHandler keyH = new KeyHandler();// 键盘监听
    public WanJia wanJia = new WanJia(this, keyH);// 玩家
    public HuanJing huanJing = new HuanJing(this);// 环境
    public PengZhuangXiangJianCe pengZhuangXiangJianCe = new PengZhuangXiangJianCe(this);
    public superJiaoHuDuiXiang[] jiaoHuDuiXiang = new superJiaoHuDuiXiang[10];
    public JHDX_Setter jhdxSetter = new JHDX_Setter(this);

    public Thread gameThread;//游戏线程


    public GamePanel() {
        this.setPreferredSize(new Dimension(kuan, gao));// 设置屏幕大小
        this.setBackground(Color.black);// 设置背景颜色为黑色
        this.setDoubleBuffered(true);// 双缓冲
        this.addKeyListener(keyH);// 添加键盘监听
        this.setFocusable(true);
    }

    public void setJiaoHuDuiXiang() {
        jhdxSetter.setJiaoHuDuiXiang();
    }

    public int getXiangSu() {
        return xiangSu;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {// 游戏核心
        double drawInterval = 1000000000 / fps;
        double jiShuQi = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(gameThread != null){
            currentTime=System.nanoTime();
            jiShuQi += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if(jiShuQi >= 1){
                // 1.更新数据
                genXin();
                // 2.绘制图像
                repaint();
                jiShuQi--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }

    }

    public void genXin(){// 更新数据
        wanJia.genXin();
    }

    @Override
    public void paintComponent(Graphics g){// 绘制图像
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;// 获取画笔
        huanJing.draw(g2);// 绘制环境

        for (int i = 0; i < jiaoHuDuiXiang.length; i++) {
            if (jiaoHuDuiXiang[i] != null) {
                jiaoHuDuiXiang[i].draw(g2, this);
            }

        }

        wanJia.draw(g2);// 绘制玩家

        g2.dispose();// 释放画笔
    }

    public int getYuanShiXiangSu() {
        return yuanShiXiangSu;
    }

    public int getFangDaBeiShu() {
        return fangDaBeiShu;
    }

    public int getFps() {
        return fps;
    }

    public KeyHandler getKeyH() {
        return keyH;
    }

    public WanJia getWanJia() {
        return wanJia;
    }

    public HuanJing getHuanJing() {
        return huanJing;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public int getMaxWorldKuan() {
        return maxWorldKuan;
    }

    public int getMaxWorldGao() {
        return maxWorldGao;
    }

    public int getWorldKuan() {
        return worldKuan;
    }

    public int getWorldGao() {
        return worldGao;
    }

    public int getMaxGao() {
        return maxGao;
    }

    public int getMaxKuan() {
        return maxKuan;
    }

    public int getGao() {
        return gao;
    }

    public int getKuan() {
        return kuan;
    }
}
