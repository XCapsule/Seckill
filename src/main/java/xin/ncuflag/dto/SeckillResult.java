package xin.ncuflag.dto;

import xin.ncuflag.Enum.SeckillEnum;

public class SeckillResult<T> {
    private boolean Success;
    private T data;
    private String error;
    private SeckillEnum seckillEnum;

//成功
    public SeckillResult(boolean success, T data) {
        Success = success;
        this.data = data;
    }


//失败
    public SeckillResult(boolean success, SeckillEnum seckillEnum) {
        Success = success;
        this.error = seckillEnum.getStateInfo();
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public SeckillEnum getSeckillEnum() {
        return seckillEnum;
    }

    public void setSeckillEnum(SeckillEnum seckillEnum) {
        this.seckillEnum = seckillEnum;
    }
}
