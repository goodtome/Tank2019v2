package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/11 10:48 下午
 */
public class TankFrame extends Frame {
/*//    定义x的坐标值
    private int x =100 ,y=100;*/

    public  static final TankFrame INSTANCE = new TankFrame();
    private static final int GAME_HEIGHT = 800; // 宽度的参数常量
    private static final int GAME_WIDTH = 600; //  参数常量
    private  Tank myTank;
    private Tank enemy ;
    private Group group;

    public static int SPEED = 5;

    public TankFrame(){
        this.setTitle("坦克 大战");
//        设置坐标
        this.setLocation(500,100);
//        设置宽度和高度
        this.setSize(GAME_WIDTH,GAME_HEIGHT);

//       添加键盘监听 ，相应键盘事件，观察者模式observer
        this.addKeyListener(new TankKeyListener() );

//        赋值新的变量值
        myTank = new Tank(100,100,Dir.R,Group.GOOD);
        enemy = new Tank(200, 200, Dir.D,Group.BAD);
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

      /**解决游戏的双缓冲的问题, 在游戏中都使用这个方法*/
      Image offScreenImage = null;

      @Override
      public void update(Graphics g) {
          if (offScreenImage == null) {
              offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
          }
          Graphics goffScreen = offScreenImage.getGraphics();
          Color c = goffScreen.getColor();
          goffScreen.setColor(Color.BLACK);
          goffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
          goffScreen.setColor(c);
          paint(goffScreen);
          g.drawImage(offScreenImage,0,0,null);

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
