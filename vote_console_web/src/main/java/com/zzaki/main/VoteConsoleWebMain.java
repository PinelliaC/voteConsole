package com.zzaki.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/10/26
 * @Company: DeepWise
 */
@SpringBootApplication
@Slf4j
public class VoteConsoleWebMain {

    public static void main(String[] args) {
        SpringApplication.run(VoteConsoleWebMain.class, args);
        log.info( "================Vote Console Web Start  SUCCESS===========");
    }
}
