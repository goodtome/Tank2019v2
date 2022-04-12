package com.xiaofeng;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/11 10:49 下午
 */
public class Main {
    public static void main(String[] args) {
/**
 *
 //        窗口命名
        Frame f = new Frame("tank war");
//        设置坐标
        f.setLocation(200,100);
//        设置宽度和高度
        f.setSize(800,600);
        f.setVisible(true);*/

        TankFrame tf = new TankFrame();
        tf.setVisible(true);

        for (;;){
            try {
//                TimeUnit.MICROSECONDS.sleep(25);
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            每25秒调用一次repaint方法，repaint会调用update方法，然后调用paint方法
            tf.repaint();
        }
    }
}
