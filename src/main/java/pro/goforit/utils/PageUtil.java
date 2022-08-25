package pro.goforit.utils;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 11:13
 * @desc:
 **/
public class PageUtil {

    public static Tuple2<Integer,Integer> getReasonablePageParam(Integer pageIndex,Integer pageSize){
        int left,right;

        if (pageIndex==null || pageIndex<1){
            left = 1;
        }else{
            left = pageIndex;
        }

        if (pageSize==null || pageSize<1){
            right = 20;
        }else{
            right = pageSize;
        }

        return Tuple2.of(left,right);

    }



}
