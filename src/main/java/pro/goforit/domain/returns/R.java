package pro.goforit.domain.returns;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/9 9:55
 * @desc:
 **/
public class R<T> implements Serializable {
    private static final long serialVersionUID = 5526670602490228936L;

    private Integer code;

    private String message;

    private boolean success;

    private T data;


    private static final Integer FAIL_CODE = -1;
    private static final Integer SUCCESS_CODE = 0;
    private static final Integer AUTH_FAIL_CODE = -2;
    private static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";
    private static final String DEFAULT_FAIL_MESSAGE = "请求失败";
    private static final String DEFAULT_AUTH_FAIL_MESSAGE = "认证失败";

    public R(Integer code, String message, T data,boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public static <T> R<T> fail(String message){
        return new R<>(FAIL_CODE,message,null,false);
    }

    public static R<String> fail(){
        return new R<>(FAIL_CODE,DEFAULT_FAIL_MESSAGE,null,false);
    }

    public static R<String> success(){
        return new R<>(SUCCESS_CODE,DEFAULT_SUCCESS_MESSAGE,null,true);
    }

    public static <T> R<T> success(T data){
        return new R<>(SUCCESS_CODE,DEFAULT_SUCCESS_MESSAGE,data,true);
    }

    public static <T> R<T> success(String message,T data){
        return new R<>(SUCCESS_CODE,message,data,true);
    }

    public static R<String> success(String message){
        return new R<>(SUCCESS_CODE,message,null,true);
    }


    public static <T> R<T> authFail(){
        return new R<>(AUTH_FAIL_CODE,DEFAULT_AUTH_FAIL_MESSAGE,null,false);
    }

    public static <T> R<T> authFail(String message){
        return new R<>(AUTH_FAIL_CODE,message,null,false);
    }

}
