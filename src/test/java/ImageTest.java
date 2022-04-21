

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @project Tank2019v2
 * @Author tom
 * @create 2022/4/13 11:40 下午
 */
public class ImageTest {

    @Test
    public void testLoadImage(){
       try {
           //方案一：迁移后就不好用了，目录文件必须一致才行
           BufferedImage image = ImageIO.read(new File("/Users/tom/5-learn/code/Tank2019v2/src/images/0.png"));
           //存入到内存中不为空
           assertNotNull(image);

           //方案二：getResourceAsStream通过查找资源流进行查找
           BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("src/images/坦0克.png"));
           assertNotNull(image2);

       }catch (IOException e) {
           e.printStackTrace();
       }
    }

//    //旋转图片的方法测试
//    @Test
//    public void testRotateImage() {
//        try{
//            BufferedImage tank1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images"));
//            tank1 = rotateImage(tank1,90);
//            assertNotNull(tank1);
//        }catch (IOException e) {
//        e.printStackTrace();
//        }
//    }
//
//    private BufferedImage rotateImage(final  BufferedImage bufferedImage,
//                                      final int degree) {
//        int w = bufferedImage.getWidth();
//        int h = bufferedImage.getHeight();
//        int type = bufferedImage.getColorModel().getTransparency();
//
//        BufferedImage image;
//        Graphics2D graphics2D;
//        (graphics2D = (image = new BufferedImage(w,h,type)).createGraphics()).setRenderingHints(
//                RenderingHints.KEY_INTERPOLATION,
//                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        graphics2D.rotate(Math.toRadians(degree),w/2,h/2);
//        graphics2D.drawImage(bufferedImage,0,0,null);
//        graphics2D.dispose();
//        return image;
//    }
}
