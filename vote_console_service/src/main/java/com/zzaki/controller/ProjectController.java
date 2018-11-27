package com.zzaki.controller;

import com.alibaba.fastjson.JSON;
import com.zzaki.model.entity.ProjectPO;
import com.zzaki.model.request.ProjectReq;
import com.zzaki.service.ProjectService;
import com.zzaki.util.ReturnCodeAndMsgEnum;
import com.zzaki.util.ReturnValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/11/6
 * @Company: DeepWise
 */
@RestController
@Slf4j
@RequestMapping("/vote/project")
public class ProjectController {

    private final static String QR_IMAGE = "qr";
    private final static String PNG_IMAGE= "png";

    @Autowired
    private ProjectService projectService;

    /**
     * @api {post} /vote/project/addProject 增加投票项目
     * @apiName addProject
     * @apiGroup vote_project
     * @apiParam {int} projectName  项目名
     * @apiParam {int} voteCount  投票数
     * @apiParam {int} heatValue  热度
     * @apiParamExample {json} Request-Example:
     *  {
     *	    "projectName":"bbb",
     *	    "voteCount":123,
     *      "heatValue":1234
     *  }
     * @apiDescription 不需要更新的为缺省，不填即可
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *  {
     *      "ret": 0,
     *      "msg": "ok",
     *      "data": null
     *  }
     */
    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public ReturnValue<String> addProject(@RequestBody ProjectReq projectReq){
        try{
            int result = projectService.addProject(projectReq);
            if (result >0){
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS,null);
            }else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.CALLER_PARAM_ILLEGAL,null);
            }
        }catch (Exception e){
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION,e.getMessage());
        }
    }

    /**
     * @api {post} /vote/project/deleteProject 删除投票项目
     * @apiName deleteProject
     * @apiGroup vote_project
     * @apiParam {int} projectId  项目id，必填！
     * @apiParamExample {json} Request-Example:
     *  {
     *      "projectId": 1
     *  }
     * @apiDescription 理论上只需要填projectId，其他勿填
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *  {
     *      "ret": 0,
     *      "msg": "ok",
     *      "data": null
     *  }
     */
    @RequestMapping(value = "/deleteProject",method = RequestMethod.POST)
    public ReturnValue<String> deleteProject(@RequestBody ProjectReq projectReq){
        int projectId = projectReq.getProjectId();
        if (projectId == 0 ) {
            return new ReturnValue<>(ReturnCodeAndMsgEnum.CALLER_PARAM_LACK,null);
        }
        try{
            int result = projectService.deleteProject(projectId);
            if (result >0){
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS,null);
            }else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.NO_RECORD_CHANGE,null);
            }
        }catch (Exception e){
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION,e.getMessage());
        }
    }

    /**
     * @api {post} /vote/project/updateProject 更新投票项目
     * @apiName updateProject
     * @apiGroup vote_project
     * @apiParam {int} projectId  项目id，必填！
     * @apiParam {int} [projectName]  项目名
     * @apiParam {int} [voteCount]  投票数
     * @apiParam {int} [heatValue]  热度
     * @apiParamExample {json} Request-Example:
     *  {
     *      "projectId": 1,
     *	    "projectName":"bbb",
     *	    "voteCount":123,
     *      "heatValue":1234
     *  }
     * @apiDescription 不需要更新的为缺省，不填即可
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     *  {
     *      "ret": 0,
     *      "msg": "ok",
     *      "data": null
     *  }
     */
    @RequestMapping(value = "/updateProject",method = RequestMethod.POST)
    public ReturnValue<String> updateProject(@RequestBody ProjectReq projectReq){
        try{
            int result = projectService.updateProject(projectReq);
            if (result >0){
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS,null);
            } else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.NO_RECORD_CHANGE,null);
            }
        }catch (Exception e){
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION,e.getMessage());
        }
    }


    /**
     * @api {post} /vote/project/listProject 获取投票项目列表
     * @apiName listProject
     * @apiGroup vote_project
     * @apiDescription 直接post请求，不用传参数
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "ret": 0,
     *     "msg": "ok",
     *     "data": "[{\"heatValue\":1234,\"projectId\":1,\"projectName\":\"aaa\",\"voteCount\":123},{\"heatValue\":1234444,\"projectId\":2,\"projectName\":\"ccc\",\"voteCount\":123},{\"heatValue\":1234,\"projectId\":3,\"projectName\":\"bbb\",\"voteCount\":123},{\"heatValue\":1234,\"projectId\":4,\"projectName\":\"bbb\",\"voteCount\":123}]"
     * }
     */
    @RequestMapping(value="/listProject",method = RequestMethod.POST)
    public ReturnValue<String> listProject() {
        try{
            List<ProjectPO> result = projectService.listProject();
            if(!result.isEmpty()){
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS, JSON.toJSONString(result));
            } else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.NO_RECORD_CHANGE,null);
            }
        } catch (Exception e) {
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateImage",method = RequestMethod.POST)
    public ReturnValue updateImage(@RequestParam("projectId")Integer projectId, @RequestParam("imageType")String imageType,
                                              @RequestParam("imageFile")MultipartFile imageFile, HttpServletRequest request) {
        ProjectPO projectPO = projectService.getProjectById(projectId);
        if (projectPO == null)
            return new ReturnValue<>(ReturnCodeAndMsgEnum.CALLER_PARAM_ILLEGAL, null);
        String filePath = null;
        if (QR_IMAGE.equals(imageType)) {
            filePath = projectPO.getQrUrl();
        } else {
            filePath = projectPO.getPngUrl();
        }
        if (filePath == null) {
            return new ReturnValue<>(ReturnCodeAndMsgEnum.CALLER_PARAM_ILLEGAL, null);
        }
        try {
            if (!imageFile.isEmpty()) {
                String fileName = getFileNameByPath(filePath);
                filePath = "/opt/apache-tomcat-8/webapps"+filePath;
                File file = new File(filePath, fileName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                imageFile.transferTo(new File(filePath));
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS);
            }else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.CALLER_PARAM_ILLEGAL, null);
            }
        }catch (Exception e){
            return new ReturnValue<>(ReturnCodeAndMsgEnum.SYSTEM_ERROR,e);
        }
    }

    private String getFileNameByPath(String filePath){
        String fileName = null;
        if (!StringUtils.isEmpty(filePath)){
            String[] paths = filePath.split("/");
            fileName = paths[paths.length-1];
        }
        return fileName;
    }


}
