package xin.ncuflag.entity;

import java.util.Date;

/**
 * Created by vince on 2017/7/20.
 */
public class SuccessKilled {
    private long seckillId;
    private long userPhone;
    private int state;
    private Date createTime;
    private  SecKill secKill;
    public SuccessKilled() {
    }

    public SuccessKilled(long seckillId, long userPhone, int state, Date createTime, SecKill secKill) {
        this.seckillId = seckillId;
        this.userPhone = userPhone;
        this.state = state;
        this.createTime = createTime;
        this.secKill = secKill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public SecKill getSecKill() {
        return secKill;
    }

    public void setSecKill(SecKill secKill) {
        this.secKill = secKill;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
