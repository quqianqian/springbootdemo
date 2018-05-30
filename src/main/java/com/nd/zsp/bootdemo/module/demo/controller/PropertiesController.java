package com.nd.zsp.bootdemo.module.demo.controller;

import com.nd.zsp.bootdemo.module.demo.model.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/properties")
public class PropertiesController {

    public static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties myProperties;

    @Autowired
    public PropertiesController(MyProperties myProperties){
        this.myProperties=myProperties;
    }

    @RequestMapping(value = "/1")
    public MyProperties getMyProperties() {
        log.info("==========================");
        log.info(this.myProperties.toString());
        log.info("==========================");
        return this.myProperties;
    }
}
