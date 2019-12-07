package core.pdf;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @Description TODO
 * @Date 2019-12-02 10:26
 * @Author https://github.com/Somersames
 **/

public class PdfUtil {

    /**
     * 从本地读取PDF
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static InputStream getPdfByLocal(String filePath) throws FileNotFoundException {
        if(StringUtils.isBlank(filePath)){
            throw new IllegalArgumentException("filePath cannot be null or empty");
        }
        return new FileInputStream(new File(filePath));
    }

    /**
     * 从网络中下载PDF
     * @return
     */
    public static InputStream getPdfByHttp(){
        // TODO
        return null;
    }

}
