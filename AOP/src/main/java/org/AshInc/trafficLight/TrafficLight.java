package org.AshInc.trafficLight;

import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    public String switchRed(){
        return "red";
    }

    public String switchYellow(){
        return "yellow";
    }

    public String switchGreen(){
        return "green";
    }
} 