package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
@EnableTransactionManagement
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  龙航智能启动成功   ლ(´ڡ`ლ)ﾞ  \n"+".__                        .__                           \n" +
                "|  |   ____   ____    ____ |  |__ _____    ____    ____  \n" +
                "|  |  /  _ \\ /    \\  / ___\\|  |  \\\\__  \\  /    \\  / ___\\ \n" +
                "|  |_(  <_> )   |  \\/ /_/  >   Y  \\/ __ \\|   |  \\/ /_/  >\n" +
                "|____/\\____/|___|  /\\___  /|___|  (____  /___|  /\\___  / \n" +
                "                 \\//_____/      \\/     \\/     \\//_____/  ");
    }
}
