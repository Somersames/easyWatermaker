package core.font;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2019-11-22 09:50
 * @Author https://github.com/Somersames
 **/

public interface WaterFont {

    /**
     * 获取字体文件，本地或者Http等
     * @return
     */
    Font getFont() throws IOException, FontFormatException;


    Font getFontByPath(String path,float fontSize) throws IOException, FontFormatException;
}
