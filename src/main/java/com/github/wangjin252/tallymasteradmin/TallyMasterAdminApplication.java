package com.github.wangjin252.tallymasteradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TallyMasterAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallyMasterAdminApplication.class, args);
    }
}
