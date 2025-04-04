package com.aegis.companion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableAsync
@SpringBootApplication
@MapperScan("com.aegis.companion.dao")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AegisCompanionApplication {

    public static void main(String[] args) {
        // 允许Bean覆盖，解决WebSocket相关配置冲突
        SpringApplication application = new SpringApplication(AegisCompanionApplication.class);
        application.setAllowBeanDefinitionOverriding(true);

        application.run(args);
    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .failOnUnknownProperties(true);
    }
}
