package com.allstate.controllers;

import com.allstate.entities.EncrypDecryp;
import com.allstate.services.EncrypDecrypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class EncrypDecrypController {
    @Autowired
    private EncrypDecrypService service;

    @RequestMapping(value = "/encrypt")
    public EncrypDecryp encryptPassword(@RequestBody EncrypDecryp encryp){
        return this.service.encryptPassword(encryp);
    }
}
