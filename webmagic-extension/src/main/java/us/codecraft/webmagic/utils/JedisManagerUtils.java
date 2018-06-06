package us.codecraft.webmagic.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.cache.CacheAction;

import java.util.function.Consumer;
import java.util.function.Function;

public class JedisManagerUtils implements CacheAction<Jedis> {


    protected JedisPool pool;

    public JedisManagerUtils(JedisPool pool) {

        this.pool = pool;
    }

    @Override
    public <T> T executeFunction(Function<Jedis, T> function) {
        try (Jedis jedis = pool.getResource()) {
            return function.apply(jedis);
        }
    }


    @Override
    public void executeConsumer(Consumer<Jedis> consumer) {
        try (Jedis jedis = pool.getResource()) {
            consumer.accept(jedis);
        }
    }


}
