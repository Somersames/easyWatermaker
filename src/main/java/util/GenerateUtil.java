package util;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import config.WaterConfig;
import core.img.ImageUtil;
import core.pdf.PdfUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2019-12-07 13:48
 * @Author https://github.com/Somersames
 **/

public class GenerateUtil {

    private static Logger log = LogManager.getLogger(GenerateUtil.class);

    public static void generatePdfMaker(int width, int height, int fontHeight, String content, Font font, WaterConfig waterConfig) throws Exception {
        // TODO
        PdfReader pdfReader = new PdfReader(PdfUtil.getPdfByLocal(waterConfig.getPdfPath()));
        // FIXME 是否忽略密码
        PdfReader.unethicalreading = true;
        int total = pdfReader.getNumberOfPages() + 1;
        String filePath = waterConfig.getPicPath() + content + ".png";
        File imgFile = new File(filePath);
        try {
            ImageIO.write(ImageUtil.getImage(width,height,fontHeight,content,font), "PNG", imgFile);
        } catch (IOException e) {
            log.error("file create error,e : ", e);
        }
        Image image = Image.getInstance(filePath);
        PdfContentByte under;
        com.itextpdf.text.Rectangle pageRect;
        PdfGState gs = new PdfGState();
        // FIXME 必须设置绝对值，考虑以后作为入参
        image.setAbsolutePosition(120, 200);

        PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream(waterConfig.getPdfWaterPicPath()));
        for (int i = 1; i < total; i++) {
            pageRect = stamper.getReader().getPageSizeWithRotation(i);
            // 计算水印X,Y坐标
            float x = pageRect.getWidth() / 10;
            float y = pageRect.getHeight() / 10;
            under = stamper.getOverContent(i);
            under.saveState();
            under.setGState(gs);
            under.addImage(image);
            under.restoreState();
        }
        if(stamper != null ){
            stamper.close();
        }
        if(pdfReader != null){
            pdfReader.close();
        }
    }

    /**
     * 系统第一个字体生成PDF
     * @param width
     * @param height
     * @param fontHeight
     * @param content
     * @param waterConfig
     * @throws Exception
     */
    public static void generatePdfMakerWithDefaultFont(int width, int height, int fontHeight, String content, WaterConfig waterConfig) throws Exception {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        Font font = null;
        if(fonts != null && fonts.length != 0){
            font = new Font(fonts[0], Font.PLAIN, fontHeight);
        }
        generatePdfMaker(width,height,fontHeight,content,font,waterConfig);
    }

    /**
     * 通过字体名称生成PDF
     * @param width
     * @param height
     * @param fontHeight
     * @param content
     * @param fontName
     * @param waterConfig
     * @throws Exception
     */
    public static void generatePdfMakerByFontName(int width, int height, int fontHeight, String content,String fontName, WaterConfig waterConfig) throws Exception {
        if(StringUtils.isBlank(fontName)){
            throw new NullPointerException("fontName can not be empty or null");
        }
        generatePdfMaker(width,height,fontHeight,content,new Font(fontName, Font.PLAIN, fontHeight),waterConfig);
    }
}
