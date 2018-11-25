package com.zzaki.service;

import com.zzaki.model.entity.ProjectPO;
import com.zzaki.model.request.ProjectReq;

import java.util.List;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/10/26
 * @Company: DeepWise
 */
public interface ProjectService {

    int addProject(ProjectReq projectReq);

    int deleteProject(Integer projectId);

    int updateProject(ProjectReq projectReq);

    List<ProjectPO> listProject();
}
