package cn.personal.endemp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.personal.endemp.mapper"})
public class EndempApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndempApplication.class, args);
    }

}
