package xin.ncuflag.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xin.ncuflag.entity.SecKill;
import xin.ncuflag.entity.SuccessKilled;

import java.util.Date;

/**
 * Created by vince on 2017/7/20.
 */

public interface SuccessKilledDao {
    //    查询秒杀结果
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone, @Param("killTime")Date killTime);
    //
    SuccessKilled queryByIdWithSecKill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

}
