package com.example.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VijayApplication {

    public static void main(String[] args) {
        var ctx=SpringApplication.run(VijayApplication.class, args);
        Driver driver =ctx.getBean(Driver.class);
        driver.getJavaVersion();
        driver.getOSVersion();
    }
}
package com.example.vijay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class Driver {
    @Autowired
    public Environment environment;

    public void getJavaVersion() {
        System.out.println("Java Version: " + environment.getProperty("java.version"));
    }
    public void getOSVersion(){
        System.out.println("OS Version: " +System.getProperty("os.version"));
    }
}
