package xin.ncuflag.Enum;

/**
 * Created by vince on 2017/7/22.
 */
public enum SeckillEnum {
    SUCCESS(1,"秒杀成功"),
    INNER_ERROR(0,"系统错误"),
    CHANGE_DATE(-1,"数据复写"),
    SECKILL_CLOSE(-2,"秒杀关闭"),
    REPEAT_WRITTEN(-3,"重复秒杀");


    private int code;
    private String stateInfo;
    SeckillEnum(int code,String stateInfo) {
        this.code=code;
        this.stateInfo=stateInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static SeckillEnum stateOf(int index){
        for(SeckillEnum seckillEnum:values()){
            if(seckillEnum.getCode()==index){
                return seckillEnum;
            }
        }
        return null;
    }
}
