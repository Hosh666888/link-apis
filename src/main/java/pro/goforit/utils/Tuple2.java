package pro.goforit.utils;

/**
 * @author: Double>J
 * @email: zjj20001031@foxmail.com
 * @editTime: 2022/8/25 11:13
 * @desc:
 **/
public class Tuple2<L,R> {
    public L left;
    public R right;

    private Tuple2(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static <L,R> Tuple2 of(L l,R r){
        return new Tuple2(l,r);
    }

}
