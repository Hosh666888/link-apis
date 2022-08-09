package pro.goforit.exceptions;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/9 9:52
 * @desc:
 **/
public class AuthFailException extends RuntimeException{
    private static final String DEFAULT_MESSAGE = "TOKEN异常,请尝试重新登录";

    public AuthFailException(String message) {
        super(message);
    }

    public AuthFailException() {
        super(DEFAULT_MESSAGE);
    }
}
