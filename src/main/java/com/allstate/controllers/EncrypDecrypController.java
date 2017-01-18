package com.allstate.controllers;

import com.allstate.entities.EncrypDecryp;
import com.allstate.services.EncrypDecrypService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EncrypDecrypController {
    @Autowired
    private EncrypDecrypService service;

    @RequestMapping(value = "/encrypt", method = RequestMethod.POST)
    public EncrypDecryp encryptPassword(@RequestBody EncrypDecryp encryp){
        return this.service.encryptPassword(encryp);
    }
    @RequestMapping(value = "/encrypt", method = RequestMethod.PUT)
    public EncrypDecryp updatepassword(@RequestBody EncrypDecryp encryp){
        return this.service.updatePassword(encryp);
    }
}
