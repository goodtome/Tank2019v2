package com.mashibing.tank;

import com.mashibing.until.ResourceMgr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/12 6:46 上午
 */
public class Tank {
    public static final int SPEED= 5 ;
    private int x,y;
//    坦克的方向变量
    private Dir dir;
//    定义按下的建变量
    private boolean bL ,bU , bR ,bD;
//    坦克静止状态的变量
    private boolean moving = false;
//    对分组进行指定
    private final Group group;






    public Tank(int x, int y, Dir dir ,Group group) {
        this.x = x;
        this.y = y;
        this.dir=dir;
        this.group = group;
    }


    public  void paint(Graphics g) {
//        g.fillRect(x,y,50,50);

        if (this.group == Group.GOOD) {
            //画图，调佣工具类的方法, 只用加载一次就可以
            switch (dir) {
                case L:
                    g.drawImage(ResourceMgr.goodTankL, x, y, null);
                    break;
                case U:
                    g.drawImage(ResourceMgr.goodTankU, x, y, null);
                    break;
                case R:
                    g.drawImage(ResourceMgr.goodTankR, x, y, null);
                    break;
                case D:
                    g.drawImage(ResourceMgr.goodTankD, x, y, null);
                    break;
            }
        }

        if (this.group == Group.BAD) {
            //画图，调佣工具类的方法, 只用加载一次就可以
            switch (dir) {
                case L:
                    g.drawImage(ResourceMgr.badTankL, x, y, null);
                    break;
                case U:
                    g.drawImage(ResourceMgr.badTankU, x, y, null);
                    break;
                case R:
                    g.drawImage(ResourceMgr.badTankR, x, y, null);
                    break;
                case D:
                    g.drawImage(ResourceMgr.badTankD, x, y, null);
                    break;
            }
        }

        // 移动
        move();
    }



//   坦克移动的方法
    private void move() {
        if (!moving) {
            return;
        }
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

//    键盘按下和抬起的方法
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
//            dir = Dir.STOP;
            moving = false;
        }
        else
//        键盘其他键位变化
        {
            moving = true;
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
