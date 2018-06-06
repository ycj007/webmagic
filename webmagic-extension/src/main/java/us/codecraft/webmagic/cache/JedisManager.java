package us.codecraft.webmagic.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.function.Consumer;
import java.util.function.Function;

public class JedisManager implements Cache<Jedis> {


    protected JedisPool pool;

    public JedisManager(JedisPool pool) {

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
