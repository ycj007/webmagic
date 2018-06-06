package us.codecraft.webmagic.cache;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 缓存操作接口
 * @param <T>
 */
public interface Cache<T> {

    /**
     * 执行消费动作
     * @param consumer
     */
    public void executeConsumer(Consumer<T> consumer);

    /**
     * 执行函数动作
     * @param function
     * @param <R>
     * @return
     */

    public <R> R executeFunction(Function<T, R> function);
}
