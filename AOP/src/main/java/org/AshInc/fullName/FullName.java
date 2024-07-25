package org.AshInc.fullName;

import org.springframework.stereotype.Component;

@Component
public class FullName {
    public String composeFullName(String fName, String lName){
        return fName+" "+lName;
    }
}
