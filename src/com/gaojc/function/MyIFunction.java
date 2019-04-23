package com.gaojc.function;

import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * 自定义 Function 接口实现类
 *
 * @author gaojc
 * @date 2019/4/23 23:20
 */
public class MyIFunction implements Function<String, String> {
    private Logger logger = Logger.getLogger(MyIFunction.class.getName());

    @Override
    public String apply(String str) {
        logger.info("apply() str = " + str);
        return String.format("MyIFunction apply %s", str);
    }

    @Override
    public <V> Function<V, String> compose(Function<? super V, ? extends String> before) {
        Objects.requireNonNull(before);
        logger.info("andThen() before = " + before);
        return (V v) -> apply(before.apply(v));
    }

    @Override
    public <V> Function<String, V> andThen(Function<? super String, ? extends V> after) {
        Objects.requireNonNull(after);
        logger.info("andThen() after = " + after);
        return (String t) -> after.apply(apply(t) + " aft ");
    }


    public static void main(String[] args) {
        String word = "say hello";
        MyIFunction myIFunction = new MyIFunction();
        String applyString = myIFunction.apply(word);

        //返回apply
        System.out.println(applyString);

        MyIFunction myIFunction2 = null;
//        String andThen = myIFunction.andThen(myIFunction2).apply("gaojc");
//        //NullPointerException
//        System.out.println(andThen);

        myIFunction2 = new MyIFunction();
        myIFunction2.apply("myIFunction2");
        String andThen2 = myIFunction.andThen(myIFunction2).apply("gaojc");
        System.out.println(andThen2);
    }
}
