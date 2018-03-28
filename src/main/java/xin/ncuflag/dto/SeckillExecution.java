package xin.ncuflag.dto;

import xin.ncuflag.Enum.SeckillEnum;
import xin.ncuflag.entity.SecKill;
import xin.ncuflag.entity.SuccessKilled;

/**
 * Created by vince on 2017/7/22.
 * Dto层封装好要传递给前端的数据
 */
//执行秒杀操作
public class SeckillExecution {
    private long seckillId;
    private SuccessKilled successKilled;
    private int status;
    private String statusInfo;


    public SeckillExecution(long seckillId, SuccessKilled successKilled, SeckillEnum seckillEnum) {
        this.seckillId = seckillId;
        this.successKilled = successKilled;
        this.status = seckillEnum.getCode();
        this.statusInfo = seckillEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId,SeckillEnum seckillEnum) {
        this.seckillId = seckillId;
        this.status = seckillEnum.getCode();
        this.statusInfo = seckillEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
