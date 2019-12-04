package config;

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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getFontPath() {
        return fontPath;
    }

    public void setFontPath(String fontPath) {
        this.fontPath = fontPath;
    }

    public WaterConfig(Builder builder) {
        this.picPath = builder.picPath;
    }

    public WaterConfig() {
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
    }
}
