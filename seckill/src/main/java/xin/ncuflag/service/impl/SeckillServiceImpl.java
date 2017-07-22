package xin.ncuflag.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import xin.ncuflag.Enum.SeckillEnum;
import xin.ncuflag.dao.SecKillDao;
import xin.ncuflag.dao.SuccessKilledDao;
import xin.ncuflag.dto.Exposer;
import xin.ncuflag.dto.SeckillExecution;
import xin.ncuflag.entity.SecKill;
import xin.ncuflag.entity.SuccessKilled;
import xin.ncuflag.exception.SeckillException;
import xin.ncuflag.service.SeckillService;

import java.util.Date;
import java.util.List;

/**
 * Created by vince on 2017/7/22.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

//    配置日志功能
    private Logger logger=LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SecKillDao secKillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;

    private final String salt="ZXpoqwe,zx0q2'OP;0'UL.'86X=-ak=W9IXGT347ZWU856UWSAK";
    public List<SecKill> getList() {
        return secKillDao.queryAll(0,10);
    }

    public SecKill getById(Long id) {
        return secKillDao.queryById(id);
    }
//判断能否获取秒杀地址
    public Exposer getExposerById(Long id) {
        SecKill seckill=secKillDao.queryById(id);
        if(seckill==null){
            return new Exposer(false,id);
        }
        long now=new Date().getTime();
        long startTime=seckill.getStartTime().getTime();
        long endTime=seckill.getEndTime().getTime();
        if (now<startTime||now>endTime){
            return new Exposer(false,id,now,startTime,endTime);
        }
        String md5=getMD5(id);
        Exposer exposer=new Exposer(true,md5,id);
        return null;
    }
//执行秒杀
    @Transactional
    public SeckillExecution executeSeckill(Long id, Long userPhone, String md5) {
//               执行秒杀前要判断1.MD5是不是对的2..秒杀是否成功，不成功肯定是重复了3.秒杀关闭
        if(md5==null||!md5.equals(getMD5(id))){
            throw new SeckillException(SeckillEnum.CHANGE_DATE);
        }
        try {
            Date killTime = new Date();
            int reduceNumber = secKillDao.reduceNumber(id, killTime);
            if (reduceNumber <= 0) {
                throw new SeckillException(SeckillEnum.SECKILL_CLOSE);
            }else {
                int updateCount = successKilledDao.insertSuccessKilled(id, userPhone);
                if (updateCount <= 0) {
                    throw new SeckillException(SeckillEnum.REPEAT_WRITTEN);
                }else {
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(id, userPhone);
                    return new SeckillExecution(id, successKilled, SeckillEnum.SUCCESS);
                }
            }
        }catch (SeckillException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException(SeckillEnum.INNER_ERROR);
        }
    }

//生成md5
    private  String getMD5(Long seckillId){
        String base=seckillId+"/"+salt;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
