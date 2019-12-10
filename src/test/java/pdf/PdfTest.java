package pdf;

import config.WaterConfig;
import util.GenerateUtil;

import java.awt.*;

/**
 * @Description TODO
 * @Date 2019-12-07 13:44
 * @Author https://github.com/Somersames
 **/

public class PdfTest {

    public void generateTest() throws Exception {
        WaterConfig waterConfig = new WaterConfig.Builder()
                .setPicPath("/Desktop/person/water/")
                .setPdfPath("/Desktop/person/water/Origin.pdf")
                .setPdfWaterPicPath("/Desktop/person/water/test.pdf")
                .setFontColor(Color.YELLOW)
                .create();
        GenerateUtil.generatePdfMakerByFontName(1000,150,70,"测试内容","宋体",waterConfig);
    }

    public static void main(String[] args) throws Exception {
        new PdfTest().generateTest();
    }
}
