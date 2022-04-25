package com.mashibing.tank;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/22 00:26
 *    子弹类
 */
public class Bullet {


    private int  x,y; //坐标

    private Dir dir;  //方向

    private static final int SPEED =10 ; //速度

    // 构造方法
    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    // 画子弹的方法

}
