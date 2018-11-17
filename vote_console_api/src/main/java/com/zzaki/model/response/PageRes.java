package com.zzaki.model.response;

import java.io.Serializable;

/**
 * @author Pinelliaw
 * @date 2018/11/10
 */
public class PageRes implements Serializable {

    private static final long serialVersionUID = 7900406048998371041L;
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

    /**
     * 头图地址
     */
    private String png_url;
}
