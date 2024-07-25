package org.AshInc.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {
    @Autowired
    Driver driver;

    @Autowired
    TrafficLight trafficLight;
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        trafficLight.switchRed();
        trafficLight.switchYellow();
        trafficLight.switchGreen();
    }
}
