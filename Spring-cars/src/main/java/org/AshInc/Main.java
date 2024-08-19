package org.AshInc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.AshInc.firm.FirmJson;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        FirmJson[] firms = null;
        try {
            firms = mapper.readValue(new File("C:\\Users\\gk\\Documents\\SpringbootBasic\\Spring-cars\\src\\main\\resources\\cars.JSON"), FirmJson[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(firms[0]);
    }
} 