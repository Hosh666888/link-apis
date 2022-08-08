package pro.goforit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "pro.goforit.mapper")
public class LinkApisApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkApisApplication.class, args);
    }

}
