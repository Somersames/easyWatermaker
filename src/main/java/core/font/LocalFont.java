package core.font;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description read font from local
 * @Date 2019-11-22 09:53
 * @Author https://github.com/Somersames
 **/

public class LocalFont implements WaterFont {

    private static String fontPath;


    private final float DEFAULT_SIZE = 100;
    /**
     *  从本地获取字体文件
     * @return
     */
    public Font getFont(float fontSize) throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File(fontPath))).deriveFont(Font.PLAIN,fontSize);
    }

    @Override
    public Font getFont() throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File(fontPath))).deriveFont(Font.PLAIN,DEFAULT_SIZE);
    }

    /**
     *  从本地获取字体文件(指定路径)
     * @return
     */
    @Override
    public Font getFontByPath(String path,float fontSize) throws IOException, FontFormatException {
        if(fontSize == 0){
            throw new IllegalArgumentException("fontSize can not be zero");
        }
        this.fontPath = path;
        return getFont(fontSize);
    }

    /**
     * 取系统的默认字体
     * @return
     */
    public Font getFontByDefault(){
        // TODO 从系统获取默认字体
        return null;
    }
}
