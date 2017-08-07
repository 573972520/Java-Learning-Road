import static org.junit.Assert.*;

import org.junit.Test;

import com.zsz.front.Utils.FrontUtils;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void test() {
		Jedis jedis = FrontUtils.createJedis();
		/*
		jedis.incr("test1"); //test1++
		jedis.incr("test1");
		jedis.incr("test1");
		jedis.close();
		*/
		String v = jedis.get("test1");
		System.out.println(v);
		jedis.close();
	}

}
