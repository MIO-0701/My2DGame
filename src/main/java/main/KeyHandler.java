package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {// 接收键盘输入
    public boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false;
    @Override
    public void keyTyped(KeyEvent e) {// 按下并且释放时调用
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =e.getKeyCode();// 按下时调用
        if (code==KeyEvent.VK_W){
            upPressed = true;
        }
        if(code==KeyEvent.VK_S){
            downPressed = true;
        }
        if(code==KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code==KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =e.getKeyCode();// 释放时调用
        if (code==KeyEvent.VK_W){
            upPressed = false;
        }
        if(code==KeyEvent.VK_S){
            downPressed = false;
        }
        if(code==KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code==KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
