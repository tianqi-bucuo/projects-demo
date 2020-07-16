package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import service.ProvinceService;
import util.jedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //从redis中查找数据
        Jedis jedis = jedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if (province_json == null){
            System.out.println("redis中煤油数据，查询数据库...");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询redis");
        }
        return province_json;
    }
}
