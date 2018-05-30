package com.nd.zsp.bootdemo.module.demo.controller;

import com.nd.zsp.bootdemo.module.demo.model.MyConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/properties")
public class PropertiesMyController {
    public static final Logger log = LoggerFactory.getLogger(PropertiesMyController.class);

    private final MyConfigProperties myProperties;

    @Autowired
    public PropertiesMyController(MyConfigProperties myProperties){
        this.myProperties=myProperties;
    }

    @RequestMapping(value = "/my")
    public MyConfigProperties getMyProperties() {
        log.info("==========================");
        log.info(this.myProperties.toString());
        log.info("==========================");
        return this.myProperties;
    }
}
