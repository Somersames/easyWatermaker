package core;

import config.WaterConfig;
import core.font.LocalFont;
import core.font.WaterFont;
import core.img.ImageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2019-11-22 09:47
 * @Author https://github.com/Somersames
 **/

public class Maker {

    private static Logger log = LogManager.getLogger();

    /**
     * 通过系统第一个默认字体来生成水印
     * @param height
     * @param width
     */
    private void generate(int height, int width) throws Exception {
        ImageUtil util = new ImageUtil();
        BufferedImage bufferedImage = util.getImageByDefaultFont(height,width,100,"测试");
        File imgFile = new File("/Users/sunzhaohui/Desktop/person/water/water.png");
        try {
            ImageIO.write(bufferedImage, "PNG", imgFile);
        } catch (IOException e) {
            log.error("file create error,e : ", e);
        }
    }

    /**
     * 通过系统第一个默认字体来生成水印
     * @param height
     * @param width
     * @Param font
     */
    private void generateByFont(int height, int width, Font font) throws Exception {
        ImageUtil util = new ImageUtil();
        BufferedImage bufferedImage = util.getImage(height,width,100,"123123",font);
        File imgFile = new File("/Users/sunzhaohui/Desktop/person/water/测试.png");
        try {
            ImageIO.write(bufferedImage, "PNG", imgFile);
        } catch (IOException e) {
            log.error("file create error,e : ", e);
        }
    }

    public static void main(String[] args) throws Exception {
        WaterConfig waterConfig = new WaterConfig.Builder()
                .setPicPath("/Users/sunzhaohui/Desktop/person/water/")
                .setFontPath("/Users/sunzhaohui/Documents/watermarker/simsun.ttf")
                .create();
        Maker maker = new Maker();
        WaterFont waterFont = new LocalFont();
        Font font = waterFont.getFontByPath(waterConfig.getFontPath(),100);
        font.deriveFont(Font.PLAIN,100);
        maker.generateByFont(800,200,font);
    }

}
