package com.zzaki.controller;

import com.zzaki.model.request.ProjectReq;
import com.zzaki.service.ProjectService;
import com.zzaki.util.ReturnCodeAndMsgEnum;
import com.zzaki.util.ReturnValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/deleteProject",method = RequestMethod.POST)
    public ReturnValue<String> deleteProject(@RequestParam("projectId")Integer projectId){
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
            }else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.NO_RECORD_CHANGE,null);
            }
        }catch (Exception e){
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION,e.getMessage());
        }
    }



}
