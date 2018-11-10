package com.zzaki.service;

import com.zzaki.model.request.ProjectReq;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/10/26
 * @Company: DeepWise
 */
public interface ProjectService {

    int addProject(ProjectReq projectReq);

    int deleteProjetc(Integer projectId);

    int updateProject(ProjectReq projectReq);
}
