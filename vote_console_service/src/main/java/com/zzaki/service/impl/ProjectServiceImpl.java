package com.zzaki.service.impl;

import com.zzaki.dao.mapper.ProjectPOMapper;
import com.zzaki.model.entity.ProjectPO;
import com.zzaki.model.response.ProjectRes;
import com.zzaki.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    ProjectPOMapper projectPOMapper;

    @Override
    public int addProject(ProjectRes projectRes) {
        if (projectRes == null || projectRes.getProjectName() == null || projectRes.getProjectName() == ""){
            log.error("illegal Argument! project name can not be null!");
            return 0;
        }
        ProjectPO projectPO = conver2PO(projectRes);
        return projectPOMapper.insert(projectPO);
    }

    @Override
    public int deleteProjetc(Integer projectId) {
        if (projectPOMapper.selectByPrimaryKey(projectId) != null){
            return projectPOMapper.deleteByPrimaryKey(projectId);
        }
        log.warn("project is not exist ,projectId :{}",projectId);
        return 0;
    }

    @Override
    public int updateProject(ProjectRes projectRes) {
        if (projectRes == null || projectRes.getProjectId() == null){
            log.error("illegal Argument! projectId is null");
            return 0;
        }
       // Example example = new Example(ProjectPO.class);
        //example.createCriteria().andEqualTo("projectId",projectRes.getProjectId());
        return projectPOMapper.updateByPrimaryKeySelective(conver2PO(projectRes));
    }

    private ProjectPO conver2PO(ProjectRes projectRes){
        ProjectPO projectPO = new ProjectPO();
        projectPO.setProjectName(projectRes.getProjectName());
        projectPO.setPngUrl(projectRes.getPngUrl());
        projectPO.setQrUrl(projectRes.getQrUrl());
        projectPO.setVoteCount(projectRes.getVoteCount());
        projectPO.setHeatValue(projectRes.getHeatValue());
        return  projectPO;
    }
}
