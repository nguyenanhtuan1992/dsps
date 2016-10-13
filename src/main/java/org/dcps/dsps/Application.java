package org.dcps.dsps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

/**
 * Created by vhphat on 5/23/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.dcps.dsps"})
public class Application {

    public static void main(String[] args) throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Application.class, args);
    }

}
