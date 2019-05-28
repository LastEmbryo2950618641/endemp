package cn.personal.endemp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"cn.personal.endemp.filter"})
@MapperScan(basePackages = {"cn.personal.endemp.mapper"})
public class EndempApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndempApplication.class, args);
    }

}
