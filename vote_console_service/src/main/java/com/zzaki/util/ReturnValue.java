package com.zzaki.util;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zzaki
 * @Description: 返回值封装
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
@Data
public class ReturnValue<T> implements Serializable {

    private static final long serialVersionUID = -8795051104484836989L;

    /**
     * 返回码，0 表示成功
     */
    private int ret = 0;
    /**
     * 消息信息
     */
    private String msg = "";
    /**
     * 返回数据
     */
    private T data = null;


    public ReturnValue() {
    }

    public ReturnValue(int retCode, String msg, T data) {
        ret = retCode;
        this.data = data;
        this.msg = msg;
    }

    public ReturnValue(int retCode, String msg) {
        ret = retCode;
        this.msg = msg;
    }

    public ReturnValue(ReturnCodeAndMsgEnum codeAndMsg) {
        this(codeAndMsg.getCode(), codeAndMsg.getMsg(), null);
    }

    public ReturnValue(ReturnCodeAndMsgEnum codeAndMsg, T data) {
        this(codeAndMsg.getCode(), codeAndMsg.getMsg(), data);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ReturnValue getInstanceFromJson(String jsonStr) {
        if (jsonStr != null && jsonStr != "") {
            try {
                JSONObject json = JSONObject.parseObject(jsonStr);
                if(json.get("ret")!= null) {
                    return new ReturnValue(json.getIntValue("ret"), json.getString("msg"), json.get("data"));
                }else {
                    return null;
                }
            }
            catch(Exception e) {
            }
        }
        return null;
    }
}
