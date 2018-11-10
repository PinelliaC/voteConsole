package com.zzaki.controller;

import com.zzaki.model.request.PageReq;
import com.zzaki.service.MainpageService;
import com.zzaki.util.ReturnCodeAndMsgEnum;
import com.zzaki.util.ReturnValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pinelliaw
 * @date 2018/11/10
 */
@RestController
@Slf4j
@RequestMapping("/vote/page")
public class MainpageController {
    @Autowired
    private MainpageService mainpageService;

    /**
     * @api {post} /vote/page/updatePage 更新首页信息
     * @apiName updatePage
     * @apiGroup vote_mainpage
     * @apiParam {int} [project_amount]  首页显示项目数
     * @apiParam {int} [vote_amount]  首页显示投票数
     * @apiParam {int} [view_amount]  首页显示浏览数
     * @apiParamExample {json} Request-Example:
     *  {
     *      "project_amount": 222333,
     *      "vote_amount": 1222,
     *      "view_amount": 1111
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
    @RequestMapping(value = "/updatePage", method = RequestMethod.POST)
    public ReturnValue<String> updatePage(@RequestBody PageReq pageReq) {
        try {
            int result = mainpageService.updateMainpage(pageReq);
            if (result > 0) {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.SUCCESS, null);
            } else {
                return new ReturnValue<>(ReturnCodeAndMsgEnum.NO_RECORD_CHANGE, null);
            }
        } catch (Exception e) {
            return new ReturnValue<>(ReturnCodeAndMsgEnum.DATABASE_EXCEPTION, e.getMessage());
        }
    }
}
