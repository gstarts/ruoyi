package com.ruoyi.stations_management.measurement.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class Sequence {

    private static Logger logger = LoggerFactory.getLogger(Sequence.class);

    @Resource
    private RedisTemplate redisTemplate;

    //用作存放redis中的key
    private static String ORDER_KEY = "order_key";

    //生成特定的业务编号，prefix为特定的业务代码
    public String getOrderNo(String prefix){
        return getSeqNo(ORDER_KEY, prefix);
    }

    //SequenceService类中公用部分，传入制定的key和prefix
    private String getSeqNo(String key, String prefix)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        //设置过期时间，这里设置为当天的23:59:59
        Date expireDate = calendar.getTime();
        //返回当前redis中的key的最大值
        Long seq = generate(redisTemplate, key, expireDate);
        //获取当天的日期，格式为yyyyMMdd
        String date = new SimpleDateFormat("yyyyMMdd").format(expireDate);
        //生成八为的序列号，如果seq不够四位，seq前面补0，
        //如果seq位数超过了四位，那么无需补0直接返回当前的seq
        String sequence = StringUtils.leftPad(seq.toString(), 4, "0");
        if (prefix == null)
        {
            prefix = "";
        }
        //拼接业务编号
        String seqNo = prefix + date + sequence;
        logger.info("KEY:{}, 序列号生成:{}, 过期时间:{}", key, seqNo, String.format("%tF %tT ", expireDate, expireDate));
        return seqNo;
    }

    /**
     * @param key
     * @param expireTime <i>过期时间</i>
     * @return
     */
    public static long generate(RedisTemplate<?,?> redisTemplate,String key,Date expireTime) {
        //RedisAtomicLong为原子类，根据传入的key和redis链接工厂创建原子类
        RedisAtomicLong counter = new RedisAtomicLong(key,redisTemplate.getConnectionFactory());
        //设置过期时间
        counter.expireAt(expireTime);
        //返回redis中key的值，内部实现下面详细说明
        return counter.incrementAndGet();
    }

}