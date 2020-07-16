package Test;
import util.jedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JeidsTest {
    @Test
    public void test() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //操作
        jedis.set("username", "root");
        jedis.close();
    }

    //String类型操作
    @Test
    public void test1() {
        //获取连接
        Jedis jedis = new Jedis();//空参使用默认ip和端口
        //操作
        jedis.set("username", "root");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }

    @Test
    public void test2() {
        //获取连接
        Jedis jedis = new Jedis();//空参使用默认ip和端口
        //存储hash
        jedis.hset("user","name","cky");
        jedis.hset("user","age","21");
        jedis.hset("user","gender","male");

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keyset = user.keySet();
        for (String key:keyset){
            String value = user.get(key);
            System.out.println(key+":"+value);
        }
    }
    //list操作
    @Test
    public void test3() {
        //获取连接
        Jedis jedis = new Jedis();//空参使用默认ip和端口
        //操作
        //list存储
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","1","2","3");
        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);
        String element1 = jedis.lpop("mylist");
        String element2 = jedis.rpop("mylist");
        System.out.println(element1);
        System.out.println(element2);
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        jedis.close();
    }

    //set类型操作
    @Test
    public void test4() {
        //获取连接
        Jedis jedis = new Jedis();//空参使用默认ip和端口
        //操作
        jedis.sadd("mySet", "c++","java","python");
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);
    }
    //String类型操作
    @Test
    public void test5() {
        //获取连接
        Jedis jedis = new Jedis();//空参使用默认ip和端口
        //操作
        jedis.zadd("mySortSet",100,"徐凤年");
        jedis.zadd("mySortSet",99,"李淳罡");
        jedis.zadd("mySortSet",98,"王仙芝");

        Set<String> mySortSet = jedis.zrange("mySortSet", 0, -1);
        System.out.println(mySortSet);
    }
    //jedis连接池
    @Test
    public void test6() {
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建连接池对象
        JedisPool pool = new JedisPool(config, "localhost", 6379);
        //获取连接
        Jedis jedis = pool.getResource();

        jedis.set("name","tianqibuocuo");
        jedis.close();
    }

    @Test
    public void test7() {
        Jedis jedis = jedisPoolUtils.getJedis();
        jedis.set("1","2");
        jedis.close();
    }
}
