package com.zzaki.main;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/10/26
 * @Company: DeepWise
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.zzaki"})
@MapperScan({"com.zzaki.dao.mapper"})
@Slf4j
public class VoteConsoleServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(VoteConsoleServiceMain.class, args);
        log.info( "================Vote Console Service Start  SUCCESS===========");
    }
}
