package com.zzaki.service;

import com.zzaki.model.response.ProjectRes;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/10/26
 * @Company: DeepWise
 */
public interface ProjectService {

    int addProject(ProjectRes projectRes);

    int deleteProjetc(Integer projectId);

    int updateProject(ProjectRes projectRes);
}
