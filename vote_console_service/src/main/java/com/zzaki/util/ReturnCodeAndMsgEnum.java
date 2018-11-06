package com.zzaki.util;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
public enum ReturnCodeAndMsgEnum {

    /** 请求成功  */
    SUCCESS(0, "ok"),
    //ret < -10000 && ret < 10000， 自定义返回值
    /** 没有数据  */
    NO_DATA(-1, "no data"),
    /** 没有数据插入或更新  */
    NO_RECORD_CHANGE(-2, "no record changes in database"),
    /** 缺少必须的参数  */
    CALLER_PARAM_LACK(-10000, "lack of parameters"),
    /** 非法的参数，参数不对，或者格式错误等  */
    CALLER_PARAM_ILLEGAL(-10001, "illegal parameters"),
    /** 未知异常 */
    UNKNOWN_EXCEPTION(10000, "unknown exception"),
    /** 系统错误 */
    SYSTEM_ERROR(10001, "system error");

    private String msg;
    private int    code;

    ReturnCodeAndMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ReturnCodeAndMsgEnum getByCode(int code) {
        for (ReturnCodeAndMsgEnum aiTypeEnum : ReturnCodeAndMsgEnum.values()) {
            if (aiTypeEnum.code == code) {
                return aiTypeEnum;
            }
        }
        return SUCCESS;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
