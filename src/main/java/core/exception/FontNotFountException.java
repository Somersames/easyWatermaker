package core.exception;

/**
 * @Description TODO
 * @Date 2019-11-25 10:20
 * @Author https://github.com/Somersames
 **/

public class FontNotFountException extends RuntimeException {
    private String message;

    public FontNotFountException(String message){
        super(message);
    }
}
