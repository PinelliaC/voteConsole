package com.zzaki.service.impl;

import com.zzaki.dao.mapper.MainPagePOMapper;
import com.zzaki.model.entity.MainPagePO;
import com.zzaki.model.request.PageReq;
import com.zzaki.service.MainpageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Pinelliaw
 * @date 2018/11/09
 */
@Service
@Slf4j
public class MainpageServiceImpl implements MainpageService {
    @Autowired
    MainPagePOMapper mainPagePOMapper;

    @Override
    public int updateMainpage(PageReq pageReq) {
        if (pageReq == null) {
            log.error("illegal Argument! pageReq is null");
            return 0;
        }
        Example example = new Example(MainPagePO.class);
        example.createCriteria().andEqualTo(true);
        return mainPagePOMapper.updateByExampleSelective(conver2PO(pageReq), example);
    }

    private MainPagePO conver2PO(PageReq pageReq) {
        MainPagePO mainPagePO = new MainPagePO();
        mainPagePO.setVoteAmount(pageReq.getVote_amount());
        mainPagePO.setProjectAmount(pageReq.getProject_amount());
        mainPagePO.setViewAmount(pageReq.getView_amount());
//        mainPagePO.setPngUrl();
        return mainPagePO;
    }
}
