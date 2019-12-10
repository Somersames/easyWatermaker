package core.img;


import core.exception.FontNotFountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * @Description TODO
 * @Date 2019-11-22 14:10
 * @Author https://github.com/Somersames
 **/

public class ImageUtil {

    private static Logger log = LogManager.getLogger();

    /**
     *
     * @param width
     * @param height
     * @param fontHeight
     * @param content
     * @return
     */
    public static BufferedImage getImage(int width, int height, int fontHeight, String content,Font font,Color color) throws Exception {
        try {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = img.createGraphics();
            //  start
            img = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
            gd = img.createGraphics();
            //设置透明  end
            gd.setFont(font);
            gd.setColor(color); //设置颜色
            gd.drawString(content, width / 2 - fontHeight * content.length() / 2, fontHeight);
            return img;
        } catch (Exception e) {
            log.error("the waterMarker has an error:{}", e);
            throw e;
        }
    }

    /**
     * 通过系统默认的第一个字体创建水印
     * @param height
     * @param width
     * @param fontHeight
     * @param content
     * @return
     */
    public static BufferedImage getImageByDefaultFont(int height, int width, int fontHeight, String content) throws Exception {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
        if(Objects.isNull(fonts) || fonts.length == 0){
            throw new FontNotFountException("cannot find font by default");
        }
        Font font = fonts[0];
        font.deriveFont(Font.PLAIN,fontHeight);
        return getImage(height,width,fontHeight,content,font,Color.GRAY);
    }

}