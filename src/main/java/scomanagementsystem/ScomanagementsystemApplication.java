package scomanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class ScomanagementsystemApplication {

    public static void main(String[] args) {
        System.out.println( "Hello World!\nThis is an SCO Management Application" );
        SpringApplication.run(ScomanagementsystemApplication.class, args);
    }
}