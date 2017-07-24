package xin.ncuflag.exception;

import xin.ncuflag.Enum.SeckillEnum;

/**
 * Created by vince on 2017/7/22.
 */
public class SeckillException extends RuntimeException {
    private SeckillEnum seckillEnum;

    public SeckillException(SeckillEnum seckillEnum) {
        super(seckillEnum.getStateInfo());
        this.seckillEnum=seckillEnum;

    }

    public SeckillEnum getSeckillEnum() {
        return seckillEnum;
    }

    public void setSeckillEnum(SeckillEnum seckillEnum) {
        this.seckillEnum = seckillEnum;
    }
    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}





