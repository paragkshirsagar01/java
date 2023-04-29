package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cont {
    @Autowired
    XyzRepo xyzrepo;
    @PostMapping("/savex")
    public void savex(@RequestBody Xyz x){
        xyzrepo.save(x);
    }
}
