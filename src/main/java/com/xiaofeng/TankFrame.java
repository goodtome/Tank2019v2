package com.xiaofeng;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/11 10:48 下午
 */
public class TankFrame extends Frame {
/*//    定义x的坐标值
    private int x =100 ,y=100;*/

    private  Tank myTank;
    private Tank enemy ;

    public static int SPEED = 5;

    public TankFrame(){
        this.setTitle("坦克 大战");
//        设置坐标
        this.setLocation(500,100);
//        设置宽度和高度
        this.setSize(900,700);

//       添加键盘监听 ，相应键盘事件，观察者模式observer
        this.addKeyListener(new TankKeyListener() );

//        赋值新的
        myTank = new Tank(100,100,Dir.R);
        enemy = new Tank(200, 200, Dir.D);
    }

/**  paint方法的自动调用，
 *  Graphics g 图形界面，系统传递的参数，已经实现了初始化
 * */
    @Override
    public void paint(Graphics g) {
/*        设置方块
        g.fillRect(x,y,50,50);*/
        myTank.paint(g);
        enemy.paint(g);
      }

//    设置内部类，不让别的类访问键盘事件，高类聚低耦合
    private class TankKeyListener extends KeyAdapter {

//        重写想要重写键盘的方法
    @Override
    public void keyPressed(KeyEvent e) {
      myTank.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        myTank.keyReleased(e);

    }

}
}
