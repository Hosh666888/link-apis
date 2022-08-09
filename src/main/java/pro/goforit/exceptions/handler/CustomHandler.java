package pro.goforit.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.goforit.domain.returns.R;
import pro.goforit.exceptions.AuthFailException;

import java.util.List;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/9 9:55
 * @desc:
 **/
@RestControllerAdvice
@Slf4j
public class CustomHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public R<String> handler4RuntimeException(RuntimeException e){
        log.error("运行时异常:{}",e.getMessage(),e);
        return R.fail(e.getMessage());
    }



    @ExceptionHandler(value = Exception.class)
    public R<String> handler4Exception(Exception e){
        log.error("未知异常:{}",e.getMessage(),e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(value = AuthFailException.class)
    public R<String> handler4AuthFailException(AuthFailException e){
        log.error("token异常:{}",e.getMessage(),e);
        return R.authFail(e.getMessage());
    }


    @ExceptionHandler(value = BindException.class)
    public R<String> handler4BindException(BindException e){
        log.error("参数绑定异常:{}",e.getMessage(),e);
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError field : fieldErrors) {
            sb.append(field.getField())
                    .append(":")
                    .append(field.getDefaultMessage())
                    .append(",");
        }
        log.error("参数绑定异常:{} 在绑定时出现异常",sb);
        return R.fail(sb.toString());
    }


}
