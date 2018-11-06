package com.zzaki.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
@Data
public class ProjectReq implements Serializable {

    private static final long serialVersionUID = 1909064606967528379L;
    /**
     * 项目id
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目的投票数
     */
    private Integer voteCount;
    /**
     * 项目的热度
     */
    private Integer heatValue;
}
