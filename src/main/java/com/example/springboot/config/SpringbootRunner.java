package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebForwardConstant.FWD_LOGIN;

@Component
@Slf4j
public class SpringbootRunner implements ApplicationRunner {

    @Value(SERVER_PORT)
    private String port;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String url = String.format(PROJECT_URL, InetAddress.getLocalHost().getHostAddress(), port);

        url += SLASH + FWD_LOGIN;

        CHROME_PATH += url;

        log.info(PROJECT_NOTIFICATION_INFO + url);

        Runtime.getRuntime().exec(CHROME_PATH);

    }
}
