package co.yiiu.pybbs.util;

import java.util.Random;

/**
 * @Description: TODO
 * @Author hemingming
 * @Date 2019/12/11
 **/
public class RandomUtils {

    public static Long getRandomVisitors(){
        return 12345L + new Random().nextInt(200000);
    }
}
