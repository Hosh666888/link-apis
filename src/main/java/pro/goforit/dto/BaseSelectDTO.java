package pro.goforit.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/9/15 15:25
 * @desc:
 **/
@Data
public class BaseSelectDTO implements Serializable {
    private static final long serialVersionUID = -2076021629194690553L;

    private Integer pageIndex;

    private Integer pageSize;

}
