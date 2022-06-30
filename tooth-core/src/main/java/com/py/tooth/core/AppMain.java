package com.py.tooth.core;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czt
 * @description TODO
 * @date 2022/6/27 11:03 PM
 */
@Slf4j
@SpringBootApplication
@RestController
@MapperScan("com.py.tooth.core.mapper.*")
public class AppMain {

    public static void main(String[] args) {

        log.info("Spring boot begin to start");
        try {
            SpringApplication.run(AppMain.class, args);

        }catch (Exception e){
            log.error("启动异常:", e);
        }
        log.info("Spring boot start success");

    }

    @RequestMapping("/ok")
    public String ok(){
        return "ok";
    }
}
