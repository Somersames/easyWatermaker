package config;

import java.awt.*;

/**
 * @Description TODO
 * @Date 2019-11-26 10:08
 * @Author https://github.com/Somersames
 **/

public class WaterConfig {
    /**
     * 用于存放生成的图片的路径
     */
    private String picPath;

    /**
     * 水印字体
     */
    private String fontPath;

    /**
     * 加完水印后的路径
     */
    private String pdfWaterPicPath;

    /**
     * PDF源文件路径
     */
    private String pdfPath;

    /**
     * 原始Pic的路径
     */
    private String originPicPath;

    /**
     * 水印字体颜色
     */
    private Color fontColor;


    public String getPicPath() {
        return picPath;
    }

    public String getFontPath() {
        return fontPath;
    }

    public String getPdfWaterPicPath() {
        return pdfWaterPicPath;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public String getOriginPicPath() {
        return originPicPath;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public WaterConfig(Builder builder) {
        this.picPath = builder.picPath;
        this.fontPath = builder.fontPath;
        this.pdfWaterPicPath = builder.pdfWaterPicPath;
        this.pdfPath = builder.pdfPath;
        this.originPicPath = builder.originPicPath;
        this.fontColor = builder.fontColor;
    }

    public static class Builder {
        /**
         * 用于存放生成的图片的路径
         */
        private String picPath;

        /**
         * 水印字体
         */
        private String fontPath;

        /**
         * 加完水印后的路径
         */
        private String pdfWaterPicPath;

        /**
         * PDF源文件路径
         */
        private String pdfPath;

        /**
         * 原始Pic的路径
         */
        private String originPicPath;

        /**
         * 水印字体颜色
         */
        private Color fontColor;


        public WaterConfig create() {
            return new WaterConfig(this);
        }

        public Builder setPicPath(String picPath){
            this.picPath = picPath;
            return this;
        }

        public Builder setFontPath(String fontPath) {
            this.fontPath = fontPath;
            return this;
        }

        public String getPicPath() {
            return picPath;
        }



        public String getFontPath() {
            return fontPath;
        }

        public String getPdfWaterPicPath() {
            return pdfWaterPicPath;
        }

        public Builder setPdfWaterPicPath(String pdfWaterPicPath) {
            this.pdfWaterPicPath = pdfWaterPicPath;
            return this;
        }

        public String getPdfPath() {
            return pdfPath;
        }

        public Builder setPdfPath(String pdfPath) {
            this.pdfPath = pdfPath;
            return this;
        }

        public String getOriginPicPath() {
            return originPicPath;
        }

        public Builder setOriginPicPath(String originPicPath) {
            this.originPicPath = originPicPath;
            return this;
        }

        public Color getFontColor() {
            return fontColor;
        }

        public Builder setFontColor(Color fontColor) {
            this.fontColor = fontColor;
            return this;
        }
    }
}
