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
