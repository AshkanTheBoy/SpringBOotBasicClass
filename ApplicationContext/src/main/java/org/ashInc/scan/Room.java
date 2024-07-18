package org.ashInc.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Room {
    @Autowired
    Dog dog;

    @Autowired
    Cat cat;

    public void sound(){
        dog.sound();
        System.out.println(cat);
    }
}
