package com.mashibing.until;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/14 11:51 下午
 *      放一些静态的资源
 *
 */
public class ResourceMgr {

    public static BufferedImage goodTankL , goodTankR , goodTankU,goodTankD;
    public static BufferedImage badTankL, badTankR,badTankU,badTankD;
    public static BufferedImage bulletuL, bulletuR,bulletuU,bulletuD;

    public static BufferedImage [] explodes = new BufferedImage[16] ;

    static {
        try {
        goodTankU = ImageIO .read(ResourceMgr.class.getResourceAsStream("images/GoodTank1.png"));
        goodTankL = ImageUtil.rotateImage(goodTankL,-90);
        goodTankR = ImageUtil.rotateImage(goodTankR,90);
        goodTankD = ImageUtil.rotateImage(goodTankD,180);

        badTankU = ImageIO.read(ResourceMgr.class.getResourceAsStream("images/BadTank1.png"));
        badTankL = ImageUtil.rotateImage(goodTankL,-90);
        badTankR = ImageUtil.rotateImage(goodTankR,90);
        badTankD = ImageUtil.rotateImage(badTankD,180);

        bulletuU = ImageIO.read(ResourceMgr.class.getResourceAsStream("images/bulletu.png"));
        bulletuL = ImageUtil.rotateImage(bulletuL,-90);
        bulletuR = ImageUtil.rotateImage(bulletuR,90);
        bulletuD = ImageUtil.rotateImage(bulletuD,180);

        for (int i = 0; i < 16; i++){
            explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)));
        }

    }catch(IOException e) {
            e.printStackTrace();
         }
    }
}
