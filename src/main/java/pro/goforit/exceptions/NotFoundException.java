package pro.goforit.exceptions;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/9/15 11:32
 * @desc:
 **/
public class NotFoundException extends Exception{
    public NotFoundException() {

    }

    public NotFoundException(String id) {
        super(String.format("未找到id为[%s]的记录",id));
    }


}
