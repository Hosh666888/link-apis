package pro.goforit.utils;

import java.util.UUID;

/**
 * @author Double.j
 * @create 2022/8/23 22:03
 * @e-mail zjj20001031@foxmail.com / gugezhang872@gmail.com
 */
public class IdUtil {


    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
