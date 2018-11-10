package com.zzaki.service.impl;

import com.zzaki.dao.mapper.ProjectPOMapper;
import com.zzaki.model.entity.ProjectPO;
import com.zzaki.model.request.ProjectReq;
import com.zzaki.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public int addProject(ProjectReq projectReq) {
        if (projectReq == null || projectReq.getProjectName() == null || projectReq.getProjectName() == ""){
            log.error("illegal Argument! project name can not be null!");
            return 0;
        }
        ProjectPO projectPO = conver2PO(projectReq);
        return projectPOMapper.insert(projectPO);
    }

    @Override
    public int deleteProject(Integer projectId) {
        if (projectPOMapper.selectByPrimaryKey(projectId) != null){
            return projectPOMapper.deleteByPrimaryKey(projectId);
        }
        log.warn("project is not exist ,projectId :{}",projectId);
        return 0;
    }

    @Override
    public int updateProject(ProjectReq projectReq) {
        if (projectReq == null || projectReq.getProjectId() == null){
            log.error("illegal Argument! projectId is null");
            return 0;
        }
        Example example = new Example(ProjectPO.class);
        example.createCriteria().andEqualTo("projectId", projectReq.getProjectId());
        return projectPOMapper.updateByExampleSelective(conver2PO(projectReq), example);
    }

    private ProjectPO conver2PO(ProjectReq projectReq){
        ProjectPO projectPO = new ProjectPO();
        projectPO.setProjectName(projectReq.getProjectName());
        projectPO.setProjectId(projectReq.getProjectId());
        /*projectPO.setPngUrl(projectReq.getPngUrl());
        projectPO.setQrUrl(projectReq.getQrUrl());*/
        projectPO.setVoteCount(projectReq.getVoteCount());
        projectPO.setHeatValue(projectReq.getHeatValue());
        return  projectPO;
    }
}
