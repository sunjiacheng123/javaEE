public class SystemEexception extends BaseException{
    public SystemEexception(String code, String message) {
        this(code, message,null);
    }

    public SystemEexception(String code, String message, Throwable cause) {
        super("SYS"+code,"系统异常" +message, cause);
    }
}
