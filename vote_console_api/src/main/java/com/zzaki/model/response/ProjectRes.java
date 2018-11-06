package com.zzaki.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
@Data
public class ProjectRes implements Serializable {

    private static final long serialVersionUID = -5258381040863757769L;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目头像图片的url路径
     */
    private String pngUrl;
    /**
     * 项目二维码图片的url路径
     */
    private String qrUrl;
    /**
     * 项目的投票数
     */
    private Integer voteCount;
    /**
     * 项目的热度
     */
    private Integer heatValue;
}
