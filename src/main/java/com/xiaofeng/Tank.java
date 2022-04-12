package com.xiaofeng;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/12 6:46 上午
 */
public class Tank {
    private int x,y;
//    坦克的方向变量
    private Dir dir;
//    定义按下的建变量
    private boolean bL ,bU , bR ,bD;

    public static final int SPEED= 5 ;




    public Tank(int x, int y, Dir r) {
        this.x = x;
        this.y = y;
        this.dir=dir;
    }

    public  void paint(Graphics g){
        g.fillRect(x,y,50,50);

        //        移动
        move();
    }

//   坦克移动的方法
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
//          键盘的左边虚拟键
            case KeyEvent.VK_LEFT:
//                x -= SPEED;
//                dir = Dir.L;
                bL = true;
                break;
//          向右的箭头
            case KeyEvent.VK_RIGHT:
//                x += SPEED;
//                dir = Dir.R;
                bR = true;
                break;
            case KeyEvent.VK_UP:
//                y -= SPEED;
//                dir = Dir.U;
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
//                y += SPEED;
//                dir = Dir.D;
                bD = true;
                break;
        }
        setMainDir();

    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED ;
                break;
            case U:
                y -= SPEED ;
                break;
            case R :
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
//          键盘的左边虚拟键
            case KeyEvent.VK_LEFT:
           bL = false;
                break;
//          向右的箭头
            case KeyEvent.VK_RIGHT:
              bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
        setMainDir();
    }

    private void setMainDir() {
        if (!bL && !bU && !bR && !bD) {
//            定义在几个建都么有按下的时候，就停止
            dir = Dir.STOP;
        }
        if (bL && !bU && !bR && !bD) {
            dir = Dir.L;
        }
        if (!bL && bU && !bR && !bD) {
            dir = Dir.U;
        }
        if (!bL && !bU && bR && !bD) {
            dir = Dir.R;
        }
        if (!bL && !bU && !bR && bD) {
            dir = Dir.D;
        }
    }
}
