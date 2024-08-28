package com.example.boot01hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ComponentTest {

    public ComponentTest (){
        log.info("ComponentTest");

    }
}
