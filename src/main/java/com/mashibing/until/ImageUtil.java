package com.mashibing.until;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/14 11:42 下午
 *   封装图片的方法
 */
public class ImageUtil {

    public static BufferedImage rotateImage (final  BufferedImage bufferedImage ,
                                             final  int degrees ){
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage img ;
        Graphics2D graphics2D ;
        (graphics2D = (img = new BufferedImage( w,h,type))
                .createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.rotate(Math.toRadians(degrees),w/2,h/2);
        graphics2D.drawImage(bufferedImage,0,0,null);
        graphics2D.dispose();

        return img;


    }

}
