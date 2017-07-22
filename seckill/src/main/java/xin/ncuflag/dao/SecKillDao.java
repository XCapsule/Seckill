package xin.ncuflag.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.ncuflag.entity.SecKill;

import java.util.Date;
import java.util.List;

/**
 * Created by vince on 2017/7/20.
 */

public interface SecKillDao {
//    功能增删改查
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    SecKill queryById(long seckillId);

//    根据偏移量查询秒杀商品列表
    List<SecKill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
