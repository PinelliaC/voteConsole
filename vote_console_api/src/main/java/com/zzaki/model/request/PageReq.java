package com.zzaki.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Pinelliaw
 * @date 2018/11/10
 */
@Data
public class PageReq implements Serializable {
    private static final long serialVersionUID = -2204612894479374222L;
    /**
     * 项目数量
     */
    private Integer project_amount;

    /**
     * 投票数量
     */
    private Integer vote_amount;

    /**
     * 浏览数量
     */
    private Integer view_amount;

}
