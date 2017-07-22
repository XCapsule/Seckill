package xin.ncuflag.service;

import xin.ncuflag.dto.Exposer;
import xin.ncuflag.dto.SeckillExecution;
import xin.ncuflag.entity.SecKill;

import java.util.List;

/**
 * Created by vince on 2017/7/22.
 * 实现逻辑功能
 */
public interface SeckillService {

//    让前端获取秒杀商品列表
    public List<SecKill> getList();

//    获取秒杀结果
    public SecKill getById(Long id);

//    暴露接口
    public Exposer getExposerById(Long id);

//  执行秒杀
    public SeckillExecution executeSeckill(Long id,Long userPhone,String md5);
}
