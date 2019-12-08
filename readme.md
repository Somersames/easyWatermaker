封装了一些常用的加水印代码
## 使用方法
分别配置好水印生成的pic地址，PDF源文件地址，生成后的PDF地址即可
```java
public void generateTest() throws Exception {
        WaterConfig waterConfig = new WaterConfig.Builder()
                .setPicPath("/Desktop/person/water/")
                .setPdfPath("/Desktop/person/water/Origin.pdf")
                .setPdfWaterPicPath("/Desktop/person/water/test.pdf")
                .create();
        GenerateUtil.generatePdfMakerByFontName(1000,150,70,"宋体","宋体",waterConfig);
    }
```


版本更新：

##### v0.0.1:
支持字体的选择。
支持自定义水印。